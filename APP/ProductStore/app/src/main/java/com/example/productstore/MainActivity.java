package com.example.productstore;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến
    private DatabaseHelper dbHelper;
    private SharedPreferences sharedPreferences;
    private EditText edtEmail, edtPassword;
    private CheckBox cbRememberMe;
    private Button btnLogin;
    private TextView tvRegisterLink;

    // Hằng số cho SharedPreferences (dùng cho "Remember Me")
    private static final String PREFS_NAME = "MyPrefs";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";
    private static final String KEY_REMEMBER = "remember";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Kết nối với file activity_main.xml

        // 1. Khởi tạo
        dbHelper = new DatabaseHelper(this); // Khởi tạo DatabaseHelper
        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        // 2. Ánh xạ (tìm) các View từ file XML
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink);

        // 3. Tải thông tin đã lưu (nếu có)
        loadCredentials();

        // 4. Xử lý sự kiện khi nhấn nút ĐĂNG NHẬP
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy text từ EditText
                String email = edtEmail.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();

                // Kiểm tra nhập liệu
                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập email và mật khẩu", Toast.LENGTH_SHORT).show();
                    return; // Dừng lại
                }

                // 1. Gọi hàm checkUserLogin từ DatabaseHelper
                boolean success = dbHelper.checkUserLogin(email, password);

                if (success) {
                    // 2. Đăng nhập thành công
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();

                    // 3. Xử lý "Remember Me"
                    saveCredentials(email, password, cbRememberMe.isChecked());

                    // 4. Chuyển sang màn hình Danh sách Sản phẩm
                    // (Đây là đoạn code đã được "mở khóa")
                    Intent intent = new Intent(MainActivity.this, ProductListActivity.class);
                    startActivity(intent);
                    finish(); // Đóng màn hình Login

                } else {
                    // Đăng nhập thất bại
                    Toast.makeText(MainActivity.this, "Sai email hoặc mật khẩu!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // 5. Xử lý khi nhấn link "Đăng ký ngay"
        tvRegisterLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Mở màn hình RegisterActivity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * Hàm lưu thông tin vào SharedPreferences
     */
    private void saveCredentials(String email, String pass, boolean remember) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (remember) {
            // Nếu check "Ghi nhớ", thì lưu lại
            editor.putString(KEY_EMAIL, email);
            editor.putString(KEY_PASSWORD, pass);
            editor.putBoolean(KEY_REMEMBER, true);
        } else {
            // Nếu không check, thì xóa thông tin đã lưu
            editor.clear();
        }
        editor.apply(); // Áp dụng thay đổi
    }

    /**
     * Hàm tải thông tin từ SharedPreferences
     */
    private void loadCredentials() {
        boolean remember = sharedPreferences.getBoolean(KEY_REMEMBER, false);
        if (remember) {
            // Nếu lần trước đã chọn "Ghi nhớ"
            edtEmail.setText(sharedPreferences.getString(KEY_EMAIL, ""));
            edtPassword.setText(sharedPreferences.getString(KEY_PASSWORD, ""));
            cbRememberMe.setChecked(true);
        }
    }
}