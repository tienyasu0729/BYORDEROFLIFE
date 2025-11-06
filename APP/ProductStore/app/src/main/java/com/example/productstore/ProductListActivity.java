package com.example.productstore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast; // Import mới (nếu chưa có)

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity
        implements ProductAdapter.OnProductListener, SearchView.OnQueryTextListener {

    private RecyclerView recyclerViewProducts;
    private FloatingActionButton fabAddProduct;
    private DatabaseHelper dbHelper;
    private ProductAdapter adapter;
    private List<Product> productList;
    private String currentSortOrder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        dbHelper = new DatabaseHelper(this);
        productList = new ArrayList<>();
        recyclerViewProducts = findViewById(R.id.recyclerViewProducts);
        fabAddProduct = findViewById(R.id.fabAddProduct);

        adapter = new ProductAdapter(this, productList, this);
        recyclerViewProducts.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewProducts.setAdapter(adapter);

        // Sự kiện nhấn nút Thêm (+)
        fabAddProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductListActivity.this, AddEditProductActivity.class);
                intent.putExtra("EXTRA_PRODUCT_ID", -1);
                startActivity(intent);
            }
        });
    }

    private void loadProducts() {
        List<Product> newList = dbHelper.getAllProducts(currentSortOrder);
        adapter.setProducts(newList);
    }

    private void searchProducts(String query) {
        List<Product> searchResult = dbHelper.searchProductsByName(query);
        adapter.setProducts(searchResult);
    }

    // onEditClick
    @Override
    public void onEditClick(Product product) {
        Intent intent = new Intent(ProductListActivity.this, AddEditProductActivity.class);
        intent.putExtra("EXTRA_PRODUCT_ID", product.getId());
        startActivity(intent);
    }

    // onDeleteClick
    @Override
    public void onDeleteClick(Product product) {
        new AlertDialog.Builder(this)
                .setTitle("Xác nhận Xóa")
                .setMessage("Bạn có chắc chắn muốn xóa " + product.getName() + "?")
                .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dbHelper.deleteProduct(product.getId());
                        loadProducts();
                        Toast.makeText(ProductListActivity.this, "Đã xóa", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Hủy", null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    /**
     * (HÀM MỚI - BƯỚC 19)
     * Xử lý khi nhấn nút "Thêm vào giỏ"
     */
    @Override
    public void onAddToCartClick(Product product) {
        // Gọi hàm DatabaseHelper để thêm sản phẩm
        dbHelper.addProductToCart(product.getId());

        // Thông báo cho người dùng
        Toast.makeText(this, "Đã thêm '" + product.getName() + "' vào giỏ", Toast.LENGTH_SHORT).show();
    }

    // onResume
    @Override
    protected void onResume() {
        super.onResume();
        loadProducts();
    }

    // --- XỬ LÝ MENU (SEARCH VÀ SORT) ---

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.product_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setOnQueryTextListener(this);
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                loadProducts();
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_sort_asc) {
            currentSortOrder = DatabaseHelper.KEY_PRODUCT_PRICE + " ASC";
            loadProducts();
            return true;
        }
        if (id == R.id.action_sort_desc) {
            currentSortOrder = DatabaseHelper.KEY_PRODUCT_PRICE + " DESC";
            loadProducts();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // onQueryTextSubmit
    @Override
    public boolean onQueryTextSubmit(String query) {
        searchProducts(query);
        return false;
    }

    // onQueryTextChange
    @Override
    public boolean onQueryTextChange(String newText) {
        searchProducts(newText);
        return false;
    }
}