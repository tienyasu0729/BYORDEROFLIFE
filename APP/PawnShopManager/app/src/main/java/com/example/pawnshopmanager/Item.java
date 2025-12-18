package com.example.pawnshopmanager;


import java.io.Serializable;

// Lớp này là vật phẩm
// Implement Serializable để truyền giữa các Activity
public class Item implements Serializable {

    private int id;
    private String tenNguoiCam;
    private String tenVatPham; // Tên vật phẩm
    private double giaTienCam;
    private String ngayCam; // Lưu dạng "YYYY-MM-DD"
    private String ghiChu;
    private String type; // 'phone', 'laptop', 'vehicle'

    // Dành riêng cho xe
    private String maSoCCCD;
    private String diaChi;
    private String bienSoXe;

    // Constructors
    public Item() {}

    // Getters and Setters (Bạn nên tự động tạo cho tất cả)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getTenNguoiCam() { return tenNguoiCam; }
    public void setTenNguoiCam(String tenNguoiCam) { this.tenNguoiCam = tenNguoiCam; }
    public String getTenVatPham() { return tenVatPham; }
    public void setTenVatPham(String tenVatPham) { this.tenVatPham = tenVatPham; }
    public double getGiaTienCam() { return giaTienCam; }
    public void setGiaTienCam(double giaTienCam) { this.giaTienCam = giaTienCam; }
    public String getNgayCam() { return ngayCam; }
    public void setNgayCam(String ngayCam) { this.ngayCam = ngayCam; }
    public String getGhiChu() { return ghiChu; }
    public void setGhiChu(String ghiChu) { this.ghiChu = ghiChu; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getMaSoCCCD() { return maSoCCCD; }
    public void setMaSoCCCD(String maSoCCCD) { this.maSoCCCD = maSoCCCD; }
    public String getDiaChi() { return diaChi; }
    public void setDiaChi(String diaChi) { this.diaChi = diaChi; }
    public String getBienSoXe() { return bienSoXe; }
    public void setBienSoXe(String bienSoXe) { this.bienSoXe = bienSoXe; }
}
