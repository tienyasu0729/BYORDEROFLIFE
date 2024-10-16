package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "payment_method")
public class PaymentMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment_method")
    private int idPaymentMethod;

    @Column(name = "payment_method_name", nullable = false)
    private String paymentMethodName;

    public int getIdPaymentMethod() {
        return idPaymentMethod;
    }

    public void setIdPaymentMethod(int idPaymentMethod) {
        this.idPaymentMethod = idPaymentMethod;
    }

    public String getPaymentMethodName() {
        return paymentMethodName;
    }

    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodName = paymentMethodName;
    }
}
