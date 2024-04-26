package CCCD.model;

public class CCCD {
    private String cccd;
    private String name;
    private int price;
    private int dayIn;
    private int monthIn;
    private int yearIn;
    private int dayOut;
    private int monthOut;
    private int yearOut;

    public CCCD(String cccd, String name, int price, int dayIn, int monthIn, int yearIn) {
        this.cccd = cccd;
        this.name = name;
        this.price = price;
        this.dayIn = dayIn;
        this.monthIn = monthIn;
        this.yearIn = yearIn;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDayIn() {
        return dayIn;
    }

    public void setDayIn(int dayIn) {
        this.dayIn = dayIn;
    }

    public int getMonthIn() {
        return monthIn;
    }

    public void setMonthIn(int monthIn) {
        this.monthIn = monthIn;
    }

    public int getYearIn() {
        return yearIn;
    }

    public void setYearIn(int yearIn) {
        this.yearIn = yearIn;
    }

    public int getDayOut() {
        return dayOut;
    }

    public void setDayOut(int dayOut) {
        this.dayOut = dayOut;
    }

    public int getMonthOut() {
        return monthOut;
    }

    public void setMonthOut(int monthOut) {
        this.monthOut = monthOut;
    }

    public int getYearOut() {
        return yearOut;
    }

    public void setYearOut(int yearOut) {
        this.yearOut = yearOut;
    }
}
