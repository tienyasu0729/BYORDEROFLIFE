package com.example.demo_quan_ly_nhan_vien.model;

import java.util.Date;

public class NhanVien {
    private String maNhanVien;
    private String hoTen;
    private Date ngaySinh;
    private String diaChi;
    private Date ngayBatDauLam;
    private Date ngayKetThucLam;
    private double luong;
    private CongViec maCongViec;
    public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String diaChi, Date ngayBatDauLam, Date ngayKetThucLam, double luong, CongViec maCongViec) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.ngayBatDauLam = ngayBatDauLam;
        this.ngayKetThucLam = ngayKetThucLam;
        this.luong = luong;
        this.maCongViec = maCongViec;
    }
    public NhanVien() {
    }

    public NhanVien(String maNhanVien, String hoTen, Date ngaySinh, String diaChi, Date ngayBatDauLam, Date ngayKetThucLam, double luong) {
        this.maNhanVien = maNhanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.ngayBatDauLam = ngayBatDauLam;
        this.ngayKetThucLam = ngayKetThucLam;
        this.luong = luong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public Date getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public Date getNgayKetThucLam() {
        return ngayKetThucLam;
    }

    public void setNgayKetThucLam(Date ngayKetThucLam) {
        this.ngayKetThucLam = ngayKetThucLam;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public CongViec getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(CongViec maCongViec) {
        this.maCongViec = maCongViec;
    }
}
