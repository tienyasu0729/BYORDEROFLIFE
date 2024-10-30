package fptu.shopee.Model.OrderPakage;

import fptu.shopee.Model.ManyToManyRelationshipTable.ListItemInOrderInTransit;
import fptu.shopee.Model.PaymentMethod;
import fptu.shopee.Model.VoucherPakage.DeliveryVoucher;
import fptu.shopee.Model.VoucherPakage.ShopVoucher;
import fptu.shopee.Model.VoucherPakage.WebVoucher;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_order_in_transit")
public class UserOrderInTransit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_in_transit")
    private Long idOrderInTransit;

    @Column(name = "note_to_seller", length = 500)
    private String noteToSeller;

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

    @OneToMany(mappedBy = "id.userOrderInTransit", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderInTransit> listItemsInOrderInTransit;

    public Long getIdOrderInTransit() {
        return idOrderInTransit;
    }

    public void setIdOrderInTransit(Long idOrderInTransit) {
        this.idOrderInTransit = idOrderInTransit;
    }

    public String getNoteToSeller() {
        return noteToSeller;
    }

    public void setNoteToSeller(String noteToSeller) {
        this.noteToSeller = noteToSeller;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}
