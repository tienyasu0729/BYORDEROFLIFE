package fptu.shopee.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_order_pending_payment")
public class UserOrderPendingPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order_pending_payment")
    private Long idOrderPendingPayment;

    @Column(name = "note_to_seller", length = 500)
    private String noteToSeller;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_datetime", nullable = false)
    private Date orderDatetime;

    public Long getIdOrderPendingPayment() {
        return idOrderPendingPayment;
    }

    public void setIdOrderPendingPayment(Long idOrderPendingPayment) {
        this.idOrderPendingPayment = idOrderPendingPayment;
    }

    public String getNoteToSeller() {
        return noteToSeller;
    }

    public void setNoteToSeller(String noteToSeller) {
        this.noteToSeller = noteToSeller;
    }

    public Date getOrderDatetime() {
        return orderDatetime;
    }

    public void setOrderDatetime(Date orderDatetime) {
        this.orderDatetime = orderDatetime;
    }
}