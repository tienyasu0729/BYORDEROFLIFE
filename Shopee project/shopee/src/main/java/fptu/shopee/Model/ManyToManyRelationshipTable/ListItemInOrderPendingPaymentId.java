package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Classification;
import fptu.shopee.Model.UserOrderPendingPayment;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderPendingPaymentId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_pending_payment")
    private UserOrderPendingPayment userOrderPendingPayment;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    // Constructors, Getters, Setters, hashCode, and equals
    public ListItemInOrderPendingPaymentId() {}

    public ListItemInOrderPendingPaymentId(UserOrderPendingPayment userOrderPendingPayment, Classification classification) {
        this.userOrderPendingPayment = userOrderPendingPayment;
        this.classification = classification;
    }

    public UserOrderPendingPayment getUserOrderPendingPayment() {
        return userOrderPendingPayment;
    }

    public void setUserOrderPendingPayment(UserOrderPendingPayment userOrderPendingPayment) {
        this.userOrderPendingPayment = userOrderPendingPayment;
    }

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification classification) {
        this.classification = classification;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListItemInOrderPendingPaymentId)) return false;
        ListItemInOrderPendingPaymentId that = (ListItemInOrderPendingPaymentId) o;
        return Objects.equals(userOrderPendingPayment, that.userOrderPendingPayment) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderPendingPayment, classification);
    }
}
