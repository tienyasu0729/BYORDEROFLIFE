package fptu.shopee2.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ListItemInOrderCompletedId;
import fptu.shopee.Model.Message;
import fptu.shopee.Model.OrderPakage.UserOrderCompleted;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_item_in_order_completed")
public class ListItemInOrderCompleted {

    @EmbeddedId
    private ListItemInOrderCompletedId id;

    @NotNull
    @Min(value = 1, message = Message.messMinProductQuantity)
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @NotNull
    @Column(name = "product_details_deleted", nullable = false)
    private boolean productDetailsDeleted;

    public ListItemInOrderCompleted() {}

    public ListItemInOrderCompleted(UserOrderCompleted orderCompleted, Classification classification, int productQuantity, boolean productDetailsDeleted) {
        this.id = new ListItemInOrderCompletedId(orderCompleted, classification);
        this.productQuantity = productQuantity;
        this.productDetailsDeleted = productDetailsDeleted;
    }

    // Getters and Setters
    public ListItemInOrderCompletedId getId() {
        return id;
    }

    public void setId(ListItemInOrderCompletedId id) {
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

    public UserOrderCompleted getOrderCompleted() {
        return id.getUserOrderCompleted();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}
