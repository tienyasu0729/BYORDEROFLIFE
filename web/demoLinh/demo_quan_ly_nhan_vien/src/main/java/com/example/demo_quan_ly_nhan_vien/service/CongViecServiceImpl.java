package com.example.demo_quan_ly_nhan_vien.service;

import com.example.demo_quan_ly_nhan_vien.model.CongViec;
import com.example.demo_quan_ly_nhan_vien.repository.CongViecRepository;
import com.example.demo_quan_ly_nhan_vien.repository.CongViecRepositoryImpl;

import java.util.List;

public class CongViecServiceImpl implements CongViecService {
    private CongViecRepository repository = new CongViecRepositoryImpl();
    @Override
    public CongViec findById(String maCongViec) {
        return repository.findById(maCongViec);
    }

    @Override
    public List<CongViec> findAll() {
        return repository.findAll();
    }
}
