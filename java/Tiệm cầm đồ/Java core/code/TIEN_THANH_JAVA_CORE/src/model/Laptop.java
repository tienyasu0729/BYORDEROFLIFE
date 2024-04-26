package model;

public class Laptop {
    private String manufacturer;
    private String nameLaptop;
    private String status;
    private String password;

    public Laptop(String manufacturer, String nameLaptop, String status, String password) {
        this.manufacturer = manufacturer;
        this.nameLaptop = nameLaptop;
        this.status = status;
        this.password = password;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNameLaptop() {
        return nameLaptop;
    }

    public void setNameLaptop(String nameLaptop) {
        this.nameLaptop = nameLaptop;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
