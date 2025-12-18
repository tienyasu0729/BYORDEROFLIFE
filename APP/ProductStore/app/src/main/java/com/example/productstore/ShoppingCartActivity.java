package com.example.productstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity implements CartAdapter.OnCartListener {

    private RecyclerView recyclerViewCart;
    private TextView tvTotalPrice;
    private Button btnCheckout;

    private DatabaseHelper dbHelper;
    private CartAdapter adapter;
    private List<CartItem> cartList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // 1. Khởi tạo
        dbHelper = new DatabaseHelper(this);
        cartList = new ArrayList<>();

        // 2. Ánh xạ View
        recyclerViewCart = findViewById(R.id.recyclerViewCart);
        tvTotalPrice = findViewById(R.id.tvTotalPrice);
        btnCheckout = findViewById(R.id.btnCheckout);

        // 3. Cài đặt Adapter
        adapter = new CartAdapter(this, cartList, this);
        recyclerViewCart.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewCart.setAdapter(adapter);

        // 4. Tải dữ liệu giỏ hàng
        loadCartItems();

        // 5. (ĐÃ CẬP NHẬT Ở BƯỚC 23) Xử lý nút Checkout
        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Lấy tổng tiền (tính lại cho chắc chắn)
                double totalAmount = 0;
                for (CartItem item : cartList) {
                    totalAmount += item.getProductPrice() * item.getQuantity();
                }

                // Tạo biến final để dùng trong Dialog
                final double finalTotal = totalAmount;

                // Kiểm tra xem giỏ hàng có rỗng không
                if (finalTotal == 0) {
                    Toast.makeText(ShoppingCartActivity.this, "Giỏ hàng của bạn đang rỗng", Toast.LENGTH_SHORT).show();
                    return;
                }

                new AlertDialog.Builder(ShoppingCartActivity.this)
                        .setTitle("Xác nhận Thanh toán")
                        .setMessage("Bạn đồng ý thanh toán với tổng số tiền là " + String.format("%.0f VNĐ", finalTotal) + "?")
                        .setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                // (MỚI) 1. Ghi lại đơn hàng vào DB
                                dbHelper.addOrder(finalTotal);

                                // 2. Xóa giỏ hàng
                                dbHelper.clearCart();

                                // 3. Tải lại (giỏ hàng sẽ rỗng)
                                loadCartItems();

                                Toast.makeText(ShoppingCartActivity.this, "Thanh toán thành công!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("Hủy", null)
                        .show();
            }
        });
    }

    /**
     * Tải danh sách item trong giỏ hàng từ DB
     */
    private void loadCartItems() {
        cartList = dbHelper.getCartItems();
        adapter.setCartItems(cartList);
        updateTotalPrice();
    }

    /**
     * Cập nhật tổng tiền
     */
    private void updateTotalPrice() {
        double total = 0;
        for (CartItem item : cartList) {
            total += item.getProductPrice() * item.getQuantity();
        }
        tvTotalPrice.setText(String.format("Tổng tiền: %.0f VNĐ", total));
    }

    // --- Thực thi 3 hàm của OnCartListener ---

    @Override
    public void onIncreaseQuantity(CartItem item) {
        int newQuantity = item.getQuantity() + 1;
        dbHelper.updateCartItemQuantity(item.getCartId(), newQuantity);
        loadCartItems(); // Tải lại để cập nhật
    }

    @Override
    public void onDecreaseQuantity(CartItem item) {
        if (item.getQuantity() > 1) {
            int newQuantity = item.getQuantity() - 1;
            dbHelper.updateCartItemQuantity(item.getCartId(), newQuantity);
        } else {
            // Nếu số lượng là 1, nhấn giảm sẽ xóa luôn
            onRemoveItem(item);
        }
        loadCartItems(); // Tải lại
    }

    @Override
    public void onRemoveItem(CartItem item) {
        new AlertDialog.Builder(this)
                .setTitle("Xóa Sản Phẩm")
                .setMessage("Bạn muốn xóa " + item.getProductName() + " khỏi giỏ hàng?")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    dbHelper.removeCartItem(item.getCartId());
                    loadCartItems(); // Tải lại
                    Toast.makeText(this, "Đã xóa", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Hủy", null)
                .show();
    }
}