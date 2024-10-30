package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ProductShippingMethodId;
import fptu.shopee.Model.ProductPakage.Product;
import fptu.shopee.Model.ShippingMethod;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_shipping_method")
public class ProductShippingMethod {

    @EmbeddedId
    private ProductShippingMethodId id;

    public ProductShippingMethod() {}

    public ProductShippingMethod(Product product, ShippingMethod shippingMethod) {
        this.id = new ProductShippingMethodId(product, shippingMethod);
    }

    public ProductShippingMethodId getId() {
        return id;
    }

    public void setId(ProductShippingMethodId id) {
        this.id = id;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public ShippingMethod getShippingMethod() {
        return id.getShippingMethod();
    }
}