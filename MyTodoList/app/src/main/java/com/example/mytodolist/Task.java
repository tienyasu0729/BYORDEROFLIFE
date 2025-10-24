package com.example.mytodolist; // Thay bằng tên gói của bạn

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

@Entity(tableName = "tasks") // Tên của bảng
@TypeConverters(PriorityConverter.class) // Bộ chuyển đổi cho Priority
public class Task {

    @PrimaryKey(autoGenerate = true) // Khóa chính tự tăng
    private long id;

    private String title;
    private String description;
    private String deadline;
    private Priority priority;
    private boolean isCompleted;

    // Constructor Room cần
    public Task(String title, String description, String deadline, Priority priority, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    // --- Getters and Setters (Room cần tất cả) ---
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { this.isCompleted = completed; }
}