package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ListItemInOrderCancelledId;
import fptu.shopee.Model.OrderPakage.UserOrderCancelled;

import jakarta.persistence.*;

@Entity
@Table(name = "list_item_in_order_cancelled")
public class ListItemInOrderCancelled {

    @EmbeddedId
    private ListItemInOrderCancelledId id;

    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @Column(name = "product_details_deleted", nullable = false)
    private String productDetailsDeleted;

    // Constructors
    public ListItemInOrderCancelled() {}

    public ListItemInOrderCancelled(UserOrderCancelled orderCancelled, Classification classification, int productQuantity, String productDetailsDeleted) {
        this.id = new ListItemInOrderCancelledId(orderCancelled, classification);
        this.productQuantity = productQuantity;
        this.productDetailsDeleted = productDetailsDeleted;
    }

    // Getters and Setters
    public ListItemInOrderCancelledId getId() {
        return id;
    }

    public void setId(ListItemInOrderCancelledId id) {
        this.id = id;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String isProductDetailsDeleted() {
        return productDetailsDeleted;
    }

    public void setProductDetailsDeleted(String productDetailsDeleted) {
        this.productDetailsDeleted = productDetailsDeleted;
    }

    public UserOrderCancelled getOrderCancelled() {
        return id.getUserOrderCancelled();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}