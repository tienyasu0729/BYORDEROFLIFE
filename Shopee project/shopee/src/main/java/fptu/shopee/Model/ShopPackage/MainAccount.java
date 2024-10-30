package fptu.shopee.Model.ShopPackage;

import fptu.shopee.Model.Message;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Set;

@Entity
@Table(name = "main_account")
public class MainAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_main_account")
    private int idMainAccount;

    @Column(name = "business_ID", nullable = false)
    private String businessID;

    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 100, message = Message.messSizePassword)
    @Pattern(regexp = "^[^\\s]+$", message = Message.messRegexpPassword)
    private String password;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10,11}", message = Message.messRegexpPhoneNumber)
    private String phoneNumber;

    @Email(message = Message.messEmail)
    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "account_area", nullable = false)
    private Area area;

    @OneToMany(mappedBy = "mainAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Shop> shops;

    public int getIdMainAccount() {
        return idMainAccount;
    }

    public void setIdMainAccount(int idMainAccount) {
        this.idMainAccount = idMainAccount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBusinessID() {
        return businessID;
    }

    public void setBusinessID(String businessID) {
        this.businessID = businessID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
