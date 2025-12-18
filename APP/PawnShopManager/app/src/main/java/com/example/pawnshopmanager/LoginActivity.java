package com.example.pawnshopmanager;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etEmailOrPhone, etPassword;
    Button btnLogin;
    TextView tvRegisterLink;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dbHelper = new DatabaseHelper(this);

        etEmailOrPhone = findViewById(R.id.etEmailOrPhone);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink);

        btnLogin.setOnClickListener(v -> {
            String emailOrPhone = etEmailOrPhone.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (emailOrPhone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dbHelper.checkAdminLogin(emailOrPhone, password)) {
                Toast.makeText(this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                // Chuyển sang màn hình chính
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finishAffinity(); // Đóng tất cả các activity login/register
            } else {
                Toast.makeText(this, "Sai Email/SĐT hoặc Mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        tvRegisterLink.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
        });
    }
}