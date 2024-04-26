package model;

public class Phone {
    private String manufacturer;
    private String namePhone;
    private String status;
    private String password;
    private String icloud;
    private String passIcloud;

    public Phone(String manufacturer, String namePhone, String status, String password) {
        this.manufacturer = manufacturer;
        this.namePhone = namePhone;
        this.status = status;
        this.password = password;
    }

    public Phone(String manufacturer, String namePhone, String status, String password, String icloud, String passIcloud) {
        this.manufacturer = manufacturer;
        this.namePhone = namePhone;
        this.status = status;
        this.password = password;
        this.icloud = icloud;
        this.passIcloud = passIcloud;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNamePhone() {
        return namePhone;
    }

    public void setNamePhone(String namePhone) {
        this.namePhone = namePhone;
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

    public String getIcloud() {
        return icloud;
    }

    public void setIcloud(String icloud) {
        this.icloud = icloud;
    }

    public String getPassIcloud() {
        return passIcloud;
    }

    public void setPassIcloud(String passIcloud) {
        this.passIcloud = passIcloud;
    }
}
