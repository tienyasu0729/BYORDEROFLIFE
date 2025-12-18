package com.example.pawnshopmanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    FloatingActionButton fab;
    SearchView searchView;
    Spinner spinnerFilter;
    TextView tvEmpty;

    DatabaseHelper dbHelper;
    ItemAdapter adapter;
    List<Item> allItems = new ArrayList<>(); // Danh sách gốc từ CSDL
    String currentSearchQuery = "";
    String currentFilter = "Tất cả";

    // Launcher để nhận kết quả khi Thêm/Sửa
    ActivityResultLauncher<Intent> addEditLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                // Nếu kết quả là OK (có nghĩa là đã Lưu)
                if (result.getResultCode() == RESULT_OK) {
                    loadItemsFromDb(); // Tải lại toàn bộ
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DatabaseHelper(this);

        recyclerView = findViewById(R.id.recyclerView);
        fab = findViewById(R.id.fab);
        searchView = findViewById(R.id.searchView);
        spinnerFilter = findViewById(R.id.spinnerFilter);
        tvEmpty = findViewById(R.id.tvEmpty);

        setupRecyclerView();
        setupSearchView();
        setupFilterSpinner();

        fab.setOnClickListener(v -> {
            // Mở AddEditItemActivity để Thêm mới
            Intent intent = new Intent(MainActivity.this, AddEditItemActivity.class);
            addEditLauncher.launch(intent);
        });

        loadItemsFromDb();
    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Khởi tạo Adapter với danh sách rỗng
        adapter = new ItemAdapter(this, new ArrayList<>(), item -> {
            // Xử lý khi click vào một item -> Mở màn hình Sửa
            Intent intent = new Intent(MainActivity.this, AddEditItemActivity.class);
            intent.putExtra("ITEM_TO_EDIT", item); // Truyền Item qua Intent
            addEditLauncher.launch(intent);
        });
        recyclerView.setAdapter(adapter);
    }

    // Tải toàn bộ danh sách từ CSDL
    private void loadItemsFromDb() {
        // Lấy danh sách dựa trên tìm kiếm (nếu có)
        allItems = dbHelper.searchItems(currentSearchQuery);
        // Sau khi tải xong, áp dụng bộ lọc (Sắp hạn, Quá hạn)
        filterAndDisplayList();
    }

    // Lọc danh sách (Sắp hạn, Quá hạn) và cập nhật Adapter
    private void filterAndDisplayList() {
        List<Item> filteredList = new ArrayList<>();

        currentFilter = spinnerFilter.getSelectedItem().toString();

        if (currentFilter.equals(getString(R.string.tat_ca))) {
            filteredList.addAll(allItems);
        } else {
            for (Item item : allItems) {
                DateLogicUtil.ItemStatus status = DateLogicUtil.getItemStatus(item.getNgayCam(), item.getType());
                if (currentFilter.equals(getString(R.string.sap_den_han)) && status == DateLogicUtil.ItemStatus.NEARING) {
                    filteredList.add(item);
                } else if (currentFilter.equals(getString(R.string.qua_han)) && status == DateLogicUtil.ItemStatus.OVERDUE) {
                    filteredList.add(item);
                }
            }
        }

        // Cập nhật Adapter
        adapter.filterList(filteredList);

        // Hiển thị thông báo nếu danh sách rỗng
        if (filteredList.isEmpty()) {
            tvEmpty.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        } else {
            tvEmpty.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }

    // Cài đặt thanh Tìm kiếm
    private void setupSearchView() {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Không cần làm gì khi submit
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Khi người dùng gõ, tải lại từ CSDL
                currentSearchQuery = newText;
                loadItemsFromDb();
                return true;
            }
        });
    }

    // Cài đặt bộ lọc Spinner
    private void setupFilterSpinner() {
        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Khi người dùng chọn, lọc lại danh sách hiện có
                filterAndDisplayList();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
    }
}