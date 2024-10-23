package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "delivery_voucher")
public class DeliveryVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_delivery_voucher")
    private int idDeliveryVoucher;

    @NotNull
    @Min(value = 1, message = Message.messDiscountPercentage)
    @Column(name = "discount_percentage", nullable = false)
    private Float discountPercentage;

    @Min(value = 0, message = Message.messMaximumDiscountAmount)
    @Column(name = "maximum_discount_amount")
    private Float maximumDiscountAmount;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "discount_start_date", nullable = false)
    private Date discountStartDate;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "discount_end_date", nullable = false)
    private Date discountEndDate;

    @Column(name = "offer_description", length = 500)
    private String offerDescription;

    @Column(name = "thiet_bi", length = 100)
    private String device;

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    @ManyToOne
    @JoinColumn(name = "id_shipping_method")
    private ShippingMethod shippingMethod;

    @OneToMany(mappedBy = "deliveryVoucher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderPendingPayment> userOrderPendingPayments;

    @OneToMany(mappedBy = "deliveryVoucher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderInTransit> userOrderInTransits;

    @OneToMany(mappedBy = "deliveryVoucher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderPendingShipment> userOrderPendingShipments;

    @OneToMany(mappedBy = "deliveryVoucher", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<UserOrderReturned> userOrderReturneds;

    public int getIdDeliveryVoucher() {
        return idDeliveryVoucher;
    }

    public void setIdDeliveryVoucher(int idDeliveryVoucher) {
        this.idDeliveryVoucher = idDeliveryVoucher;
    }

    public Float getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Float discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public Float getMaximumDiscountAmount() {
        return maximumDiscountAmount;
    }

    public void setMaximumDiscountAmount(Float maximumDiscountAmount) {
        this.maximumDiscountAmount = maximumDiscountAmount;
    }

    public Date getDiscountStartDate() {
        return discountStartDate;
    }

    public void setDiscountStartDate(Date discountStartDate) {
        this.discountStartDate = discountStartDate;
    }

    public Date getDiscountEndDate() {
        return discountEndDate;
    }

    public void setDiscountEndDate(Date discountEndDate) {
        this.discountEndDate = discountEndDate;
    }

    public String getOfferDescription() {
        return offerDescription;
    }

    public void setOfferDescription(String offerDescription) {
        this.offerDescription = offerDescription;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    @PrePersist
    @PreUpdate
    private void validateDiscountDates() {
        Date currentDate = new Date();
        if (discountStartDate.before(currentDate)) {
            throw new IllegalArgumentException(Message.messStartDate);
        }
        if (discountEndDate.before(discountStartDate)) {
            throw new IllegalArgumentException(Message.messEndDate);
        }
    }
}