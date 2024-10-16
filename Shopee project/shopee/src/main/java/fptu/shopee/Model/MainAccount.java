package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "main_account")
public class MainAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_main_account")
    private Long idMainAccount;

    @Column(name = "account_area", nullable = false)
    @Size(min = 3, max = 100, message = "Tên khu vực phải từ 3 đến 100 ký tự.")
    private String accountArea;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Email(message = "Email không hợp lệ.")
    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "business_ID", nullable = false)
    @Size(min = 3, max = 50, message = "Business ID phải từ 3 đến 50 ký tự.")
    private String businessID;

    @Column(name = "password", nullable = false)
    @Size(min = 6, message = "Mật khẩu phải có ít nhất 6 ký tự.")
    private String password;

    public Long getIdMainAccount() {
        return idMainAccount;
    }

    public void setIdMainAccount(Long idMainAccount) {
        this.idMainAccount = idMainAccount;
    }

    public String getAccountArea() {
        return accountArea;
    }

    public void setAccountArea(String accountArea) {
        this.accountArea = accountArea;
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
