package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

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
    @Size(min = 8, max = 100, message = "Mật khẩu phải có độ dài từ 8 đến 100 ký tự.")
    @Pattern(regexp = "^[^\\s]+$", message = "Mật khẩu không được chứa khoảng trắng.")
    private String password;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10,11}", message = "Số điện thoại phải chứa từ 10 đến 11 chữ số.")
    private String phoneNumber;

    @Email(message = "Email không hợp lệ.")
    @Column(name = "email", nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "account_area", nullable = false)
    private Area accountArea;


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
