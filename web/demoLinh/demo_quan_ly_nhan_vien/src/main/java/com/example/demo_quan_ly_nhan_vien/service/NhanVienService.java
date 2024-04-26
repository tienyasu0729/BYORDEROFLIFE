package com.example.demo_quan_ly_nhan_vien.service;

import com.example.demo_quan_ly_nhan_vien.model.NhanVien;

import java.util.List;

public interface NhanVienService {
    void add(NhanVien nhanVien);
    void update(NhanVien nhanVien);
    List<NhanVien> findAll();
    List<NhanVien> findByTenCongViec(String tenCongViec);
    List<NhanVien> findByNgayLamVaNgayKetThuc(String ngayBatDauLam, String ngayKetThucLam);
}
