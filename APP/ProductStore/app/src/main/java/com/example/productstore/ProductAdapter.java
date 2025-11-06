package com.example.productstore;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button; // Import mới
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private Context context;
    private List<Product> productList;
    private OnProductListener listener; // Biến interface để xử lý click

    // (CẬP NHẬT) Interface để xử lý sự kiện click
    public interface OnProductListener {
        void onEditClick(Product product);
        void onDeleteClick(Product product);
        void onAddToCartClick(Product product); // <-- HÀM MỚI
    }

    // Constructor
    public ProductAdapter(Context context, List<Product> productList, OnProductListener listener) {
        this.context = context;
        this.productList = productList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    /**
     * (CẬP NHẬT) Gán dữ liệu và xử lý click
     */
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        // Lấy sản phẩm tại vị trí hiện tại
        Product product = productList.get(position);

        // Gán dữ liệu lên View
        holder.tvProductName.setText(product.getName());
        holder.tvProductDesc.setText(product.getDescription());
        holder.tvProductPrice.setText(String.format("%.0f VNĐ", product.getPrice()));

        // --- Xử lý sự kiện click (Tôi sửa lại dùng OnClickListener cho đồng bộ) ---

        holder.imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onEditClick(product);
            }
        });

        holder.imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteClick(product);
            }
        });

        // (MỚI) Xử lý sự kiện click Thêm vào giỏ
        holder.btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAddToCartClick(product); // Gọi hàm interface
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    /**
     * (CẬP NHẬT) Lớp ViewHolder
     */
    public class ProductViewHolder extends RecyclerView.ViewHolder {
        ImageView imgProduct, imgEdit, imgDelete;
        TextView tvProductName, tvProductDesc, tvProductPrice;
        Button btnAddToCart; // <-- BIẾN MỚI

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            // Ánh xạ View
            imgProduct = itemView.findViewById(R.id.imgProduct);
            tvProductName = itemView.findViewById(R.id.tvProductName);
            tvProductDesc = itemView.findViewById(R.id.tvProductDesc);
            tvProductPrice = itemView.findViewById(R.id.tvProductPrice);
            imgEdit = itemView.findViewById(R.id.imgEdit);
            imgDelete = itemView.findViewById(R.id.imgDelete);

            // Ánh xạ nút mới
            btnAddToCart = itemView.findViewById(R.id.btnAddToCart); // <-- DÒNG MỚI
        }
    }

    // Hàm cập nhật dữ liệu (Không đổi)
    public void setProducts(List<Product> newList) {
        this.productList = newList;
        notifyDataSetChanged();
    }
}