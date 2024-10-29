package fptu.shopee.Model;

import fptu.shopee.Model.ManyToManyRelationshipTable.ListItemInOrderReturned;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_order_returned")
public class UserOrderReturned {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_returned")
    private Long idOrderReturned;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_datetime", nullable = false)
    private Date orderDatetime;

    @PrePersist
    protected void onCreate() {
        orderDatetime = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_shop_voucher")
    private ShopVoucher shopVoucher;

    @ManyToOne
    @JoinColumn(name = "id_web_voucher")
    private WebVoucher webVoucher;

    @ManyToOne
    @JoinColumn(name = "id_delivery_voucher")
    private DeliveryVoucher deliveryVoucher;

    @OneToMany(mappedBy = "userOrderReturned", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderReturned> listItemsInOrderReturned;


    public Long getIdOrderReturned() {
        return idOrderReturned;
    }

    public void setIdOrderReturned(Long idOrderReturned) {
        this.idOrderReturned = idOrderReturned;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}
