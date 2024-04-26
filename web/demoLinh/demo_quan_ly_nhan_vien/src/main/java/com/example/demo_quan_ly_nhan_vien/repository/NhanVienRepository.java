package com.example.demo_quan_ly_nhan_vien.repository;

import com.example.demo_quan_ly_nhan_vien.model.NhanVien;

import java.util.List;

public interface NhanVienRepository {
    void add(NhanVien nhanVien);
    void update(NhanVien nhanVien);
    List<NhanVien> findAll();
    List<NhanVien> findByTenCongViec(String tenCongViec);
    List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam);
}
