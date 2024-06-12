/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Han
 */
public class Product {
    
    private int productID ;
    private String productName;
    private String productType;
    private String categories ;
    private double price;
    private String description;
    private int numberOfProduct;
    private String productImg;
    private String size;
    private String color;


    public Product(int productID, String productName, String productType, String categories, double price, String description, int numberOfProduct, String productImg, String size, String color) {
        this.productID = productID;
        this.productName = productName;
        this.productType = productType;
        this.categories = categories;
        this.price = price;
        this.description = description;
        this.numberOfProduct = numberOfProduct;
        this.productImg = productImg;
        this.size = size;
        this.color = color;
    }

    public Product(String productName, String productType, String categories, double price, String description, String productImg, String size, String color) {
        this.productName = productName;
        this.productType = productType;
        this.categories = categories;
        this.price = price;
        this.description = description;
//      this.numberOfProduct = numberOfProduct;
        this.productImg = productImg;
        this.size = size;
        this.color = color;
    }

    public Product(String productName, double price, String productImg, String size, String color) {
        this.productName = productName;
        this.price = price;
        this.productImg = productImg;
        this.size = size;
        this.color = color;
    }


    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfProduct() {
        return numberOfProduct;
    }

    public void setNumberOfProduct(int numberOfProduct) {
        this.numberOfProduct = numberOfProduct;
    }

    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Product{");
        sb.append("productID=").append(productID);
        sb.append(", productName=").append(productName);
        sb.append(", productType=").append(productType);
        sb.append(", categories=").append(categories);
        sb.append(", price=").append(price);
        sb.append(", description=").append(description);
        sb.append(", numberOfProduct=").append(numberOfProduct);
        sb.append(", productImg=").append(productImg);
        sb.append(", size=").append(size);
        sb.append(", color=").append(color);
        sb.append('}');
        return sb.toString();
    }
    
    
}
