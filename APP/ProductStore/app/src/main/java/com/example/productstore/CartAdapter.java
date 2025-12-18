package com.example.productstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<CartItem> cartList;
    private OnCartListener listener;

    // Interface để giao tiếp với Activity (tăng, giảm, xóa)
    public interface OnCartListener {
        void onIncreaseQuantity(CartItem item);
        void onDecreaseQuantity(CartItem item);
        void onRemoveItem(CartItem item);
    }

    public CartAdapter(Context context, List<CartItem> cartList, OnCartListener listener) {
        this.context = context;
        this.cartList = cartList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        CartItem item = cartList.get(position);

        holder.tvName.setText(item.getProductName());
        holder.tvPrice.setText(String.format("%.0f VNĐ", item.getProductPrice()));
        holder.tvQuantity.setText(String.valueOf(item.getQuantity()));

        // Tính tổng tiền cho item này
        double itemTotal = item.getProductPrice() * item.getQuantity();
        holder.tvItemTotal.setText(String.format("Tổng: %.0f VNĐ", itemTotal));

        // Gán sự kiện click cho các nút
        holder.btnIncrease.setOnClickListener(v -> listener.onIncreaseQuantity(item));
        holder.btnDecrease.setOnClickListener(v -> listener.onDecreaseQuantity(item));
        holder.imgRemove.setOnClickListener(v -> listener.onRemoveItem(item));
    }

    @Override
    public int getItemCount() {
        return cartList.size();
    }

    // Lớp ViewHolder
    public class CartViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice, tvQuantity, tvItemTotal;
        Button btnIncrease, btnDecrease;
        ImageView imgRemove;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvCartProductName);
            tvPrice = itemView.findViewById(R.id.tvCartProductPrice);
            tvQuantity = itemView.findViewById(R.id.tvCartQuantity);
            tvItemTotal = itemView.findViewById(R.id.tvCartItemTotal);
            btnIncrease = itemView.findViewById(R.id.btnIncreaseQuantity);
            btnDecrease = itemView.findViewById(R.id.btnDecreaseQuantity);
            imgRemove = itemView.findViewById(R.id.imgRemoveFromCart);
        }
    }

    // Hàm để cập nhật dữ liệu
    public void setCartItems(List<CartItem> newList) {
        this.cartList = newList;
        notifyDataSetChanged();
    }
}
