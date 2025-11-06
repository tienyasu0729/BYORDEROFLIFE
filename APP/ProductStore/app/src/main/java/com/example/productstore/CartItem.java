package com.example.productstore;

public class CartItem {
    private int cartId;
    private int productId;
    private String productName;
    private double productPrice;
    private int quantity;

    // Constructor
    public CartItem(int cartId, int productId, String productName, double productPrice, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    // Getters
    public int getCartId() {
        return cartId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setters
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}