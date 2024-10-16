package fptu.shopee.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "shop_voucher")
public class ShopVoucher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop_voucher")
    private Long idShopVoucher;

    @Column(name = "discount_percentage", nullable = false)
    private Float discountPercentage;

    @Column(name = "maximum_discount_amount", nullable = false)
    private Float maximumDiscountAmount;

    @Temporal(TemporalType.DATE)
    @Column(name = "discount_start_date", nullable = false)
    private Date discountStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "discount_end_date", nullable = false)
    private Date discountEndDate;

    @Column(name = "offer_description", length = 500)
    private String offerDescription;

    @Column(name = "don_vi_van_chuyen", length = 100)
    private String shippingUnit;

    @Column(name = "thiet_bi", length = 100)
    private String device;

    public Long getIdShopVoucher() {
        return idShopVoucher;
    }

    public void setIdShopVoucher(Long idShopVoucher) {
        this.idShopVoucher = idShopVoucher;
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

    public String getShippingUnit() {
        return shippingUnit;
    }

    public void setShippingUnit(String shippingUnit) {
        this.shippingUnit = shippingUnit;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}