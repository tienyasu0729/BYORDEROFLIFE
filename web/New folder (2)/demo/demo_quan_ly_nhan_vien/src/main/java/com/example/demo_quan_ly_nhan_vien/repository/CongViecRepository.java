package com.example.demo_quan_ly_nhan_vien.repository;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;

import java.util.List;

public interface CongViecRepository {
    CongViec findById(String maCongViec);
    List<CongViec> findAll();
}
