package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "payment_settings")
public class PaymentSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotNull(message = "Cài đặt rút tiền tự động không được để trống.")
    @Column(name = "automatic_withdrawal", nullable = false)
    private Boolean automaticWithdrawal = false;

    @Column(name = "PIN_code")
    private String pinCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
