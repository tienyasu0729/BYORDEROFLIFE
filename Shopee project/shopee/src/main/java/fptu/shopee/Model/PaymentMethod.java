package fptu.shopee.Model;

import fptu.shopee.Model.OrderPakage.*;
import fptu.shopee.Model.VoucherPakage.DeliveryVoucher;
import fptu.shopee.Model.VoucherPakage.ShopVoucher;
import fptu.shopee.Model.VoucherPakage.WebVoucher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method")
    private int idPaymentMethod;

    @NotNull
    @Column(name = "payment_method_name", nullable = false)
    private String paymentMethodName;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ShopVoucher> shopVouchers;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<WebVoucher> webVouchers;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DeliveryVoucher> deliveryVouchers;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderPendingPayment> userOrderPendingPayments;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderInTransit> userOrderInTransits;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderPendingShipment> userOrderPendingShipments;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderCompleted> userOrderCompleteds;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderCancelled> userOrderCancelleds;

    @OneToMany(mappedBy = "paymentMethod", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderReturned> userOrderReturneds;

    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }
}
