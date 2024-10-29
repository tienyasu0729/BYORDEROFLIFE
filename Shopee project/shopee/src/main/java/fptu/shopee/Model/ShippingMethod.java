package fptu.shopee.Model;
import fptu.shopee.Model.ManyToManyRelationshipTable.ProductShippingMethod;
import fptu.shopee.Model.ManyToManyRelationshipTable.ShopShippingMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "shipping_method")
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shipping_method")
    private int idShippingMethod;

    @NotNull
    @Column(name = "method_name", length = 500)
    private String methodName;

    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ShopVoucher> shopVouchers;

    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WebVoucher> webVouchers;

    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DeliveryVoucher> deliveryVouchers;

    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ShopShippingMethod> shopShippingMethods = new HashSet<>();

    @OneToMany(mappedBy = "shippingMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductShippingMethod> productShippingMethods;

    public int getIdShippingMethod() {
        return idShippingMethod;
    }

    public void setIdShippingMethod(int idShippingMethod) {
        this.idShippingMethod = idShippingMethod;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}

