package com.example.pawnshopmanager;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            // Kiểm tra xem đã có tài khoản admin chưa
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            if (dbHelper.hasAdminAccount()) {
                // Nếu có, đi tới màn hình Đăng nhập
                startActivity(new Intent(SplashActivity.this, LoginActivity.class));
            } else {
                // Nếu chưa, đi tới màn hình Đăng ký
                startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
            }
            finish(); // Đóng SplashActivity
        }, 1500); // Chờ 1.5 giây
    }
}
