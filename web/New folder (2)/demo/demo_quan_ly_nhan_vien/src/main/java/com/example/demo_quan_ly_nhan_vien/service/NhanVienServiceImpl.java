package com.example.demo_quan_ly_nhan_vien.service;

import com.example.demo_quan_ly_nhan_vien.model.NhanVien;
import com.example.demo_quan_ly_nhan_vien.repository.NhanVienRepository;
import com.example.demo_quan_ly_nhan_vien.repository.NhanVienRepositoryImpl;

import java.util.List;

import static java.sql.DriverManager.getConnection;

public class NhanVienServiceImpl implements NhanVienService {
    private NhanVienRepository repository = new NhanVienRepositoryImpl();
    @Override
    public void add(NhanVien nhanVien) {
        repository.add(nhanVien);
    }

    @Override
    public void update(NhanVien nhanVien) {
        repository.update(nhanVien);
    }

    @Override
    public List<NhanVien> findAll() {
        return repository.findAll();
    }

    @Override
    public List<NhanVien> findByTenCongViec(String tenCongViec) {
        return repository.findByTenCongViec(tenCongViec);
    }

    @Override
    public List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam) {
        return repository.findByNgayLamVaNgayKetThuc(ngayBatDauLam, ngayKetThucLam);
    }
}
