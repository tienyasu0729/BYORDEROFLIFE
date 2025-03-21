package fptu.demodb;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product")
    private int idProduct;

    @NotNull
    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    @NotNull
    @Column(name = "product_description", nullable = false)
    private String productDescription;

    @NotNull
    @Column(name = "pre_order", nullable = false)
    private Boolean preOrder = false;

    @NotNull
    @Column(name = "`condition`", nullable = false)
    private String condition;

    @Column(name = "SKU_product")
    private String skuProduct;

    @OneToMany(mappedBy = "id.product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CategoryValue> categoryValues;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
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
