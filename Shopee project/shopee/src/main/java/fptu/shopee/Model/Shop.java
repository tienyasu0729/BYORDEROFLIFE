package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "shop")
public class Shop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_shop")
    private int idShop;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10,11}", message = Message.messRegexpPhoneNumber)
    private String phoneNumber;

    // có thể chứa tất cả ngôn ngữ trên thế giới nhưng không chứa các kí tự đặc biệt như > < . , ) ( ...
    @Column(name = "shop_name", nullable = false)
    @Pattern(regexp = "^[\\p{L}\\p{Zs}]+$", message = Message.messRegexpShopName)
    private String shopName;

    @Email(message = "Email không hợp lệ.")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 100, message = Message.messSizePassword)
    @Pattern(regexp = "^[^\\s]+$", message = Message.messRegexpPassword)
    private String password;

    @Column(name = "shop_avatar_image", length = 500)
    private String shopAvatarImage;

    @Column(name = "status", nullable = false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status = true;

    @OneToMany(mappedBy = "list_email_to_receive_electronic_invoices", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListEmailToReceiveElectronicInvoices> listEmailToReceiveElectronicInvoices;

    @ManyToOne
    @JoinColumn(name = "main_account")
    private MainAccount mainAccount;

    public int getIdShop() {
        return idShop;
    }

    public void setIdShop(int idShop) {
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
