package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private Long idProduct;

    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "pre_order", nullable = false)
    private Boolean preOrder = false;

    @Column(name = "condition", nullable = false)
    private String condition;

    @Column(name = "SKU_product", nullable = false)
    private String skuProduct;

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public Boolean getPreOrder() {
        return preOrder;
    }

    public void setPreOrder(Boolean preOrder) {
        this.preOrder = preOrder;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getSkuProduct() {
        return skuProduct;
    }

    public void setSkuProduct(String skuProduct) {
        this.skuProduct = skuProduct;
    }
}
