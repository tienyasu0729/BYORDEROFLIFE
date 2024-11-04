package fptu.shopee2.Model.ManyToManyRelationshipTable.EmbeddedID;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.OrderPakage.UserOrderCompleted;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderCompletedId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_completed")
    private UserOrderCompleted userOrderCompleted;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    public ListItemInOrderCompletedId() {}

    public ListItemInOrderCompletedId(UserOrderCompleted userOrderCompleted, Classification classification) {
        this.userOrderCompleted = userOrderCompleted;
        this.classification = classification;
    }

    public UserOrderCompleted getUserOrderCompleted() {
        return userOrderCompleted;
    }

    public void setUserOrderCompleted(UserOrderCompleted orderCompleted) {
        this.userOrderCompleted = orderCompleted;
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
        if (!(o instanceof ListItemInOrderCompletedId)) return false;
        ListItemInOrderCompletedId that = (ListItemInOrderCompletedId) o;
        return Objects.equals(userOrderCompleted, that.userOrderCompleted) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderCompleted, classification);
    }
}
