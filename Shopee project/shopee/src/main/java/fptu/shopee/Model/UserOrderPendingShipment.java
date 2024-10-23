package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "user_order_pending_shipment")
public class UserOrderPendingShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_pending_shipment")
    private Long idOrderPendingShipment;

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

    public Long getIdOrderPendingShipment() {
        return idOrderPendingShipment;
    }

    public void setIdOrderPendingShipment(Long idOrderPendingShipment) {
        this.idOrderPendingShipment = idOrderPendingShipment;
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