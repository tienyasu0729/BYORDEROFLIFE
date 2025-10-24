package com.example.mytodolist; // Thay bằng tên gói của bạn

public class Task {
    private String title;
    private String description;
    private String deadline;
    private Priority priority;
    private boolean isCompleted;

    // Thêm một ID duy nhất để tiện quản lý
    private long id;

    public Task(long id, String title, String description, String deadline, Priority priority, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = isCompleted;
    }

    // Getters and Setters cho tất cả các trường
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDeadline() { return deadline; }
    public void setDeadline(String deadline) { this.deadline = deadline; }

    public Priority getPriority() { return priority; }
    public void setPriority(Priority priority) { this.priority = priority; }

    public boolean isCompleted() { return isCompleted; }
    public void setCompleted(boolean completed) { isCompleted = completed; }

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }
}