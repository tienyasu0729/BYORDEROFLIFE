package fptu.shopee.Model;

import fptu.shopee.Model.ManyToManyRelationshipTable.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "classification")
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classification")
    private int idClassification;

    @Column(name = "classification_name_1")
    private String classificationName1;

    @Column(name = "classification_name_2")
    private String classificationName2;

    @Column(name = "image_classification")
    private String imageClassification;

    @NotNull
    @Min(value = 0, message = Message.messMinPrice)
    @Max(value = 120000000, message = Message.messMaxPrice)
    @Column(name = "price", nullable = false)
    private int price;

    @NotNull
    @Min(value = 0, message = Message.messMinInventoryQuantity)
    @Column(name = "inventory_quantity", nullable = false)
    private int inventoryQuantity;

    @Column(name = "SKU_classification", length = 500)
    private String skuClassification;

    @NotNull
    @Min(value = 0, message = Message.messSizePackage)
    @Column(name = "packaged_length", nullable = false)
    private Float packagedLength;

    @NotNull
    @Min(value = 0, message = Message.messSizePackage)
    @Column(name = "packaged_width", nullable = false)
    private Float packagedWidth;

    @NotNull
    @Min(value = 0, message = Message.messSizePackage)
    @Column(name = "packaged_height", nullable = false)
    private Float packagedHeight;

    @NotNull
    @Min(value = 0, message = Message.messPackagedWeight)
    @Column(name = "packaged_weight", nullable = false)
    private Float packagedWeight;

    @NotNull
    @Column(name = "allow_package_inspection", nullable = false)
    private Boolean allowPackageInspection = false;

    @NotNull
    @Column(name = "status", nullable = false)
    private Boolean status = false;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductReview> productReviews;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderPendingPayment> listItemsInOrderPendingPayment;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderInTransit> listItemsInOrderInTransit;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderPendingShipment> listItemsInOrderPendingShipment;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderCompleted> listItemsInOrderCompleted;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderCancelled> listItemsInOrderCancelled;

    @OneToMany(mappedBy = "classification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderReturned> listItemsInOrderReturned;

    public int getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(int idClassification) {
        this.idClassification = idClassification;
    }

    public String getClassificationName1() {
        return classificationName1;
    }

    public void setClassificationName1(String classificationName1) {
        this.classificationName1 = classificationName1;
    }

    public String getClassificationName2() {
        return classificationName2;
    }

    public void setClassificationName2(String classificationName2) {
        this.classificationName2 = classificationName2;
    }

    public String getImageClassification() {
        return imageClassification;
    }

    public void setImageClassification(String imageClassification) {
        this.imageClassification = imageClassification;
    }

    @NotNull
    @Min(value = 0, message = Message.messMinPrice)
    @Max(value = 120000000, message = Message.messMaxPrice)
    public int getPrice() {
        return price;
    }

    public void setPrice(@NotNull @Min(value = 0, message = Message.messMinPrice) @Max(value = 120000000, message = Message.messMaxPrice) int price) {
        this.price = price;
    }

    @NotNull
    @Min(value = 0, message = Message.messMinInventoryQuantity)
    public int getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(@NotNull @Min(value = 0, message = Message.messMinInventoryQuantity) int inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getSkuClassification() {
        return skuClassification;
    }

    public void setSkuClassification(String skuClassification) {
        this.skuClassification = skuClassification;
    }

    public @NotNull @Min(value = 0, message = Message.messSizePackage) Float getPackagedLength() {
        return packagedLength;
    }

    public void setPackagedLength(@NotNull @Min(value = 0, message = Message.messSizePackage) Float packagedLength) {
        this.packagedLength = packagedLength;
    }

    public @NotNull @Min(value = 0, message = Message.messSizePackage) Float getPackagedWidth() {
        return packagedWidth;
    }

    public void setPackagedWidth(@NotNull @Min(value = 0, message = Message.messSizePackage) Float packagedWidth) {
        this.packagedWidth = packagedWidth;
    }

    public @NotNull @Min(value = 0, message = Message.messSizePackage) Float getPackagedHeight() {
        return packagedHeight;
    }

    public void setPackagedHeight(@NotNull @Min(value = 0, message = Message.messSizePackage) Float packagedHeight) {
        this.packagedHeight = packagedHeight;
    }

    public @NotNull @Min(value = 0, message = Message.messPackagedWeight) Float getPackagedWeight() {
        return packagedWeight;
    }

    public void setPackagedWeight(@NotNull @Min(value = 0, message = Message.messPackagedWeight) Float packagedWeight) {
        this.packagedWeight = packagedWeight;
    }

    public @NotNull Boolean getAllowPackageInspection() {
        return allowPackageInspection;
    }

    public void setAllowPackageInspection(@NotNull Boolean allowPackageInspection) {
        this.allowPackageInspection = allowPackageInspection;
    }

    public @NotNull Boolean getStatus() {
        return status;
    }

    public void setStatus(@NotNull Boolean status) {
        this.status = status;
    }
}