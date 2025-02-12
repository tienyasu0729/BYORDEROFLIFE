package fptu.shopee2.Model.ManyToManyRelationshipTable.EmbeddedID;

import fptu.shopee.Model.ProductPakage.Product;
import fptu.shopee.Model.ShopPackage.Shop;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductGroupId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_shop")
    private Shop shop;

    public ProductGroupId() {}

    public ProductGroupId(Product product, Shop shop) {
        this.product = product;
        this.shop = shop;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductGroupId)) return false;
        ProductGroupId that = (ProductGroupId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(shop, that.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, shop);
    }
}
