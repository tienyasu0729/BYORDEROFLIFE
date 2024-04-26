package tiem_cam_do_tien_thanh.model;

public class Human {
    private String cccd;
    private String name;
    private String address;
    private String phoneNumber;

    public Human(String cccd, String name, String phoneNumber) {
        this.name = name;
        this.cccd = cccd;
        this.phoneNumber = phoneNumber;
    }

    public Human(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Human(String cccd, String name, String address, String phoneNumber) {
        this.cccd = cccd;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
