package model;

import java.util.Date;

public class Vehicle extends Customer{
   private String manufacturerVehicle;
   private String nameVehicle;
   private String licensePlate;
   private String statusVehicle;

    public Vehicle(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note, String manufacturerVehicle, String nameVehicle, String licensePlate, String statusVehicle) {
        super(id, name, cccd, price, phoneNumber, pawnDate, note);
        // những đoạn if này kiểm tra các thuộc tính trong if nếu rỗng thì sẽ thay thế thành 'bình thường'
        if (statusVehicle.replaceAll("\\s+", "").isEmpty()){
            statusVehicle = "Bình thường";
        }

        this.manufacturerVehicle = manufacturerVehicle;
        this.nameVehicle = nameVehicle;
        this.licensePlate = licensePlate;
        this.statusVehicle = statusVehicle;
    }

    public String getManufacturerVehicle() {
        return manufacturerVehicle;
    }

    public void setManufacturerVehicle(String manufacturerVehicle) {
        this.manufacturerVehicle = manufacturerVehicle;
    }

    public String getNameVehicle() {
        return nameVehicle;
    }

    public void setNameVehicle(String nameVehicle) {
        this.nameVehicle = nameVehicle;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatusVehicle() {
        return statusVehicle;
    }

    public void setStatusVehicle(String statusVehicle) {
        this.statusVehicle = statusVehicle;
    }

    @Override
    public String toString() {
        return getId() +
                " . Tên chủ xe: " + getName() +
                " | CCCD: " + getCccd() +
                " | Số tiền cầm: " + getPrice() +
                " | Hãng xe: " + manufacturerVehicle +
                " | Tên xe: " + nameVehicle +
                " | Ngày cầm: " + getPawnDate() +
                " | SĐT: " + getPhoneNumber() +
                " | Biển số xe: " + licensePlate +
                " | Tình trạng xe: " + statusVehicle +
                " | Ghi chú: " + getNote();
    }
}
