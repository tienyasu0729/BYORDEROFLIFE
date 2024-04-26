package model.entity;

import java.io.Serializable;

public class AccompaniedService implements Serializable {
    private int id;
    private String accompaniedService;
    private int unit;
    private double price;
    public AccompaniedService(int id, String accompaniedService, int unit, double price) {
        this.id = id;
        this.accompaniedService = accompaniedService;
        this.unit = unit;
        this.price = price;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAccompaniedService() {
        return accompaniedService;
    }
    public void setAccompaniedService(String accompaniedService) {
        this.accompaniedService = accompaniedService;
    }
    public int getUnit() {
        return unit;
    }
    public void setUnit(int unit) {
        this.unit = unit;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "AccompaniedService [id=" + id + ", accompaniedService=" + accompaniedService + ", unit=" + unit
                + ", price=" + price + "]";
    }
    
}
