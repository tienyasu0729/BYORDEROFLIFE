package model;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {
    private int id;
    private String name;
    private String cccd;
    private int price;
    private String phoneNumber;
    private Date pawnDate;
    private String note;

    public Customer() {
    }

    public Customer(int id, String name, String cccd, int price, String phoneNumber, Date pawnDate, String note) {
        if (cccd.replaceAll("\\s+", "").isEmpty()){
            cccd = "Không có";
        }
        if (phoneNumber.replaceAll("\\s+", "").isEmpty()){
            phoneNumber = "Không có";
        }
        if (note.replaceAll("\\s+", "").isEmpty()){
            note = "Không có";
        }
        this.id = id;
        this.name = name;
        this.cccd = cccd;
        this.price = price;
        this.phoneNumber = phoneNumber;
        this.pawnDate = pawnDate;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getPawnDate() {
        return pawnDate;
    }

    public void setPawnDate(Date pawnDate) {
        this.pawnDate = pawnDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public String stringID(){
        return String.valueOf(id);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cccd='" + cccd + '\'' +
                ", price=" + price +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", pawnDate=" + pawnDate +
                ", note='" + note + '\'' +
                '}';
    }
}
