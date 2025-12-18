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
    private static final int DATABASE_VERSION = 1;
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
    public static final String KEY_PRODUCT_PRICE = "price";
    private static final String KEY_PRODUCT_IMAGE = "image";

    // Hằng số cho Bảng Cart (Giỏ hàng)
    private static final String TABLE_CART = "cart";
    private static final String KEY_CART_ID = "id";
    private static final String KEY_CART_PRODUCT_ID = "product_id";
    private static final String KEY_CART_QUANTITY = "quantity";

    // Hằng số cho Bảng Orders (Đơn hàng)
    private static final String TABLE_ORDERS = "orders";
    private static final String KEY_ORDER_ID = "id";
    private static final String KEY_ORDER_DATE = "order_date";
    private static final String KEY_ORDER_TOTAL = "total_revenue";

    // Constructor
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Hàm này CHẠY 1 LẦN khi cài đặt ứng dụng
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 1. Tạo bảng users
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_FULL_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT UNIQUE,"
                + KEY_PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_USERS_TABLE);

        // 2. Tạo bảng products
        String CREATE_PRODUCTS_TABLE = "CREATE TABLE " + TABLE_PRODUCTS + "("
                + KEY_PRODUCT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_PRODUCT_NAME + " TEXT,"
                + KEY_PRODUCT_DESC + " TEXT,"
                + KEY_PRODUCT_PRICE + " REAL,"
                + KEY_PRODUCT_IMAGE + " TEXT" + ")";
        db.execSQL(CREATE_PRODUCTS_TABLE);

        // 3. Tạo bảng cart
        String CREATE_CART_TABLE = "CREATE TABLE " + TABLE_CART + "("
                + KEY_CART_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_CART_PRODUCT_ID + " INTEGER,"
                + KEY_CART_QUANTITY + " INTEGER,"
                + "FOREIGN KEY(" + KEY_CART_PRODUCT_ID + ") REFERENCES "
                + TABLE_PRODUCTS + "(" + KEY_PRODUCT_ID + ")" + ")";
        db.execSQL(CREATE_CART_TABLE);

        // 4. Tạo bảng orders
        String CREATE_ORDERS_TABLE = "CREATE TABLE " + TABLE_ORDERS + "("
                + KEY_ORDER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_ORDER_DATE + " INTEGER,"
                + KEY_ORDER_TOTAL + " REAL" + ")";
        db.execSQL(CREATE_ORDERS_TABLE);
    }

    // Hàm này chạy khi nâng cấp version của DB
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CART);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_ORDERS);
        onCreate(db);
    }

    // --- Các hàm CRUD cho User ---

    public boolean addUser(String fullName, String email, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursorCheck = db.rawQuery("SELECT 1 FROM " + TABLE_USERS + " WHERE " + KEY_EMAIL + " = ?", new String[]{email});
        if (cursorCheck.getCount() > 0) {
            cursorCheck.close(); db.close(); return false;
        }
        cursorCheck.close();
        ContentValues values = new ContentValues();
        values.put(KEY_FULL_NAME, fullName);
        values.put(KEY_EMAIL, email);
        values.put(KEY_PASSWORD, pass);
        long success = db.insert(TABLE_USERS, null, values);
        db.close();
        return success != -1;
    }

    public boolean checkUserLogin(String email, String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT 1 FROM " + TABLE_USERS + " WHERE " + KEY_EMAIL + " = ? AND " + KEY_PASSWORD + " = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, pass});
        boolean userExists = cursor.getCount() > 0;
        cursor.close(); db.close(); return userExists;
    }

    // --- Các hàm CRUD cho Product ---

    public boolean addProduct(String name, String desc, double price, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, name);
        values.put(KEY_PRODUCT_DESC, desc);
        values.put(KEY_PRODUCT_PRICE, price);
        values.put(KEY_PRODUCT_IMAGE, image);
        long result = db.insert(TABLE_PRODUCTS, null, values);
        db.close();
        return result != -1;
    }

    public int updateProduct(int id, String name, String desc, double price, String image) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PRODUCT_NAME, name);
        values.put(KEY_PRODUCT_DESC, desc);
        values.put(KEY_PRODUCT_PRICE, price);
        values.put(KEY_PRODUCT_IMAGE, image);
        int rowsAffected = db.update(TABLE_PRODUCTS, values, KEY_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
        return rowsAffected;
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PRODUCTS, KEY_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }

    public Product getProductById(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_PRODUCTS,
                new String[]{KEY_PRODUCT_ID, KEY_PRODUCT_NAME, KEY_PRODUCT_DESC, KEY_PRODUCT_PRICE, KEY_PRODUCT_IMAGE},
                KEY_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(id)},
                null, null, null, null);
        Product product = null;
        if (cursor != null && cursor.moveToFirst()) {
            product = new Product(
                    cursor.getInt(cursor.getColumnIndexOrThrow(KEY_PRODUCT_ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_NAME)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_DESC)),
                    cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_PRODUCT_PRICE)),
                    cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_IMAGE))
            );
            cursor.close();
        }
        db.close();
        return product;
    }

    public List<Product> getAllProducts() {
        return getAllProducts(null);
    }

    public List<Product> getAllProducts(String sortBy) {
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS;
        if (sortBy != null) {
            selectQuery += " ORDER BY " + sortBy;
        }
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_PRODUCT_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_NAME));
                String desc = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_DESC));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_PRODUCT_PRICE));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_IMAGE));
                Product product = new Product(id, name, desc, price, image);
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productList;
    }

    public List<Product> searchProductsByName(String query) {
        List<Product> productList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE "
                + KEY_PRODUCT_NAME + " LIKE ?";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, new String[]{"%" + query + "%"});
        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_PRODUCT_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_NAME));
                String desc = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_DESC));
                double price = cursor.getDouble(cursor.getColumnIndexOrThrow(KEY_PRODUCT_PRICE));
                String image = cursor.getString(cursor.getColumnIndexOrThrow(KEY_PRODUCT_IMAGE));
                Product product = new Product(id, name, desc, price, image);
                productList.add(product);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return productList;
    }

    // --- Các hàm CRUD cho Cart ---

    public void addProductToCart(int productId) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_CART, null, KEY_CART_PRODUCT_ID + " = ?",
                new String[]{String.valueOf(productId)}, null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            int currentQuantity = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_QUANTITY));
            int cartItemId = cursor.getInt(cursor.getColumnIndexOrThrow(KEY_CART_ID));
            ContentValues values = new ContentValues();
            values.put(KEY_CART_QUANTITY, currentQuantity + 1);
            db.update(TABLE_CART, values, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartItemId)});
        } else {
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

    public List<CartItem> getCartItems() {
        List<CartItem> cartItemList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
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

    public void updateCartItemQuantity(int cartId, int newQuantity) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_CART_QUANTITY, newQuantity);
        db.update(TABLE_CART, values, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartId)});
        db.close();
    }

    public void removeCartItem(int cartId) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, KEY_CART_ID + " = ?", new String[]{String.valueOf(cartId)});
        db.close();
    }

    public void clearCart() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_CART, null, null);
        db.close();
    }

    // --- Các hàm cho Thống kê Doanh thu ---

    public void addOrder(double totalRevenue) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        long currentTime = System.currentTimeMillis();
        values.put(KEY_ORDER_DATE, currentTime);
        values.put(KEY_ORDER_TOTAL, totalRevenue);
        db.insert(TABLE_ORDERS, null, values);
        db.close();
    }

    public double getTotalRevenue() {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + KEY_ORDER_TOTAL + ") FROM " + TABLE_ORDERS;
        Cursor cursor = db.rawQuery(query, null);
        double total = 0;
        if (cursor.moveToFirst()) {
            total = cursor.getDouble(0);
        }
        cursor.close();
        db.close();
        return total;
    }

    public double getRevenueByDateRange(long startDate, long endDate) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT SUM(" + KEY_ORDER_TOTAL + ") FROM " + TABLE_ORDERS +
                " WHERE " + KEY_ORDER_DATE + " >= ? AND " + KEY_ORDER_DATE + " <= ?";
        Cursor cursor = db.rawQuery(query, new String[]{String.valueOf(startDate), String.valueOf(endDate)});
        double total = 0;
        if (cursor.moveToFirst()) {
            total = cursor.getDouble(0);
        }
        cursor.close();
        db.close();
        return total;
    }
}