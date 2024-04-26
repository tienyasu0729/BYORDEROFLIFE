package com.example.demo_quan_ly_nhan_vien.model;

public class CongViec {
    private String maCongViec;
    private String tenCongViec;
    private double luongThapNhat;
    private double luongCaoNhat;

    public CongViec() {
    }

    public CongViec(String maCongViec, String tenCongViec, double luongThapNhat, double luongCaoNhat) {
        this.maCongViec = maCongViec;
        this.tenCongViec = tenCongViec;
        this.luongThapNhat = luongThapNhat;
        this.luongCaoNhat = luongCaoNhat;
    }

    public String getMaCongViec() {
        return maCongViec;
    }

    public void setMaCongViec(String maCongViec) {
        this.maCongViec = maCongViec;
    }

    public String getTenCongViec() {
        return tenCongViec;
    }

    public void setTenCongViec(String tenCongViec) {
        this.tenCongViec = tenCongViec;
    }

    public double getLuongThapNhat() {
        return luongThapNhat;
    }

    public void setLuongThapNhat(double luongThapNhat) {
        this.luongThapNhat = luongThapNhat;
    }

    public double getLuongCaoNhat() {
        return luongCaoNhat;
    }

    public void setLuongCaoNhat(double luongCaoNhat) {
        this.luongCaoNhat = luongCaoNhat;
    }
}
