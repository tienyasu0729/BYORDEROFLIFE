package com.example.pawnshopmanager; // Đảm bảo tên gói này khớp

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Locale;
import java.util.Date;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private Context context;
    private List<Item> itemList;
    private OnItemClickListener listener;

    // Interface để xử lý click
    public interface OnItemClickListener {
        void onItemClick(Item item);
    }

    public ItemAdapter(Context context, List<Item> itemList, OnItemClickListener listener) {
        this.context = context;
        this.itemList = itemList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        Item item = itemList.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    // Cập nhật danh sách (khi tìm kiếm hoặc lọc)
    public void filterList(List<Item> filteredList) {
        this.itemList = filteredList;
        notifyDataSetChanged();
    }

    // Lớp ViewHolder
    class ItemViewHolder extends RecyclerView.ViewHolder {

        View viewStatusColor;
        TextView tvItemName, tvOwnerName, tvPrice, tvStatus, tvPawnDate, tvDueDate;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ các view từ layout list_item.xml
            viewStatusColor = itemView.findViewById(R.id.viewStatusColor);
            tvItemName = itemView.findViewById(R.id.tvItemName);
            tvOwnerName = itemView.findViewById(R.id.tvOwnerName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvPawnDate = itemView.findViewById(R.id.tvPawnDate);
            tvDueDate = itemView.findViewById(R.id.tvDueDate);
        }

        public void bind(final Item item, final OnItemClickListener listener) {
            // Hiển thị dữ liệu cơ bản
            tvItemName.setText(item.getTenVatPham());
            tvOwnerName.setText(item.getTenNguoiCam());

            // Định dạng tiền (Bạn đã sửa đúng ở đây)
            tvPrice.setText(String.format(Locale.getDefault(), "%,.0f đ", item.getGiaTienCam()));

            // === PHẦN LOGIC ĐÃ SỬA LẠI ===

            // 1. Lấy đối tượng StatusInfo từ DateLogicUtil
            DateLogicUtil.StatusInfo statusInfo = DateLogicUtil.getStatus(item.getNgayCam(), item.getType());

            // 2. Lấy ngày hết hạn
            Date dueDate = DateLogicUtil.getDueDate(item.getNgayCam(), item.getType());

            // 3. Định dạng ngày tháng
            String ngayCamDisplay = "Cầm: " + DateLogicUtil.formatDisplayDate(item.getNgayCam());
            String dueDateDisplay = "Hạn: N/A";
            if (dueDate != null) {
                // Chỉ định dạng nếu ngày hợp lệ
                dueDateDisplay = "Hạn: " + DateLogicUtil.formatDisplayDate(DateLogicUtil.parseDate(dueDate));
            }

            // 4. Gán text từ StatusInfo (đã chứa chuỗi "Quá hạn X ngày", v.v.)
            tvStatus.setText(statusInfo.text);
            tvPawnDate.setText(ngayCamDisplay);
            tvDueDate.setText(dueDateDisplay);

            // 5. Đặt màu sắc dựa trên StatusInfo
            int colorRes = getColorResFromStatus(statusInfo.colorName);

            viewStatusColor.setBackgroundColor(colorRes);
            tvStatus.setTextColor(colorRes);

            // Xử lý Click
            itemView.setOnClickListener(v -> listener.onItemClick(item));
        }

        /**
         * Hàm trợ giúp chuyển tên màu (String) từ StatusInfo sang ID màu (int)
         */
        private int getColorResFromStatus(String colorName) {
            switch (colorName) {
                case "status_overdue":
                    return ContextCompat.getColor(context, R.color.status_overdue);
                case "status_nearing":
                    return ContextCompat.getColor(context, R.color.status_nearing);
                case "status_active":
                default:
                    return ContextCompat.getColor(context, R.color.status_active);
            }
        }
    }

    // Hàm `formatDate` của bạn đã được chuyển vào `DateLogicUtil`
    // (ví dụ: `DateLogicUtil.formatDisplayDate(String)`)
    // nên chúng ta không cần nó ở đây nữa.
}