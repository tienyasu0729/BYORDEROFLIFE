package com.example.pawnshopmanager; // THAY BẰNG TÊN GÓI CỦA BẠN

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Tên CSDL
    public static final String DATABASE_NAME = "pawnshop.db";
    // Phiên bản CSDL
    public static final int DATABASE_VERSION = 1;

    // --- Bảng ADMINS ---
    public static final String TABLE_ADMINS = "admins";
    public static final String COL_ADMIN_ID = "id";
    public static final String COL_ADMIN_EMAIL = "email";
    public static final String COL_ADMIN_PHONE = "phone";
    public static final String COL_ADMIN_PASSWORD = "password";

    // Câu lệnh tạo bảng ADMINS
    private static final String CREATE_TABLE_ADMINS = "CREATE TABLE " + TABLE_ADMINS + "("
            + COL_ADMIN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_ADMIN_EMAIL + " TEXT UNIQUE,"
            + COL_ADMIN_PHONE + " TEXT UNIQUE,"
            + COL_ADMIN_PASSWORD + " TEXT"
            + ")";

    // --- Bảng ITEMS ---
    public static final String TABLE_ITEMS = "items";
    public static final String COL_ITEM_ID = "id";
    public static final String COL_ITEM_TEN_NGUOI_CAM = "tenNguoiCam";
    public static final String COL_ITEM_TEN_VAT_PHAM = "tenVatPham"; // Thêm cột này
    public static final String COL_ITEM_GIA_TIEN_CAM = "giaTienCam";
    public static final String COL_ITEM_NGAY_CAM = "ngayCam"; // Format: "YYYY-MM-DD"
    public static final String COL_ITEM_GHI_CHU = "ghiChu";
    public static final String COL_ITEM_TYPE = "type"; // 'phone', 'laptop', 'vehicle'
    // Trường riêng cho xe
    public static final String COL_ITEM_MA_SO_CCCD = "maSoCCCD";
    public static final String COL_ITEM_DIA_CHI = "diaChi";
    public static final String COL_ITEM_BIEN_SO_XE = "bienSoXe";

    // Câu lệnh tạo bảng ITEMS
    private static final String CREATE_TABLE_ITEMS = "CREATE TABLE " + TABLE_ITEMS + "("
            + COL_ITEM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_ITEM_TEN_NGUOI_CAM + " TEXT NOT NULL,"
            + COL_ITEM_TEN_VAT_PHAM + " TEXT NOT NULL," // Thêm cột
            + COL_ITEM_GIA_TIEN_CAM + " REAL NOT NULL,"
            + COL_ITEM_NGAY_CAM + " TEXT NOT NULL,"
            + COL_ITEM_GHI_CHU + " TEXT,"
            + COL_ITEM_TYPE + " TEXT NOT NULL,"
            + COL_ITEM_MA_SO_CCCD + " TEXT," // Có thể NULL
            + COL_ITEM_DIA_CHI + " TEXT,"     // Có thể NULL
            + COL_ITEM_BIEN_SO_XE + " TEXT"   // Có thể NULL
            + ")";


    // Hàm constructor
    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Phương thức này được gọi khi CSDL được tạo lần đầu tiên
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ADMINS);
        db.execSQL(CREATE_TABLE_ITEMS);
    }

    // Phương thức này được gọi khi nâng cấp phiên bản CSDL
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Đơn giản là xóa bảng cũ và tạo lại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ADMINS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ITEMS);
        onCreate(db);
    }

    // --- CÁC HÀM CHO ADMIN ---

    /**
     * Đăng ký Admin
     * @return true nếu đăng ký thành công, false nếu email/phone đã tồn tại
     */
    public boolean registerAdmin(String email, String phone, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ADMIN_EMAIL, email);
        values.put(COL_ADMIN_PHONE, phone);
        values.put(COL_ADMIN_PASSWORD, password); // Cần mã hóa mật khẩu trong dự án thực tế!

        // Thêm UNIQUE constraint vào CSDL để insert an toàn
        long id = db.insertWithOnConflict(TABLE_ADMINS, null, values, SQLiteDatabase.CONFLICT_IGNORE);
        db.close();

        return id != -1; // -1 nếu bị conflict (đã tồn tại)
    }

    /**
     * Kiểm tra đăng nhập (bằng Email hoặc SĐT)
     * @return true nếu thông tin đăng nhập chính xác
     */
    public boolean checkAdminLogin(String emailOrPhone, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = "(" + COL_ADMIN_EMAIL + " = ? OR "
                + COL_ADMIN_PHONE + " = ?) AND "
                + COL_ADMIN_PASSWORD + " = ?";
        String[] selectionArgs = {emailOrPhone, emailOrPhone, password};

        Cursor cursor = db.query(TABLE_ADMINS,
                null, // Lấy tất cả các cột
                selection,
                selectionArgs,
                null, null, null);

        int count = cursor.getCount();
        cursor.close();
        db.close();

        return count > 0; // Trả về true nếu tìm thấy 1 admin khớp
    }

    /**
     * Kiểm tra xem đã có admin nào đăng ký chưa
     */
    public boolean hasAdminAccount() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT 1 FROM " + TABLE_ADMINS + " LIMIT 1", null);
        boolean hasAccount = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return hasAccount;
    }

    // --- CÁC HÀM CHO VẬT PHẨM (ITEMS) ---

    /**
     * Thêm một vật phẩm mới
     */
    public boolean addItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_TEN_NGUOI_CAM, item.getTenNguoiCam());
        values.put(COL_ITEM_TEN_VAT_PHAM, item.getTenVatPham());
        values.put(COL_ITEM_TEN_VAT_PHAM, item.getGiaTienCam());
        values.put(COL_ITEM_NGAY_CAM, item.getNgayCam()); // "YYYY-MM-DD"
        values.put(COL_ITEM_GHI_CHU, item.getGhiChu());
        values.put(COL_ITEM_TYPE, item.getType());
        values.put(COL_ITEM_MA_SO_CCCD, item.getMaSoCCCD());
        values.put(COL_ITEM_DIA_CHI, item.getDiaChi());
        values.put(COL_ITEM_BIEN_SO_XE, item.getBienSoXe());

        long id = db.insert(TABLE_ITEMS, null, values);
        db.close();
        return id != -1;
    }

    /**
     * Cập nhật thông tin vật phẩm
     */
    public boolean updateItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_TEN_NGUOI_CAM, item.getTenNguoiCam());
        values.put(COL_ITEM_TEN_VAT_PHAM, item.getTenVatPham());
        values.put(COL_ITEM_GIA_TIEN_CAM, item.getGiaTienCam());
        values.put(COL_ITEM_NGAY_CAM, item.getNgayCam());
        values.put(COL_ITEM_GHI_CHU, item.getGhiChu());
        values.put(COL_ITEM_TYPE, item.getType());
        values.put(COL_ITEM_MA_SO_CCCD, item.getMaSoCCCD());
        values.put(COL_ITEM_DIA_CHI, item.getDiaChi());
        values.put(COL_ITEM_BIEN_SO_XE, item.getBienSoXe());

        int rows = db.update(TABLE_ITEMS,
                values,
                COL_ITEM_ID + " = ?",
                new String[]{String.valueOf(item.getId())});
        db.close();
        return rows > 0;
    }

    /**
     * HÀM ĐÃ SỬA ĐỔI: Gia hạn vật phẩm (Cập nhật ngày cầm thành ngày mới)
     */
    public boolean extendItem(int itemId, String newNgayCam) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_ITEM_NGAY_CAM, newNgayCam); // Cập nhật ngày cầm mới

        int rows = db.update(TABLE_ITEMS, values, COL_ITEM_ID + " = ?", new String[]{String.valueOf(itemId)});
        db.close();
        return rows > 0;
    }

    /**
     * Xóa một vật phẩm
     */
    public boolean deleteItem(int itemId) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rows = db.delete(TABLE_ITEMS,
                COL_ITEM_ID + " = ?",
                new String[]{String.valueOf(itemId)});
        db.close();
        return rows > 0;
    }

    /**
     * Lấy TẤT CẢ vật phẩm, hoặc lọc theo tìm kiếm
     */
    public List<Item> getAllItems(String searchQuery) {
        List<Item> itemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor;
        String selection = null;
        String[] selectionArgs = null;

        if (searchQuery != null && !searchQuery.isEmpty()) {
            selection = COL_ITEM_TEN_NGUOI_CAM + " LIKE ? OR "
                    + COL_ITEM_TEN_VAT_PHAM + " LIKE ? OR "
                    + COL_ITEM_MA_SO_CCCD + " LIKE ? OR "
                    + COL_ITEM_BIEN_SO_XE + " LIKE ?";
            String likeQuery = "%" + searchQuery + "%";
            selectionArgs = new String[]{likeQuery, likeQuery, likeQuery, likeQuery};
        }

        // Sắp xếp theo ngày cầm, mới nhất lên đầu
        cursor = db.query(TABLE_ITEMS, null, selection, selectionArgs, null, null, COL_ITEM_NGAY_CAM + " DESC");

        if (cursor.moveToFirst()) {
            do {
                Item item = new Item();
                item.setId(cursor.getInt(cursor.getColumnIndexOrThrow(COL_ITEM_ID)));
                item.setTenNguoiCam(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_TEN_NGUOI_CAM)));
                item.setTenVatPham(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_TEN_VAT_PHAM)));
                item.setGiaTienCam(cursor.getDouble(cursor.getColumnIndexOrThrow(COL_ITEM_GIA_TIEN_CAM)));
                item.setNgayCam(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_NGAY_CAM)));
                item.setType(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_TYPE)));
                item.setGhiChu(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_GHI_CHU)));
                item.setMaSoCCCD(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_MA_SO_CCCD)));
                item.setDiaChi(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_DIA_CHI)));
                item.setBienSoXe(cursor.getString(cursor.getColumnIndexOrThrow(COL_ITEM_BIEN_SO_XE)));

                itemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return itemList;
    }
}