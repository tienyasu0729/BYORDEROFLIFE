package com.example.productstore;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Định nghĩa hằng số cho database
    private static final int DATABASE_VERSION = 1; // Giữ nguyên version
    private static final String DATABASE_NAME = "ProductManager.db";

    // Hằng số cho Bảng Users
    private static final String TABLE_USERS = "users";
    private static final String KEY_ID = "id";
    private static final String KEY_FULL_NAME = "fullName";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASSWORD = "password";

    // Hằng số cho Bảng Products
    private static final String TABLE_PRODUCTS = "products";
    private static final String KEY_PRODUCT_ID = "id";
    private static final String KEY_PRODUCT_NAME = "name";
    private static final String KEY_PRODUCT_DESC = "description";
    public static final String KEY_PRODUCT_PRICE = "price"; // Dùng cho Sắp xếp
    private static final String KEY_PRODUCT_IMAGE = "image";

    // (MỚI) Hằng số cho Bảng Cart (Giỏ hàng)
    private static final String TABLE_CART = "cart";
    private static final String KEY_CART_ID = "id";
    private static final String KEY_CART_PRODUCT_ID = "product_id"; // Khóa ngoại
    private static final String KEY_CART_QUANTITY = "quantity";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Hàm này CHẠY 1 LẦN khi cài đặt ứng dụng
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. Câu lệnh SQL tạo bảng users
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FULL_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE,"
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);

        // 2. Câu lệnh SQL tạo bảng products
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_PRODUCT_DESC + " TEXT,"
                + KEY_PRODUCT_PRICE + " REAL,"
                + KEY_PRODUCT_IMAGE + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        // 3. (MỚI) Câu lệnh SQL tạo bảng cart
        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + KEY_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CART_PRODUCT_ID + " INTEGER," // ID của sản phẩm
                + KEY_CART_QUANTITY + " INTEGER," // Số lượng
                + "FOREIGN KEY(" + KEY_CART_PRODUCT_ID + ") REFERENCES "
                + TABLE_PRODUCTS + "(" + KEY_PRODUCT_ID + ")" + ")";
        db.execSQL(CREATE_CART_TABLE);
    }

    // Hàm này chạy khi nâng cấp version của DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Xóa bảng cũ nếu tồn tại
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART); // (MỚI) Thêm dòng này
        // Tạo lại bảng
        onCreate(db);
    }

    // --- Các hàm CRUD cho User (Giữ nguyên) ---
    public boolean addUser(String fullName, String email, String pass) { /* ... */ }
    public boolean checkUserLogin(String email, String pass) { /* ... */ }
    // (Copy code các hàm User từ trước)

    // --- Các hàm CRUD cho Product (Giữ nguyên) ---
    public boolean addProduct(String name, String desc, double price, String image) { /* ... */ }
    public int updateProduct(int id, String name, String desc, double price, String image) { /* ... */ }
    public void deleteProduct(int id) { /* ... */ }
    public Product getProductById(int id) { /* ... */ }
    public List<Product> getAllProducts(String sortBy) { /* ... */ }
    public List<Product> getAllProducts() { return getAllProducts(null); }
    public List<Product> searchProductsByName(String query) { /* ... */ }
    // (Copy code các hàm Product từ trước)

    // --- (MỚI) Các hàm CRUD cho Cart (Bước 15) ---

    /**
     * Thêm sản phẩm vào giỏ hàng (hoặc tăng số lượng nếu đã có)
     */
    public void addProductToCart(int productId) {
        SQLiteDatabase db = this.getWritableDatabase();

        // 1. Kiểm tra xem sản phẩm đã có trong giỏ hàng chưa
        Cursor cursor = db.query(TABLE_CART, null, KEY_CART_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(productId)}, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            // 2a. Nếu đã có: Tăng số lượng
            int currentQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_QUANTITY));
            int cartItemId = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_ID));

            ContentValues values = new ContentValues();
            values.put(KEY_CART_QUANTITY, currentQuantity + 1);

            db.update(TABLE_CART, values, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartItemId)});
        } else {
            // 2b. Nếu chưa có: Thêm mới với số lượng = 1
            ContentValues values = new ContentValues();
            values.put(KEY_CART_PRODUCT_ID, productId);
            values.put(KEY_CART_QUANTITY, 1);

            db.insert(TABLE_CART, null, values);
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();
    }

    /**
     * Lấy tất cả các sản phẩm trong giỏ hàng
     * (Sử dụng JOIN 2 bảng cart và products)
     */
    public List<CartItem> getCartItems() {
        List<CartItem> cartItemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Câu lệnh JOIN để lấy thông tin sản phẩm (tên, giá) từ bảng products
        String query = "SELECT T1." + KEY_CART_ID + ", T2." + KEY_PRODUCT_NAME + ", T2." + KEY_PRODUCT_PRICE +
                ", T1." + KEY_CART_QUANTITY + ", T1." + KEY_CART_PRODUCT_ID +
                " FROM " + TABLE_CART + " T1" +
                " INNER JOIN " + TABLE_PRODUCTS + " T2 ON T1." + KEY_CART_PRODUCT_ID + " = T2." + KEY_PRODUCT_ID;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                int cartId = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_ID));
                int productId = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_PRODUCT_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_NAME));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_PRODUCT_PRICE));
                int quantity = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_QUANTITY));

                CartItem item = new CartItem(cartId, productId, name, price, quantity);
                cartItemList.add(item);
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return cartItemList;
    }

    /**
     * Cập nhật số lượng cho 1 item trong giỏ
     */
    public void updateCartItemQuantity(int cartId, int newQuantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CART_QUANTITY, newQuantity);

        db.update(TABLE_CART, values, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartId)});
        db.close();
    }

    /**
     * Xóa 1 item khỏi giỏ hàng
     */
    public void removeCartItem(int cartId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartId)});
        db.close();
    }

    /**
     * Xóa toàn bộ giỏ hàng (dùng khi checkout)
     */
    public void clearCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, null, null);
        db.close();
    }
}