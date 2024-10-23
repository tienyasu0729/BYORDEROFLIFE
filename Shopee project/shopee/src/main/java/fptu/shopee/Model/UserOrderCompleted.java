package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "user_order_completed")
public class UserOrderCompleted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_completed")
    private Long idOrderCompleted;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_datetime", nullable = false)
    private Date orderDatetime;

    @PrePersist
    protected void onCreate() {
        orderDatetime = new Date();
    }

    @ManyToOne
    @JoinColumn(name = "id_payment_method")
    private PaymentMethod paymentMethod;

    public Long getIdOrderCompleted() {
        return idOrderCompleted;
    }

    public void setIdOrderCompleted(Long idOrderCompleted) {
        this.idOrderCompleted = idOrderCompleted;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}