package com.example.mytodolist; // Thay bằng tên gói của bạn

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    CheckBox cbRememberMe;
    Button btnLogin;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);
        btnLogin = findViewById(R.id.btnLogin);

        // Đặt tên cho file SharedPreferences [cite: 795]
        sharedPreferences = getSharedPreferences("TodoLoginPrefs", MODE_PRIVATE);

        // Kiểm tra xem đã đăng nhập và "Remember Me" chưa
        checkLoginStatus();

        btnLogin.setOnClickListener(v -> handleLogin());
    }

    private void checkLoginStatus() {
        // Kiểm tra xem có lưu "remember" là true không [cite: 774]
        boolean isLoggedIn = sharedPreferences.getBoolean("remember", false);

        if (isLoggedIn) {
            // Nếu có, đi thẳng vào MainActivity [cite: 775]
            goToMainActivity();
        }
        // Nếu không, ở lại màn hình Login
    }

    private void handleLogin() {
        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        // Kiểm tra username và password [cite: 771]
        if (username.equals("admin") && password.equals("123456")) {
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();

            // Nếu "Remember Me" được check, lưu lại [cite: 773]
            if (cbRememberMe.isChecked()) {
                saveLoginState(username);
            }

            goToMainActivity();

        } else {
            // Sai mật khẩu [cite: 772]
            Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveLoginState(String username) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", username);
        editor.putBoolean("remember", true); // Đặt cờ "remember"
        editor.apply(); // Lưu lại
    }

    private void goToMainActivity() {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish(); // Đóng LoginActivity để không quay lại được
    }
}