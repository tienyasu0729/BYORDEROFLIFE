package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    private Long idShop;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "shop_name", nullable = false)
    private String shopName;

    @Email(message = "Email không hợp lệ.")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "shop_avatar_image", length = 500)
    private String shopAvatarImage;

    @Column(name = "status", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;

    public Long getIdShop() {
        return idShop;
    }

    public void setIdShop(Long idShop) {
        this.idShop = idShop;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShopAvatarImage() {
        return shopAvatarImage;
    }

    public void setShopAvatarImage(String shopAvatarImage) {
        this.shopAvatarImage = shopAvatarImage;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
}
