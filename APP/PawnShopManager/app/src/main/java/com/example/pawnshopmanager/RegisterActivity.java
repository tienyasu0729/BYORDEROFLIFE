package com.example.pawnshopmanager;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText etEmail, etPhone, etPassword;
    Button btnRegister;
    TextView tvLoginLink;
    DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        dbHelper = new DatabaseHelper(this);

        etEmail = findViewById(R.id.etEmail);
        etPhone = findViewById(R.id.etPhone);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginLink = findViewById(R.id.tvLoginLink);

        btnRegister.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            if (dbHelper.registerAdmin(email, phone, password)) {
                Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();
                // Chuyển sang màn hình Login
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                finish();
            } else {
                Toast.makeText(this, "Đăng ký thất bại (Email/SĐT có thể đã tồn tại)", Toast.LENGTH_SHORT).show();
            }
        });

        tvLoginLink.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            finish();
        });
    }
}