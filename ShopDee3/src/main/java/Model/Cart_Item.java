/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Han
 */
public class Cart_Item {
    private int cartDetailID;
    private int cartID;
    private String productName;
    private String size;
    private String color;
    private int quantity;
    private double price;
    private String cartImg;

    public Cart_Item(int cartDetailID, int cartID, String productName, String size, String color, int quantity, double price, String cartImg) {
        this.cartDetailID = cartDetailID;
        this.cartID = cartID;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
        this.cartImg = cartImg;
    }

    public Cart_Item(int cartID, String productName, String size, String color, int quantity, double price, String cartImg) {
        this.cartID = cartID;
        this.productName = productName;
        this.size = size;
        this.color = color;
        this.quantity = quantity;
        this.price = price;
        this.cartImg = cartImg;
    }


    public Cart_Item() {
    }

    public int getCartDetailID() {
        return cartDetailID;
    }

    public void setCartDetailID(int cartDetailID) {
        this.cartDetailID = cartDetailID;
    }

    public int getCartID() {
        return cartID;
    }

    public void setCartID(int cartID) {
        this.cartID = cartID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCartImg() {
        return cartImg;
    }

    public void setCartImg(String cartImg) {
        this.cartImg = cartImg;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cart_Item{");
        sb.append("cartDetailID=").append(cartDetailID);
        sb.append(", cartID=").append(cartID);
        sb.append(", productName=").append(productName);
        sb.append(", size=").append(size);
        sb.append(", color=").append(color);
        sb.append(", quantity=").append(quantity);
        sb.append(", price=").append(price);
        sb.append(", cartImg=").append(cartImg);
        sb.append('}');
        return sb.toString();
    }

 

   
    
}
