package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Product;
import fptu.shopee.Model.ShippingMethod;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ProductShippingMethodId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_shipping_method")
    private ShippingMethod shippingMethod;

    public ProductShippingMethodId() {}

    public ProductShippingMethodId(Product product, ShippingMethod shippingMethod) {
        this.product = product;
        this.shippingMethod = shippingMethod;
    }

    // Getters and Setters
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductShippingMethodId)) return false;
        ProductShippingMethodId that = (ProductShippingMethodId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(shippingMethod, that.shippingMethod);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, shippingMethod);
    }
}
