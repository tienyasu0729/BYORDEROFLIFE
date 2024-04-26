package model;

public class Motorbike {
    private String manufacturer;
    private String nameBike;
    private String ownerName;
    private String licensePlates;
    private String status;

    public Motorbike(String manufacturer, String nameBike, String ownerName, String licensePlates, String status) {
        this.manufacturer = manufacturer;
        this.nameBike = nameBike;
        this.ownerName = ownerName;
        this.licensePlates = licensePlates;
        this.status = status;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getNameBike() {
        return nameBike;
    }

    public void setNameBike(String nameBike) {
        this.nameBike = nameBike;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getLicensePlates() {
        return licensePlates;
    }

    public void setLicensePlates(String licensePlates) {
        this.licensePlates = licensePlates;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
