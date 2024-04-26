package model;

import java.util.Date;

public class Phone extends Customer{
    private String manufacturerPhone;
    private String namePhone;
    private String password;
    private String status;

    public Phone() {
    }

    public Phone(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note, String manufacturerPhone, String namePhone, String password, String status) {
        super(id, name, cccd, price, phoneNumber, pawnDate, note);

        // những đoạn if này kiểm tra các thuộc tính trong if nếu rỗng thì sẽ thay thế thành 'Không có' hoặc 'bình thường'
        if (password.replaceAll("\\s+", "").isEmpty()){
            password = "Không có";
        }
        if (status.replaceAll("\\s+", "").isEmpty()){
            status = "Bình thường";
        }

        this.manufacturerPhone = manufacturerPhone;
        this.namePhone = namePhone;
        this.password = password;
        this.status = status;
    }

    public String getManufacturerPhone() {
        return manufacturerPhone;
    }

    public void setManufacturerPhone(String manufacturerPhone) {
        this.manufacturerPhone = manufacturerPhone;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
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
                " | Hãng: " + manufacturerPhone +
                " | Tên máy: " + namePhone +
                " | Ngày cầm: " + getPawnDate() +
                " | SĐT: " + getPhoneNumber() +
                " | Mật khẩu: " + password +
                " | Tình trạng: " + status +
                " | Ghi chú: " + getNote();
    }
}
