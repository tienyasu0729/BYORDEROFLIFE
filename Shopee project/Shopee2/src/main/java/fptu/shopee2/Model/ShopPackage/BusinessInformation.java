package fptu.shopee2.Model.ShopPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "business_information")
public class BusinessInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "business_type", nullable = false)
    private String businessType;

    @NotNull
    @Column(name = "address_to_take_product", nullable = false)
    private String addressToTakeProduct;

    @NotNull
    @Column(name = "registered_business_address", nullable = false)
    private String registeredBusinessAddress;

    @NotNull
    @Column(name = "tax_identification_number", nullable = false)
    private String taxIdentificationNumber;

    @OneToOne
    @MapsId // Maps khóa ngoại thành khóa chính
    @JoinColumn(name = "id_shop")
    private Shop shop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType;
    }

    public String getAddressToTakeProduct() {
        return addressToTakeProduct;
    }

    public void setAddressToTakeProduct(String addressToTakeProduct) {
        this.addressToTakeProduct = addressToTakeProduct;
    }

    public String getRegisteredBusinessAddress() {
        return registeredBusinessAddress;
    }

    public void setRegisteredBusinessAddress(String registeredBusinessAddress) {
        this.registeredBusinessAddress = registeredBusinessAddress;
    }

    public String getTaxIdentificationNumber() {
        return taxIdentificationNumber;
    }

    public void setTaxIdentificationNumber(String taxIdentificationNumber) {
        this.taxIdentificationNumber = taxIdentificationNumber;
    }
}