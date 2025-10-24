package com.example.mytodolist; // Thay bằng tên gói của bạn

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

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
    private long nextTaskId = 0; // Để tạo ID duy nhất

    private String currentSearchQuery = "";
    private Priority currentPriorityFilter = null; // null = All

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Ánh xạ tất cả Views
        toolbar = findViewById(R.id.toolbar);
        searchView = findViewById(R.id.searchView);
        btnFilter = findViewById(R.id.btnFilter);
        tvSummary = findViewById(R.id.tvSummary);
        tabLayout = findViewById(R.id.tabLayout);
        recyclerView = findViewById(R.id.recyclerView);
        fabAddTask = findViewById(R.id.fabAddTask);
        // 2. Setup Toolbar
        setSupportActionBar(toolbar);
        // Bỏ code tải ảnh Glide (nếu có)

        // 3. Setup RecyclerView
        setupRecyclerView();

        // 4. Load dữ liệu mẫu
        loadSampleData();

        // 5. Setup Listeners
        setupFABListener();
        setupAdapterListeners();
        setupTabLayoutListener();
        setupSearchListener();

        // 6. Cập nhật UI lần đầu
        filterAndRefreshList();
    }

    private void setupRecyclerView() {
        // Khởi tạo adapter với danh sách rỗng (sẽ được cập nhật)
        adapter = new TodoAdapter(this, new ArrayList<>());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void setupFABListener() {
        fabAddTask.setOnClickListener(v -> showAddTaskDialog(null));
    }

    private void setupAdapterListeners() {
        adapter.setOnTaskClickListener(new TodoAdapter.OnTaskClickListener() {
            @Override
            public void onCompleteClick(Task task) {
                task.setCompleted(!task.isCompleted()); // Toggle
                filterAndRefreshList(); // Cập nhật UI
            }

            @Override
            public void onDeleteClick(Task task) {
                allTasks.removeIf(t -> t.getId() == task.getId());
                filterAndRefreshList(); // Cập nhật UI
            }

            @Override
            public void onEditClick(Task task) {
                showAddTaskDialog(task); // Mở dialog ở chế độ Edit
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
                    case 0:
                    default: currentPriorityFilter = null; // All
                }
                filterAndRefreshList();
            }
            @Override public void onTabUnselected(TabLayout.Tab tab) {}
            @Override public void onTabReselected(TabLayout.Tab tab) {}
        });
    }

    private void setupSearchListener() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                currentSearchQuery = query.toLowerCase().trim();
                filterAndRefreshList();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                currentSearchQuery = newText.toLowerCase().trim();
                filterAndRefreshList();
                return true;
            }
        });
    }

    // Hàm LỌC VÀ CẬP NHẬT TRUNG TÂM
    private void filterAndRefreshList() {
        // 1. Lọc danh sách
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

        // 2. Cập nhật Adapter
        adapter.filterList(filteredTasks);

        // 3. Cập nhật summary
        updateSummary();
    }

    // Cập nhật text "X completed / Y incomplete"
    private void updateSummary() {
        long incompleteCount = allTasks.stream().filter(t -> !t.isCompleted()).count();
        long completedCount = allTasks.stream().filter(Task::isCompleted).count();
        tvSummary.setText(completedCount + " completed / " + incompleteCount + " incomplete");
    }

    // Hiển thị Dialog để Thêm hoặc Sửa Task
    private void showAddTaskDialog(Task taskToEdit) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = this.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_task, null);
        builder.setView(dialogView);

        // Ánh xạ các view trong dialog
        TextView tvDialogTitle = dialogView.findViewById(R.id.tvDialogTitle);
        EditText etTaskTitle = dialogView.findViewById(R.id.etTaskTitle);
        EditText etTaskDesc = dialogView.findViewById(R.id.etTaskDesc);
        EditText etTaskDeadline = dialogView.findViewById(R.id.etTaskDeadline);
        RadioGroup rgPriority = dialogView.findViewById(R.id.rgPriority);
        RadioButton rbHigh = dialogView.findViewById(R.id.rbHigh);
        RadioButton rbMedium = dialogView.findViewById(R.id.rbMedium);
        RadioButton rbLow = dialogView.findViewById(R.id.rbLow);

        // Kiểm tra xem đây là Sửa hay Thêm mới
        boolean isEditMode = (taskToEdit != null);

        if (isEditMode) {
            tvDialogTitle.setText("Edit Task");
            etTaskTitle.setText(taskToEdit.getTitle());
            etTaskDesc.setText(taskToEdit.getDescription());
            etTaskDeadline.setText(taskToEdit.getDeadline());
            switch (taskToEdit.getPriority()) {
                case HIGH: rbHigh.setChecked(true); break;
                case MEDIUM: rbMedium.setChecked(true); break;
                case LOW: rbLow.setChecked(true); break;
            }
        } else {
            tvDialogTitle.setText("New Task");
        }

        builder.setPositiveButton(isEditMode ? "Save" : "Add", (dialog, which) -> {
            String title = etTaskTitle.getText().toString().trim();
            String desc = etTaskDesc.getText().toString().trim();
            String deadline = etTaskDeadline.getText().toString().trim();

            if (title.isEmpty()) {
                Toast.makeText(this, "Title cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }

            int selectedPriorityId = rgPriority.getCheckedRadioButtonId();
            Priority priority = Priority.MEDIUM; // Default
            if (selectedPriorityId == R.id.rbHigh) priority = Priority.HIGH;
            else if (selectedPriorityId == R.id.rbLow) priority = Priority.LOW;
            if (isEditMode) {
                // Cập nhật task cũ
                taskToEdit.setTitle(title);
                taskToEdit.setDescription(desc);
                taskToEdit.setDeadline(deadline);
                taskToEdit.setPriority(priority);
            } else {
                // Thêm task mới
                Task newTask = new Task(nextTaskId++, title, desc, deadline, priority, false);
                allTasks.add(0, newTask); // Thêm vào đầu danh sách
            }

            filterAndRefreshList(); // Cập nhật toàn bộ UI
        });

        builder.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());
        builder.create().show();
    }


    private void loadSampleData() {
        allTasks.add(new Task(nextTaskId++, "Buy groceries", "Milk, eggs, bread, and fruits", "2025-10-15", Priority.MEDIUM, false));
        allTasks.add(new Task(nextTaskId++, "Do homework", "Math exercises chapter 4", "2025-10-20", Priority.HIGH, true)); // 1 task đã xong
        allTasks.add(new Task(nextTaskId++, "Read a book", "Finish 'Atomic Habits'", "2025-10-20", Priority.LOW, false));
        allTasks.add(new Task(nextTaskId++, "Exercise", "30 minutes of cardio", "2025-10-17", Priority.MEDIUM, false));
        allTasks.add(new Task(nextTaskId++, "Call mom", "Check in and say hi", "2025-10-16", Priority.LOW, false));
        allTasks.add(new Task(nextTaskId++, "Project deadline", "Submit the final report", "2025-10-18", Priority.HIGH, false));
    }

    // Bỏ các hàm onCreateOptionsMenu và onOptionsItemSelected cũ
}