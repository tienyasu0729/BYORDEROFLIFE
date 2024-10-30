package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ProductGroupId;
import fptu.shopee.Model.ProductPakage.Product;
import fptu.shopee.Model.ShopPackage.Shop;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_group")
public class ProductGroup {

    @EmbeddedId
    private ProductGroupId id;

    @NotNull
    @Column(name = "name_group", nullable = false)
    private String nameGroup;

    public ProductGroup() {}

    public ProductGroup(Product product, Shop shop, String nameGroup) {
        this.id = new ProductGroupId(product, shop);
        this.nameGroup = nameGroup;
    }

    public ProductGroupId getId() {
        return id;
    }

    public void setId(ProductGroupId id) {
        this.id = id;
    }

    public String getNameGroup() {
        return nameGroup;
    }

    public void setNameGroup(String nameGroup) {
        this.nameGroup = nameGroup;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public Shop getShop() {
        return id.getShop();
    }
}
