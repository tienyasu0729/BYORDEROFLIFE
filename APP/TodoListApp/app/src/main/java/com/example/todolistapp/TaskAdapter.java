package com.example.todolistapp;

import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    private final List<Task> taskList;

    public TaskAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
        Task currentTask = taskList.get(position);
        holder.tvTaskTitle.setText(currentTask.getTitle());
        holder.cbComplete.setChecked(currentTask.isCompleted());

        // Gạch ngang chữ nếu công việc đã hoàn thành
        if (currentTask.isCompleted()) {
            holder.tvTaskTitle.setPaintFlags(holder.tvTaskTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.tvTaskTitle.setPaintFlags(holder.tvTaskTitle.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
        }

        // Xử lý sự kiện khi nhấn vào checkbox "Hoàn thành"
        holder.cbComplete.setOnClickListener(v -> {
            boolean isChecked = holder.cbComplete.isChecked();
            currentTask.setCompleted(isChecked);
            notifyItemChanged(holder.getAdapterPosition());
        });

        // Xử lý sự kiện khi nhấn nút "Xóa"
        holder.btnDelete.setOnClickListener(v -> {
            int currentPosition = holder.getAdapterPosition();
            taskList.remove(currentPosition);
            notifyItemRemoved(currentPosition);
            notifyItemRangeChanged(currentPosition, taskList.size());
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class TaskViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTaskTitle;
        public CheckBox cbComplete;
        public Button btnDelete;

        public TaskViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
            cbComplete = itemView.findViewById(R.id.cbComplete);
            btnDelete = itemView.findViewById(R.id.btnDelete);
        }
    }
}