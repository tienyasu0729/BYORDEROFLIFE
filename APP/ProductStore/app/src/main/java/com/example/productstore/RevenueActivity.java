package com.example.productstore;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class RevenueActivity extends AppCompatActivity {

    private TextView tvTotalRevenue, tvFilteredRevenue;
    private Button btnStartDate, btnEndDate, btnFilter;
    private DatabaseHelper dbHelper;

    // Biến để lưu ngày đã chọn
    private long startDateTimestamp = 0;
    private long endDateTimestamp = 0;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_revenue);

        // 1. Khởi tạo
        dbHelper = new DatabaseHelper(this);
        calendar = Calendar.getInstance();

        // 2. Ánh xạ View
        tvTotalRevenue = findViewById(R.id.tvTotalRevenue);
        tvFilteredRevenue = findViewById(R.id.tvFilteredRevenue);
        btnStartDate = findViewById(R.id.btnStartDate);
        btnEndDate = findViewById(R.id.btnEndDate);
        btnFilter = findViewById(R.id.btnFilter);

        // 3. Tải tổng doanh thu (toàn thời gian)
        loadTotalRevenue();

        // 4. Xử lý chọn ngày bắt đầu
        btnStartDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(true); // true = là ngày bắt đầu
            }
        });

        // 5. Xử lý chọn ngày kết thúc
        btnEndDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog(false); // false = là ngày kết thúc
            }
        });

        // 6. Xử lý nút Lọc
        btnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startDateTimestamp == 0 || endDateTimestamp == 0) {
                    Toast.makeText(RevenueActivity.this, "Vui lòng chọn cả ngày bắt đầu và kết thúc", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (startDateTimestamp > endDateTimestamp) {
                    Toast.makeText(RevenueActivity.this, "Ngày bắt đầu không thể sau ngày kết thúc", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Lấy doanh thu theo khoảng đã chọn
                double filteredRevenue = dbHelper.getRevenueByDateRange(startDateTimestamp, endDateTimestamp);
                tvFilteredRevenue.setText(String.format("Doanh thu (đã lọc): %.0f VNĐ", filteredRevenue));
            }
        });
    }

    /**
     * Tải và hiển thị tổng doanh thu
     */
    private void loadTotalRevenue() {
        double totalRevenue = dbHelper.getTotalRevenue();
        tvTotalRevenue.setText(String.format("%.0f VNĐ", totalRevenue));
    }

    /**
     * Hiển thị hộp thoại chọn ngày (DatePickerDialog)
     */
    private void showDatePickerDialog(boolean isStartDate) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Cài đặt Calendar về ngày đã chọn
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);

                        if (isStartDate) {
                            // Set về 00:00:00 của ngày đó
                            selectedDate.set(Calendar.HOUR_OF_DAY, 0);
                            selectedDate.set(Calendar.MINUTE, 0);
                            selectedDate.set(Calendar.SECOND, 0);
                            startDateTimestamp = selectedDate.getTimeInMillis();
                            btnStartDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        } else {
                            // Set về 23:59:59 của ngày đó
                            selectedDate.set(Calendar.HOUR_OF_DAY, 23);
                            selectedDate.set(Calendar.MINUTE, 59);
                            selectedDate.set(Calendar.SECOND, 59);
                            endDateTimestamp = selectedDate.getTimeInMillis();
                            btnEndDate.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                        }
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}