package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ShippingMethod;
import fptu.shopee.Model.Shop;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "shop_shipping_method")
public class ShopShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop_shipping_method")
    private int idShopShippingMethod;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shop", nullable = false)
    private Shop shop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_shipping_method", nullable = false)
    private ShippingMethod shippingMethod;

    public ShopShippingMethod() {}

    public ShopShippingMethod(Shop shop, ShippingMethod shippingMethod) {
        this.shop = shop;
        this.shippingMethod = shippingMethod;
    }

    public int getId() {
        return idShopShippingMethod;
    }

    public void setId(int idShopShippingMethod) {
        this.idShopShippingMethod = idShopShippingMethod;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public ShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(ShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
