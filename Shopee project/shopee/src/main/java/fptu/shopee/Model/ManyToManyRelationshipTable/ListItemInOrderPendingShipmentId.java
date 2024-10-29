package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Classification;
import fptu.shopee.Model.UserOrderPendingShipment;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ListItemInOrderPendingShipmentId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_order_pending_shipment")
    private UserOrderPendingShipment userOrderPendingShipment;

    @ManyToOne
    @JoinColumn(name = "id_classification")
    private Classification classification;

    public ListItemInOrderPendingShipmentId() {}

    public ListItemInOrderPendingShipmentId(UserOrderPendingShipment userOrderPendingShipment, Classification classification) {
        this.userOrderPendingShipment = userOrderPendingShipment;
        this.classification = classification;
    }

    public UserOrderPendingShipment getUserOrderPendingShipment() {
        return userOrderPendingShipment;
    }

    public void setUserOrderPendingShipment(UserOrderPendingShipment orderPendingShipment) {
        this.userOrderPendingShipment = orderPendingShipment;
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
        if (!(o instanceof ListItemInOrderPendingShipmentId)) return false;
        ListItemInOrderPendingShipmentId that = (ListItemInOrderPendingShipmentId) o;
        return Objects.equals(userOrderPendingShipment, that.userOrderPendingShipment) &&
                Objects.equals(classification, that.classification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userOrderPendingShipment, classification);
    }
}