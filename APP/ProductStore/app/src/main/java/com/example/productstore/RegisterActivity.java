package com.example.productstore;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    // Khai báo biến
    private DatabaseHelper dbHelper;
    private EditText edtFullName, edtEmail, edtPassword, edtConfirmPassword;
    private Button btnRegister;
    private TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Khởi tạo dbHelper
        dbHelper = new DatabaseHelper(this);

        // Ánh xạ (tìm) các View từ file XML
        edtFullName = findViewById(R.id.edtFullName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirmPassword = findViewById(R.id.edtConfirmPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginLink = findViewById(R.id.tvLoginLink);

        // Xử lý sự kiện khi nhấn nút ĐĂNG KÝ
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy text người dùng nhập
                String fullName = edtFullName.getText().toString().trim();
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                String confirmPassword = edtConfirmPassword.getText().toString().trim();

                if (fullName.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    return; // Dừng lại
                }
                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) { // [cite: 10]
                    Toast.makeText(RegisterActivity.this, "Email không hợp lệ", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password.equals(confirmPassword)) { // [cite: 11]
                    Toast.makeText(RegisterActivity.this, "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 2. Gọi hàm addUser từ DatabaseHelper
                boolean success = dbHelper.addUser(fullName, email, password);

                if (success) {
                    Toast.makeText(RegisterActivity.this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                    // Đăng ký xong thì quay về màn hình Đăng nhập
                    finish(); // Đóng RegisterActivity
                } else {
                    Toast.makeText(RegisterActivity.this, "Đăng ký thất bại! Email có thể đã tồn tại.", Toast.LENGTH_LONG).show();
                }
            }
        });

        // Xử lý khi nhấn link "Đã có tài khoản? Đăng nhập"
        tvLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Đóng màn hình này
            }
        });
    }
}