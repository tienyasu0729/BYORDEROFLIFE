package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "classification_value")
public class ClassificationValue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classification_value")
    private Long idClassificationValue;

    @Column(name = "classification_value", nullable = false)
    private String classificationValue;

    @Column(name = "price", nullable = false)
    private Float price;

    @Column(name = "inventory_quantity", nullable = false)
    private Integer inventoryQuantity;

    @Column(name = "SKU_classification", length = 50)
    private String skuClassification;

    @Column(name = "packaged_length")
    private Float packagedLength;

    @Column(name = "packaged_width")
    private Float packagedWidth;

    @Column(name = "packaged_weight")
    private Float packagedWeight;

    @Column(name = "packaged_height")
    private Float packagedHeight;

    @Column(name = "allow_package_inspection", nullable = false)
    private Boolean allowPackageInspection;

    @Column(name = "status", nullable = false)
    private Boolean status;

    public Long getIdClassificationValue() {
        return idClassificationValue;
    }

    public void setIdClassificationValue(Long idClassificationValue) {
        this.idClassificationValue = idClassificationValue;
    }

    public String getClassificationValue() {
        return classificationValue;
    }

    public void setClassificationValue(String classificationValue) {
        this.classificationValue = classificationValue;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getInventoryQuantity() {
        return inventoryQuantity;
    }

    public void setInventoryQuantity(Integer inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }

    public String getSkuClassification() {
        return skuClassification;
    }

    public void setSkuClassification(String skuClassification) {
        this.skuClassification = skuClassification;
    }

    public Float getPackagedLength() {
        return packagedLength;
    }

    public void setPackagedLength(Float packagedLength) {
        this.packagedLength = packagedLength;
    }

    public Float getPackagedWidth() {
        return packagedWidth;
    }

    public void setPackagedWidth(Float packagedWidth) {
        this.packagedWidth = packagedWidth;
    }

    public Float getPackagedWeight() {
        return packagedWeight;
    }

    public void setPackagedWeight(Float packagedWeight) {
        this.packagedWeight = packagedWeight;
    }

    public Float getPackagedHeight() {
        return packagedHeight;
    }

    public void setPackagedHeight(Float packagedHeight) {
        this.packagedHeight = packagedHeight;
    }

    public Boolean getAllowPackageInspection() {
        return allowPackageInspection;
    }

    public void setAllowPackageInspection(Boolean allowPackageInspection) {
        this.allowPackageInspection = allowPackageInspection;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
