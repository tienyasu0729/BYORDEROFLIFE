package com.example.productstore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddEditProductActivity extends AppCompatActivity {

    // Khai báo View
    private TextView tvTitle;
    private EditText edtProductName, edtProductDesc, edtProductPrice, edtProductImage;
    private Button btnSaveProduct;

    // Khai báo DB
    private DatabaseHelper dbHelper;

    // Biến để lưu trạng thái
    private int currentProductId = -1; // -1 nghĩa là "Thêm mới"

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_product);

        // 1. Khởi tạo
        dbHelper = new DatabaseHelper(this);

        // 2. Ánh xạ View
        tvTitle = findViewById(R.id.tvTitle);
        edtProductName = findViewById(R.id.edtProductName);
        edtProductDesc = findViewById(R.id.edtProductDesc);
        edtProductPrice = findViewById(R.id.edtProductPrice);
        edtProductImage = findViewById(R.id.edtProductImage);
        btnSaveProduct = findViewById(R.id.btnSaveProduct);

        // 3. Lấy ID được gửi từ ProductListActivity
        currentProductId = getIntent().getIntExtra("EXTRA_PRODUCT_ID", -1);

        // 4. Kiểm tra xem đây là THÊM hay SỬA
        if (currentProductId == -1) {
            // Chế độ THÊM MỚI
            tvTitle.setText("Thêm Sản Phẩm Mới");
            // Giữ nguyên text nút "Lưu Sản Phẩm"
        } else {
            // Chế độ SỬA (UPDATE)
            tvTitle.setText("Sửa Sản Phẩm");
            btnSaveProduct.setText("Cập Nhật");
            // Tải dữ liệu cũ của sản phẩm lên
            loadProductData();
        }

        // 5. Xử lý sự kiện nhấn nút LƯU / CẬP NHẬT
        btnSaveProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProduct();
            }
        });
    }

    /**
     * Tải dữ liệu của sản phẩm (dùng cho chế độ SỬA)
     */
    private void loadProductData() {
        // Gọi hàm getProductById từ DB (được thêm ở Bước 11)
        Product product = dbHelper.getProductById(currentProductId);

        if (product != null) {
            edtProductName.setText(product.getName());
            edtProductDesc.setText(product.getDescription());
            edtProductPrice.setText(String.valueOf(product.getPrice()));
            edtProductImage.setText(product.getImageUrl());
        } else {
            // Xử lý trường hợp không tìm thấy ID (ví dụ: sản phẩm vừa bị xóa)
            Toast.makeText(this, "Không tìm thấy sản phẩm", Toast.LENGTH_SHORT).show();
            finish(); // Đóng Activity
        }
    }

    /**
     * Lưu (Thêm mới) hoặc Cập nhật (Sửa) sản phẩm
     */
    private void saveProduct() {
        // 1. Lấy dữ liệu từ EditText
        String name = edtProductName.getText().toString().trim();
        String desc = edtProductDesc.getText().toString().trim();
        String priceStr = edtProductPrice.getText().toString().trim();
        String image = edtProductImage.getText().toString().trim(); // Link ảnh

        // 2. Kiểm tra (Validate)
        if (name.isEmpty() || desc.isEmpty() || priceStr.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập Tên, Mô tả và Giá", Toast.LENGTH_SHORT).show();
            return; // Dừng lại
        }

        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Giá không hợp lệ", Toast.LENGTH_SHORT).show();
            return; // Dừng lại
        }

        // 3. Quyết định THÊM hay SỬA
        if (currentProductId == -1) {
            // THÊM MỚI
            boolean success = dbHelper.addProduct(name, desc, price, image);
            if (success) {
                Toast.makeText(this, "Thêm sản phẩm thành công", Toast.LENGTH_SHORT).show();
                finish(); // Đóng Activity và quay lại danh sách
            } else {
                Toast.makeText(this, "Thêm thất bại", Toast.LENGTH_SHORT).show();
            }
        } else {
            // CẬP NHẬT (SỬA)
            int rowsAffected = dbHelper.updateProduct(currentProductId, name, desc, price, image);
            if (rowsAffected > 0) {
                Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
                finish(); // Đóng Activity và quay lại danh sách
            } else {
                Toast.makeText(this, "Cập nhật thất bại", Toast.LENGTH_SHORT).show();
            }
        }
    }
}