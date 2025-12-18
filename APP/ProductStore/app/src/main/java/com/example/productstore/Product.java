package com.example.productstore;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String imageUrl;

    // Constructor
    public Product(int id, String name, String description, double price, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    // Getters (Hàm lấy dữ liệu)
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
    public double getPrice() {
        return price;
    }
    public String getImageUrl() {
        return imageUrl;
    }

    // Setters (Hàm thiết lập dữ liệu)
    public void setId(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}