package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Classification;
import fptu.shopee.Model.Message;
import fptu.shopee.Model.UserOrderPendingShipment;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_item_in_order_pending_shipment")
public class ListItemInOrderPendingShipment {

    @EmbeddedId
    private ListItemInOrderPendingShipmentId id;

    @NotNull
    @Min(value = 1, message = Message.messMinProductQuantity)
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @NotNull
    @Column(name = "product_details_deleted", nullable = false)
    private boolean productDetailsDeleted;

    public ListItemInOrderPendingShipment() {}

    public ListItemInOrderPendingShipment(UserOrderPendingShipment orderPendingShipment, Classification classification, int productQuantity, boolean productDetailsDeleted) {
        this.id = new ListItemInOrderPendingShipmentId(orderPendingShipment, classification);
        this.productQuantity = productQuantity;
        this.productDetailsDeleted = productDetailsDeleted;
    }

    public ListItemInOrderPendingShipmentId getId() {
        return id;
    }

    public void setId(ListItemInOrderPendingShipmentId id) {
        this.id = id;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public boolean isProductDetailsDeleted() {
        return productDetailsDeleted;
    }

    public void setProductDetailsDeleted(boolean productDetailsDeleted) {
        this.productDetailsDeleted = productDetailsDeleted;
    }

    public UserOrderPendingShipment getOrderPendingShipment() {
        return id.getUserOrderPendingShipment();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}
