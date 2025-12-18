package com.example.pawnshopmanager; // THAY BẰNG TÊN GÓI CỦA BẠN

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView; // ĐÃ THAY ĐỔI
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout; // ĐÃ THÊM

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class AddEditItemActivity extends AppCompatActivity {

    TextView tvTitle;
    AutoCompleteTextView spinnerItemType; // ĐÃ THAY ĐỔI: từ Spinner
    EditText etTenNguoiCam, etTenVatPham, etGiaTienCam, etNgayCam, etGhiChu;
    Button btnLuu, btnGiaHan, btnXoa;
    TextInputLayout tilNgayCam; // ĐÃ THÊM

    // Trường riêng cho Xe
    LinearLayout layoutVehicleFields;
    EditText etMaSoCCCD, etDiaChi, etBienSoXe;

    DatabaseHelper dbHelper;
    private Item currentItem = null;
    private String[] itemTypes; // Dùng để lấy mảng từ R.array

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        dbHelper = new DatabaseHelper(this);
        itemTypes = getResources().getStringArray(R.array.item_types);

        initializeViews();
        setupSpinner(); // Cài đặt cho AutoCompleteTextView
        setupDatePicker();

        if (getIntent().hasExtra("ITEM_TO_EDIT")) {
            currentItem = (Item) getIntent().getSerializableExtra("ITEM_TO_EDIT");
            populateFields();
        } else {
            tvTitle.setText(R.string.them_vat_pham);
            etNgayCam.setText(DateLogicUtil.getTodayString());
        }

        btnLuu.setOnClickListener(v -> saveItem());
        btnXoa.setOnClickListener(v -> deleteItem());

        // ĐÃ THAY ĐỔI: Chuyển sang hàm riêng
        btnGiaHan.setOnClickListener(v -> showExtendDialog());
    }

    private void initializeViews() {
        tvTitle = findViewById(R.id.tvTitle);
        spinnerItemType = findViewById(R.id.spinnerItemType); // AutoCompleteTextView
        etTenNguoiCam = findViewById(R.id.etTenNguoiCam);
        etTenVatPham = findViewById(R.id.etTenVatPham);
        etGiaTienCam = findViewById(R.id.etGiaTienCam);
        etNgayCam = findViewById(R.id.etNgayCam);
        tilNgayCam = findViewById(R.id.tilNgayCam); // TextInputLayout của ngày
        etGhiChu = findViewById(R.id.etGhiChu);
        btnLuu = findViewById(R.id.btnLuu);
        btnGiaHan = findViewById(R.id.btnGiaHan);
        btnXoa = findViewById(R.id.btnXoa);

        // Trường của Xe
        layoutVehicleFields = findViewById(R.id.layoutVehicleFields);
        etMaSoCCCD = findViewById(R.id.etMaSoCCCD);
        etDiaChi = findViewById(R.id.etDiaChi);
        etBienSoXe = findViewById(R.id.etBienSoXe);
    }

    // Cài đặt cho AutoCompleteTextView (thay cho Spinner)
    private void setupSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                itemTypes
        );
        spinnerItemType.setAdapter(adapter);

        // Khi một loại được chọn, hiển thị/ẩn các trường của XE
        spinnerItemType.setOnItemClickListener((parent, view, position, id) -> {
            String selectedType = parent.getItemAtPosition(position).toString();
            toggleVehicleFields(selectedType);
        });
    }

    private void toggleVehicleFields(String itemType) {
        if ("vehicle".equals(itemType)) {
            layoutVehicleFields.setVisibility(View.VISIBLE);
        } else {
            layoutVehicleFields.setVisibility(View.GONE);
        }
    }

    private void setupDatePicker() {
        // Hiển thị DatePicker khi nhấn vào ô Ngày
        View.OnClickListener datePickerListener = v -> {
            Calendar c = Calendar.getInstance();
            // Thử phân tích ngày hiện có trong ô
            try {
                Date d = new SimpleDateFormat(DateLogicUtil.DATE_FORMAT, Locale.getDefault()).parse(etNgayCam.getText().toString());
                c.setTime(d);
            } catch (Exception e) {
                // Bỏ qua, dùng ngày hôm nay
            }

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    AddEditItemActivity.this,
                    (view, year, month, dayOfMonth) -> {
                        Calendar selectedDate = Calendar.getInstance();
                        selectedDate.set(year, month, dayOfMonth);
                        SimpleDateFormat sdf = new SimpleDateFormat(DateLogicUtil.DATE_FORMAT, Locale.getDefault());
                        etNgayCam.setText(sdf.format(selectedDate.getTime()));
                    },
                    c.get(Calendar.YEAR),
                    c.get(Calendar.MONTH),
                    c.get(Calendar.DAY_OF_MONTH)
            );
            datePickerDialog.show();
        };

        etNgayCam.setOnClickListener(datePickerListener);
        // Nhấn vào icon cũng mở date picker
        tilNgayCam.setEndIconOnClickListener(datePickerListener);
    }

    /**
     * Tải dữ liệu của vật phẩm lên form (cho chức năng Sửa)
     */
    private void populateFields() {
        if (currentItem == null) return;

        tvTitle.setText(R.string.sua_vat_pham);
        spinnerItemType.setText(currentItem.getType(), false); // Cập nhật AutoCompleteTextView
        etTenNguoiCam.setText(currentItem.getTenNguoiCam());
        etTenVatPham.setText(currentItem.getTenVatPham());
        etGiaTienCam.setText(String.valueOf(currentItem.getGiaTienCam()));
        etNgayCam.setText(currentItem.getNgayCam());
        etGhiChu.setText(currentItem.getGhiChu());

        toggleVehicleFields(currentItem.getType());
        if ("vehicle".equals(currentItem.getType())) {
            etMaSoCCCD.setText(currentItem.getMaSoCCCD());
            etDiaChi.setText(currentItem.getDiaChi());
            etBienSoXe.setText(currentItem.getBienSoXe());
        }

        // Hiển thị các nút Sửa
        btnGiaHan.setVisibility(View.VISIBLE);
        btnXoa.setVisibility(View.VISIBLE);
    }

    /**
     * Lưu vật phẩm (Thêm mới hoặc Cập nhật)
     */
    private void saveItem() {
        // Lấy dữ liệu từ form
        String type = spinnerItemType.getText().toString();
        String tenNguoiCam = etTenNguoiCam.getText().toString().trim();
        String tenVatPham = etTenVatPham.getText().toString().trim();
        String giaTienStr = etGiaTienCam.getText().toString().trim();
        String ngayCam = etNgayCam.getText().toString().trim();

        // Kiểm tra dữ liệu cơ bản
        if (type.isEmpty() || tenNguoiCam.isEmpty() || tenVatPham.isEmpty() || giaTienStr.isEmpty() || ngayCam.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập tất cả các trường bắt buộc", Toast.LENGTH_SHORT).show();
            return;
        }

        double giaTienCam;
        try {
            giaTienCam = Double.parseDouble(giaTienStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Giá tiền không hợp lệ", Toast.LENGTH_SHORT).show();
            return;
        }

        Item item;
        if (currentItem != null) {
            item = currentItem; // Dùng vật phẩm hiện tại (để giữ ID)
        } else {
            item = new Item();
        }

        // Cập nhật thông tin cho đối tượng item
        item.setTenNguoiCam(tenNguoiCam);
        item.setTenVatPham(tenVatPham);
        item.setGiaTienCam(giaTienCam);
        item.setNgayCam(ngayCam);
        item.setGhiChu(etGhiChu.getText().toString().trim());
        item.setType(type);

        if ("vehicle".equals(type)) {
            String cccd = etMaSoCCCD.getText().toString().trim();
            String diaChi = etDiaChi.getText().toString().trim();
            String bienSo = etBienSoXe.getText().toString().trim();

            if (cccd.isEmpty() || diaChi.isEmpty() || bienSo.isEmpty()) {
                Toast.makeText(this, "Với XE, vui lòng nhập CCCD, Địa chỉ, Biển số", Toast.LENGTH_SHORT).show();
                return;
            }
            item.setMaSoCCCD(cccd);
            item.setDiaChi(diaChi);
            item.setBienSoXe(bienSo);
        } else {
            item.setMaSoCCCD(null);
            item.setDiaChi(null);
            item.setBienSoXe(null);
        }

        // Quyết định Thêm mới hay Cập nhật
        boolean success;
        if (currentItem != null) {
            success = dbHelper.updateItem(item);
        } else {
            success = dbHelper.addItem(item);
        }

        if (success) {
            Toast.makeText(this, "Đã lưu thành công", Toast.LENGTH_SHORT).show();
            setResult(RESULT_OK); // Báo cho MainActivity biết để tải lại danh sách
            finish(); // Đóng Activity
        } else {
            Toast.makeText(this, "Lưu thất bại", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * Xóa vật phẩm
     */
    private void deleteItem() {
        if (currentItem == null) return;

        // Hiển thị hộp thoại xác nhận
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận Xóa")
                .setMessage("Bạn có chắc chắn muốn xóa vật phẩm này? Hành động này không thể hoàn tác.")
                .setPositiveButton("Xóa", (dialog, which) -> {
                    if (dbHelper.deleteItem(currentItem.getId())) {
                        Toast.makeText(this, "Đã xóa vật phẩm", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK); // Báo MainActivity tải lại
                        finish();
                    } else {
                        Toast.makeText(this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", null)
                .show();
    }

    /**
     * HÀM MỚI: Hiển thị hộp thoại Gia hạn (Tính lãi)
     */
    private void showExtendDialog() {
        if (currentItem == null) return; // An toàn

        // 1. Lấy ngày hôm nay
        String newNgayCam = DateLogicUtil.getTodayString();

        // 2. Lấy thông tin ngày tháng
        Date oldDueDate = DateLogicUtil.getDueDate(currentItem.getNgayCam(), currentItem.getType());
        Date newDueDate = DateLogicUtil.getDueDate(newNgayCam, currentItem.getType()); // Hạn mới tính từ hôm nay

        // 3. Tính tiền lãi (dùng hàm chúng ta vừa tạo)
        double tienLai = DateLogicUtil.calculateInterest(currentItem);

        // 4. Định dạng (format) các con số để hiển thị
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String tienLaiString = String.format(Locale.getDefault(), "%,.0f", tienLai); // Format: 15,000
        String oldDueDateString = sdf.format(oldDueDate);
        String newDueDateString = sdf.format(newDueDate);

        // 5. Lấy chuỗi thông báo từ strings.xml
        String message = getString(R.string.thong_bao_gia_han,
                tienLaiString,
                oldDueDateString,
                newDueDateString);

        // 6. Tạo và Hiển thị Hộp thoại Xác nhận
        new AlertDialog.Builder(this)
                .setTitle(R.string.xac_nhan_gia_han)
                // Dùng Html.fromHtml để hiển thị chữ đậm (<b>)
                .setMessage(android.text.Html.fromHtml(message, android.text.Html.FROM_HTML_MODE_LEGACY))
                .setPositiveButton(R.string.xac_nhan, (dialog, which) -> {
                    // Chỉ chạy khi người dùng nhấn "Xác nhận"

                    // 7. Gọi hàm CSDL đã được sửa
                    if (dbHelper.extendItem(currentItem.getId(), newNgayCam)) {
                        Toast.makeText(this, "Đã gia hạn thành công!", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK); // Báo cho MainActivity biết để tải lại danh sách
                        finish(); // Đóng Activity này
                    } else {
                        Toast.makeText(this, "Gia hạn thất bại", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton(R.string.huy, null) // Nút "Hủy" không làm gì cả
                .show(); // Hiển thị hộp thoại
    }
}