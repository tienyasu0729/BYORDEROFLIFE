package fptu.shopee.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_order_pending_shipment")
public class UserOrderPendingShipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_pending_shipment")
    private Long idOrderPendingShipment;

    @Column(name = "shop_voucher")
    private String shopVoucher;

    @Column(name = "web_voucher")
    private String webVoucher;

    @Column(name = "delivery_voucher")
    private String deliveryVoucher;

    @Column(name = "note_to_seller", length = 500)
    private String noteToSeller;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_datetime", nullable = false)
    private Date orderDatetime;

    public Long getIdOrderPendingShipment() {
        return idOrderPendingShipment;
    }

    public void setIdOrderPendingShipment(Long idOrderPendingShipment) {
        this.idOrderPendingShipment = idOrderPendingShipment;
    }

    public String getShopVoucher() {
        return shopVoucher;
    }

    public void setShopVoucher(String shopVoucher) {
        this.shopVoucher = shopVoucher;
    }

    public String getWebVoucher() {
        return webVoucher;
    }

    public void setWebVoucher(String webVoucher) {
        this.webVoucher = webVoucher;
    }

    public String getDeliveryVoucher() {
        return deliveryVoucher;
    }

    public void setDeliveryVoucher(String deliveryVoucher) {
        this.deliveryVoucher = deliveryVoucher;
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