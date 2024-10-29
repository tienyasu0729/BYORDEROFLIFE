package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Classification;
import fptu.shopee.Model.UserOrderCancelled;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderCancelledId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_cancelled")
    private UserOrderCancelled userOrderCancelled;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    // Constructors, Getters, Setters, hashCode, and equals
    public ListItemInOrderCancelledId() {}

    public ListItemInOrderCancelledId(UserOrderCancelled userOrderCancelled, Classification classification) {
        this.userOrderCancelled = userOrderCancelled;
        this.classification = classification;
    }

    public UserOrderCancelled getUserOrderCancelled() {
        return userOrderCancelled;
    }

    public void setUserOrderCancelled(UserOrderCancelled orderCancelled) {
        this.userOrderCancelled = orderCancelled;
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
        if (!(o instanceof ListItemInOrderCancelledId)) return false;
        ListItemInOrderCancelledId that = (ListItemInOrderCancelledId) o;
        return Objects.equals(userOrderCancelled, that.userOrderCancelled) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderCancelled, classification);
    }
}