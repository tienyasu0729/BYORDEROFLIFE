package com.example.mytodolist; // Thay bằng tên gói của bạn

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private SearchView searchView;
    private ImageButton btnFilter;
    private TextView tvSummary;
    private TabLayout tabLayout;
    private RecyclerView recyclerView;
    private FloatingActionButton fabAddTask;

    private TodoAdapter adapter;
    private List<Task> allTasks = new ArrayList<>(); // Danh sách GỐC
    private SharedPreferences sharedPreferences;
    private String currentUsername = "User";

    // Biến cho Database
    private TaskDatabase taskDatabase;
    private TaskDao taskDao;

    // Biến để chạy nền
    private ExecutorService databaseExecutor;
    private Handler mainThreadHandler;

    private String currentSearchQuery = "";
    private Priority currentPriorityFilter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lấy username từ LoginActivity
        currentUsername = getIntent().getStringExtra("USERNAME");
        if (currentUsername == null) {
            currentUsername = "User";
        }

        // 1. Ánh xạ Views
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.searchView);
        btnFilter = findViewById(R.id.btnFilter);
        tvSummary = findViewById(R.id.tvSummary);
        tabLayout = findViewById(R.id.tabLayout);
        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);

        // 2. Setup Toolbar
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Welcome, " + currentUsername + "!");

        // 3. Setup SharedPreferences (cho Logout)
        sharedPreferences = getSharedPreferences("TodoLoginPrefs", MODE_PRIVATE);

        // 4. Setup Database và Executor
        databaseExecutor = Executors.newSingleThreadExecutor();
        mainThreadHandler = new Handler(Looper.getMainLooper());
        taskDatabase = TaskDatabase.getDatabase(this);
        taskDao = taskDatabase.taskDao();

        // 5. Setup RecyclerView
        setupRecyclerView();

        // 6. Load dữ liệu từ Database
        loadTasksFromDatabase();

        // 7. Setup Listeners
        setupFABListener();
        setupAdapterListeners();
        setupTabLayoutListener();
        setupSearchListener();
    }

    private void setupRecyclerView() {
        adapter = new TodoAdapter(this, new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void loadTasksFromDatabase() {
        databaseExecutor.execute(() -> {
            allTasks = taskDao.getAllTasks();
            mainThreadHandler.post(() -> {
                filterAndRefreshList();
            });
        });
    }

    private void setupFABListener() {
        fabAddTask.setOnClickListener(v -> showTaskDialog(null));
    }

    private void setupAdapterListeners() {
        adapter.setOnTaskClickListener(new TodoAdapter.OnTaskClickListener() {
            @Override
            public void onCompleteClick(Task task) {
                task.setCompleted(!task.isCompleted());
                databaseExecutor.execute(() -> {
                    taskDao.update(task);
                    mainThreadHandler.post(() -> filterAndRefreshList());
                });
            }

            @Override
            public void onDeleteClick(Task task) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Delete Task")
                        .setMessage("Are you sure you want to delete?")
                        .setPositiveButton("Yes", (dialog, which) -> {
                    databaseExecutor.execute(() -> {
                        taskDao.delete(task);
                        allTasks.removeIf(t -> t.getId() == task.getId());
                        mainThreadHandler.post(() -> filterAndRefreshList());
                    });
                })
                        .setNegativeButton("No", null)
                        .show();
            }

            @Override
            public void onEditClick(Task task) {
                showTaskDialog(task); //
            }
        });
    }

    private void setupTabLayoutListener() {
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 1: currentPriorityFilter = Priority.HIGH; break;
                    case 2: currentPriorityFilter = Priority.MEDIUM; break;
                    case 3: currentPriorityFilter = Priority.LOW; break;
                    case 0: default: currentPriorityFilter = null;
                }
                filterAndRefreshList();
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setupSearchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override public boolean onQueryTextSubmit(String query) { return false; }
            @Override
            public boolean onQueryTextChange(String newText) {
                currentSearchQuery = newText.toLowerCase().trim();
                filterAndRefreshList();
                return true;
            }
        });
    }

    private void filterAndRefreshList() {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : allTasks) {
            boolean priorityMatch = (currentPriorityFilter == null) || (task.getPriority() == currentPriorityFilter);
            boolean searchMatch = currentSearchQuery.isEmpty() ||
                    task.getTitle().toLowerCase().contains(currentSearchQuery) ||
                    task.getDescription().toLowerCase().contains(currentSearchQuery);

            if (priorityMatch && searchMatch) {
                filteredTasks.add(task);
            }
        }

        adapter.filterList(filteredTasks);
        updateSummary();
    }

    private void updateSummary() {
        long incompleteCount = allTasks.stream().filter(t -> !t.isCompleted()).count();
        long completedCount = allTasks.stream().filter(Task::isCompleted).count();
        tvSummary.setText(completedCount + " completed / " + incompleteCount + " incomplete");
    }

    // DÁN ĐÈ HÀM NÀY
    private void showTaskDialog(Task taskToEdit) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_task, null);
        builder.setView(dialogView);

        TextView tvDialogTitle = dialogView.findViewById(R.id.tvDialogTitle);
        EditText etTaskTitle = dialogView.findViewById(R.id.etTaskTitle);
        EditText etTaskDesc = dialogView.findViewById(R.id.etTaskDesc);
        EditText etTaskDeadline = dialogView.findViewById(R.id.etTaskDeadline);
        RadioGroup rgPriority = dialogView.findViewById(R.id.rgPriority);
        RadioButton rbHigh = dialogView.findViewById(R.id.rbHigh);
        RadioButton rbMedium = dialogView.findViewById(R.id.rbMedium);
        RadioButton rbLow = dialogView.findViewById(R.id.rbLow);

        boolean isEditMode = (taskToEdit != null);

        if (isEditMode) {
            tvDialogTitle.setText("Save Task");
            etTaskTitle.setText(taskToEdit.getTitle());
            etTaskDesc.setText(taskToEdit.getDescription());
            etTaskDeadline.setText(taskToEdit.getDeadline());
            switch (taskToEdit.getPriority()) {
                case HIGH: rbHigh.setChecked(true); break;
                case MEDIUM: rbMedium.setChecked(true); break;
                case LOW: rbLow.setChecked(true); break;
            }
        } else {
            tvDialogTitle.setText("Add Task");
        }

        builder.setPositiveButton(isEditMode ? "Save" : "Add", (dialog, which) -> {
            String title = etTaskTitle.getText().toString().trim();
            if (title.isEmpty()) {
                Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            String desc = etTaskDesc.getText().toString().trim();
            String deadline = etTaskDeadline.getText().toString().trim();

            // --- BẮT ĐẦU SỬA LỖI ---
            int selectedPriorityId = rgPriority.getCheckedRadioButtonId();

            // Khai báo là 'final' và chỉ gán 1 lần
            final Priority priority;
            if (selectedPriorityId == R.id.rbHigh) {
                priority = Priority.HIGH;
            } else if (selectedPriorityId == R.id.rbLow) {
                priority = Priority.LOW;
            } else {
                priority = Priority.MEDIUM;
            }
            // --- KẾT THÚC SỬA LỖI ---

            databaseExecutor.execute(() -> {
                if (isEditMode) {
                    taskToEdit.setTitle(title);
                    taskToEdit.setDescription(desc);
                    taskToEdit.setDeadline(deadline);
                    taskToEdit.setPriority(priority); // Lỗi 265 đã sửa
                    taskDao.update(taskToEdit);
                } else {
                    Task newTask = new Task(title, desc, deadline, priority, false); // Lỗi 268 đã sửa
                    taskDao.insert(newTask);
                }

                allTasks = taskDao.getAllTasks();
                mainThreadHandler.post(() -> filterAndRefreshList());
            });
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }

    // --- Code cho Menu (bao gồm Logout) ---
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        if (itemId == R.id.action_search) {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (itemId == R.id.action_filter) {
            Toast.makeText(this, "Filter clicked", Toast.LENGTH_SHORT).show();
            return true;

        } else if (itemId == R.id.action_logout) {
            handleLogout();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void handleLogout() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear(); // Xóa "username" và cờ "remember"
        editor.apply();

        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}