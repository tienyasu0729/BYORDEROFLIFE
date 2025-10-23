package com.example.todolistapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Task> taskList;
    private TaskAdapter taskAdapter;
    private EditText etNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        RecyclerView rvTasks = findViewById(R.id.rvTasks);
        etNewTask = findViewById(R.id.etNewTask);
        Button btnAddTask = findViewById(R.id.btnAddTask);

        // Khởi tạo danh sách công việc và adapter
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(taskList);

        // Cài đặt RecyclerView
        rvTasks.setLayoutManager(new LinearLayoutManager(this));
        rvTasks.setAdapter(taskAdapter);

        // Xử lý sự kiện nhấn nút "Thêm"
        btnAddTask.setOnClickListener(v -> {
            String taskTitle = etNewTask.getText().toString().trim();
            if (!taskTitle.isEmpty()) {
                // Thêm công việc mới vào danh sách
                taskList.add(new Task(taskTitle));
                // Thông báo cho adapter rằng có một mục mới được thêm vào cuối danh sách
                taskAdapter.notifyItemInserted(taskList.size() - 1);
                etNewTask.setText(""); // Xóa trống ô nhập liệu
            } else {
                Toast.makeText(MainActivity.this, "Vui lòng nhập tên công việc", Toast.LENGTH_SHORT).show();
            }
        });
    }
}