package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "phone_number", nullable = false)
    @Pattern(regexp = "\\d{10,11}", message = Message.messRegexpPhoneNumber)
    private String phoneNumber;

    @NotNull
    @Column(name = "password", nullable = false)
    @Size(min = 8, max = 100, message = Message.messSizePassword)
    @Pattern(regexp = "^[^\\s]+$", message = Message.messRegexpPassword)
    private String password;

    @NotNull
    @Column(name = "account_name", nullable = false)
    private String accountName;

    @Column(name = "real_name")
    private String realName;

    @Email(message = Message.messEmail)
    @Column(name = "email")
    private String email;

    @NotNull
    @Column(name = "sex", nullable = false)
    private String sex;

    @NotNull
    @Column(name = "date_of_birth", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;

    @Column(name = "avatar_image")
    private String avatarImage;

    @Column(name = "joining_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date joiningDate;

    @PrePersist
    protected void onCreate() {
        joiningDate = new Date(); // Gán ngày hiện tại khi thực thể được lưu lần đầu
    }

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Address> addresses;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CoinHistory> coinHistories;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserCoin userCoin;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserIdentificationInformation userIdentificationInformation;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserSpending userSpending;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private UserNotifications userNotifications;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ProductReview> productReviews;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAvatarImage() {
        return avatarImage;
    }

    public void setAvatarImage(String avatarImage) {
        this.avatarImage = avatarImage;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }
}
