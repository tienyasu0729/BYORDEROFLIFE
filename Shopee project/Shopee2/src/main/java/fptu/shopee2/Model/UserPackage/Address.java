package fptu.shopee2.Model.UserPackage;

import fptu.shopee.Model.Message;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private int idAddress;

    @Column(name = "name_address")
    private String nameAddress;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10,11}", message = Message.messRegexpPhoneNumber)
    private String phoneNumber;

    @NotNull
    @Column(name = "apartment_number", nullable = false)
    private String apartmentNumber;

    @NotNull
    @Column(name = "street_name", nullable = false)
    private String streetName;

    @NotNull
    @Column(name = "District", nullable = false)
    private String district;

    @NotNull
    @Column(name = "Ward", nullable = false)
    private String ward;

    @NotNull
    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "is_default", nullable = false)
    private boolean isDefault;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public int getIdAddress() {
        return idAddress;
    }

    public void setIdAddress(int idAddress) {
        this.idAddress = idAddress;
    }

    public String getNameAddress() {
        return nameAddress;
    }

    public void setNameAddress(String nameAddress) {
        this.nameAddress = nameAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean isDefault) {
        this.isDefault = isDefault;
    }
}