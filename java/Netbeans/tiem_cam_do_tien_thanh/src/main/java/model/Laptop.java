package model;

import java.util.Date;

public class Laptop extends Customer{
    private String manufacturerLaptop;
    private String nameLaptop;
    private String password;
    private String status;

    public Laptop(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note, String manufacturerLaptop, String nameLaptop, String password, String status) {
        super(id, name, cccd, price, phoneNumber, pawnDate, note);

        // những đoạn if này kiểm tra các thuộc tính trong if nếu rỗng thì sẽ thay thế thành 'Không có' hoăc 'bình thường'
        if (password.replaceAll("\\s+", "").isEmpty()){
            password = "Không có";
        }
        if (status.replaceAll("\\s+", "").isEmpty()){
            status = "Bình thường";
        }

        this.manufacturerLaptop = manufacturerLaptop;
        this.nameLaptop = nameLaptop;
        this.password = password;
        this.status = status;
    }

    public String getManufacturerLaptop() {
        return manufacturerLaptop;
    }

    public void setManufacturerLaptop(String manufacturerLaptop) {
        this.manufacturerLaptop = manufacturerLaptop;
    }

    public String getNameLaptop() {
        return nameLaptop;
    }

    public void setNameLaptop(String nameLaptop) {
        this.nameLaptop = nameLaptop;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return getId() +
                " . Tên: " + getName() +
                " | CCCD: " + getCccd() +
                " | Số tiền cầm: " + getPrice() +
                " | Hãng máy tính: " + manufacturerLaptop +
                " | Tên máy tính: " + nameLaptop +
                " | Ngày cầm: " + getPawnDate() +
                " | SĐT: " + getPhoneNumber() +
                " | Mật khẩu: " + password +
                " | Tình trạng: " + status +
                " | Ghi chú: " + getNote();
    }
}
