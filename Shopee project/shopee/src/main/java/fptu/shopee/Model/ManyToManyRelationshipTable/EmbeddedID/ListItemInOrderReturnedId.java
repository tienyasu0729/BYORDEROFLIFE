package fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.OrderPakage.UserOrderReturned;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderReturnedId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_returned")
    private UserOrderReturned userOrderReturned;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    // Constructors, Getters, Setters, hashCode, and equals
    public ListItemInOrderReturnedId() {}

    public ListItemInOrderReturnedId(UserOrderReturned userOrderReturned, Classification classification) {
        this.userOrderReturned = userOrderReturned;
        this.classification = classification;
    }

    public UserOrderReturned getUserOrderReturned() {
        return userOrderReturned;
    }

    public void setUserOrderReturned(UserOrderReturned orderReturned) {
        this.userOrderReturned = orderReturned;
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
        if (!(o instanceof ListItemInOrderReturnedId)) return false;
        ListItemInOrderReturnedId that = (ListItemInOrderReturnedId) o;
        return Objects.equals(userOrderReturned, that.userOrderReturned) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderReturned, classification);
    }
}