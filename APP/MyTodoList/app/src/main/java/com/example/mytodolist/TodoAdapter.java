package com.example.mytodolist; // Thay bằng tên gói của bạn

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> {

    private List<Task> taskList;
    private OnTaskClickListener listener;
    private Context context;

    public interface OnTaskClickListener {
        void onCompleteClick(Task task);
        void onDeleteClick(Task task);
        void onEditClick(Task task);
    }

    public void setOnTaskClickListener(OnTaskClickListener listener) {
        this.listener = listener;
    }

    public TodoAdapter(Context context, List<Task> taskList) {
        this.context = context;
        this.taskList = taskList;
    }

    public void filterList(List<Task> filteredList) {
        this.taskList = filteredList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // ĐÂY LÀ CÁC BIẾN CỦA BẠN
        ConstraintLayout itemHeader;
        ImageView ivPriorityIcon, ivComplete, ivEdit, ivDelete;
        TextView tvPriority, tvTaskTitle, tvTaskDescription, tvTaskDeadline;

        public ViewHolder(View itemView) {
            super(itemView);

            // ĐÂY LÀ KHỐI QUAN TRỌNG CẦN KIỂM TRA
            // Đảm bảo tất cả 9 ID này khớp 100% với file item_todo.xml
            itemHeader = itemView.findViewById(R.id.itemHeader); // <-- LỖI CỦA BẠN RẤT CÓ THỂ Ở ĐÂY
            ivPriorityIcon = itemView.findViewById(R.id.ivPriorityIcon);
            ivComplete = itemView.findViewById(R.id.ivComplete);
            ivEdit = itemView.findViewById(R.id.ivEdit);
            ivDelete = itemView.findViewById(R.id.ivDelete);
            tvPriority = itemView.findViewById(R.id.tvPriority);
            tvTaskTitle = itemView.findViewById(R.id.tvTaskTitle);
            tvTaskDescription = itemView.findViewById(R.id.tvTaskDescription);
            tvTaskDeadline = itemView.findViewById(R.id.tvTaskDeadline);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_todo, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = taskList.get(position);

        holder.tvTaskTitle.setText(task.getTitle());
        holder.tvTaskDescription.setText(task.getDescription());
        holder.tvTaskDeadline.setText("Deadline: " + task.getDeadline());
        holder.tvPriority.setText(task.getPriority().name());

        int colorRes;
        switch (task.getPriority()) {
            case HIGH:
                colorRes = R.color.priority_high;
                break;
            case MEDIUM:
                colorRes = R.color.priority_medium;
                break;
            case LOW:
            default:
                colorRes = R.color.priority_low;
                break;
        }

        // ĐÂY LÀ DÒNG BÁO LỖI (Dòng 93)
        // Nếu holder.itemHeader bị null, nó sẽ crash ở đây
        holder.itemHeader.setBackgroundColor(context.getColor(colorRes));

        if (task.isCompleted()) {
            holder.tvTaskTitle.setPaintFlags(holder.tvTaskTitle.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            holder.ivComplete.setImageResource(R.drawable.ic_check_filled);
        } else {
            holder.tvTaskTitle.setPaintFlags(holder.tvTaskTitle.getPaintFlags() & (~Paint.STRIKE_THRU_TEXT_FLAG));
            holder.ivComplete.setImageResource(R.drawable.ic_check_empty);
        }

        holder.ivComplete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onCompleteClick(task);
            }
        });

        holder.ivEdit.setOnClickListener(v -> {
            if (listener != null) {
                listener.onEditClick(task);
            }
        });

        holder.ivDelete.setOnClickListener(v -> {
            if (listener != null) {
                listener.onDeleteClick(task);
            }
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }
}