package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Classification;
import fptu.shopee.Model.UserOrderInTransit;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderInTransitId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_in_transit")
    private UserOrderInTransit userOrderInTransit;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    // Constructors, Getters, Setters, hashCode, and equals
    public ListItemInOrderInTransitId() {}

    public ListItemInOrderInTransitId(UserOrderInTransit userOrderInTransit, Classification classification) {
        this.userOrderInTransit = userOrderInTransit;
        this.classification = classification;
    }

    public UserOrderInTransit getUserOrderInTransit() {
        return userOrderInTransit;
    }

    public void setUserOrderInTransit(UserOrderInTransit orderInTransit) {
        this.userOrderInTransit = orderInTransit;
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
        if (!(o instanceof ListItemInOrderInTransitId)) return false;
        ListItemInOrderInTransitId that = (ListItemInOrderInTransitId) o;
        return Objects.equals(userOrderInTransit, that.userOrderInTransit) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderInTransit, classification);
    }
}