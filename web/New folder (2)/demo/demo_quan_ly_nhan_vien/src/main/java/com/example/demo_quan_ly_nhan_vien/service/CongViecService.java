package com.example.demo_quan_ly_nhan_vien.service;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;

import java.util.List;

public interface CongViecService {
    CongViec findById(String maCongViec);
    List<CongViec> findAll();
}
