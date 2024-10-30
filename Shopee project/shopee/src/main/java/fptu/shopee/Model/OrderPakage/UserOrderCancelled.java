package fptu.shopee.Model.OrderPakage;

import fptu.shopee.Model.ManyToManyRelationshipTable.ListItemInOrderCancelled;
import fptu.shopee.Model.PaymentMethod;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "user_order_cancelled")
public class UserOrderCancelled {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_cancelled")
    private Long idOrderCancelled;

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

    @OneToMany(mappedBy = "id.userOrderCancelled", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ListItemInOrderCancelled> listItemsInOrderCancelled;

    public Long getIdOrderCancelled() {
        return idOrderCancelled;
    }

    public void setIdOrderCancelled(Long idOrderCancelled) {
        this.idOrderCancelled = idOrderCancelled;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}
