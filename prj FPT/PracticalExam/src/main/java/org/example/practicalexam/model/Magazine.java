package org.example.practicalexam.model;

public class Magazine {
    private String mazID;
    private String magazineTitle;
    private String publisher;
    private int price;

    public Magazine(String mazID, String magazineTitle, String publisher, int price) {
        this.mazID = mazID;
        this.magazineTitle = magazineTitle;
        this.publisher = publisher;
        this.price = price;
    }

    public String getMazID() {
        return mazID;
    }

    public void setMazID(String mazID) {
        this.mazID = mazID;
    }

    public String getMagazineTitle() {
        return magazineTitle;
    }

    public void setMagazineTitle(String magazineTitle) {
        this.magazineTitle = magazineTitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
