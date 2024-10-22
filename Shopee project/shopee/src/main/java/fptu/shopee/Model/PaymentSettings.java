package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "payment_settings")
public class PaymentSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "automatic_withdrawal", nullable = false)
    private Boolean automaticWithdrawal = false;

    @Column(name = "PIN_code")
    @Pattern(regexp = "\\d{6}", message = Message.messRegexpPinCode)
    private String pinCode;

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

    public Boolean getAutomaticWithdrawal() {
        return automaticWithdrawal;
    }

    public void setAutomaticWithdrawal(Boolean automaticWithdrawal) {
        this.automaticWithdrawal = automaticWithdrawal;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }
}
