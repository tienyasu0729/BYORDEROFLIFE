package fptu.shopee2.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ListItemInOrderReturnedId;
import fptu.shopee.Model.Message;
import fptu.shopee.Model.OrderPakage.UserOrderReturned;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_item_in_order_returned")
public class ListItemInOrderReturned {

    @EmbeddedId
    private ListItemInOrderReturnedId id;

    @NotNull
    @Min(value = 1, message = Message.messMinProductQuantity)
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    @NotNull
    @Column(name = "product_details_deleted", nullable = false)
    private boolean productDetailsDeleted;

    public ListItemInOrderReturned() {}

    public ListItemInOrderReturned(UserOrderReturned orderReturned, Classification classification, int productQuantity, boolean productDetailsDeleted) {
        this.id = new ListItemInOrderReturnedId(orderReturned, classification);
        this.productQuantity = productQuantity;
        this.productDetailsDeleted = productDetailsDeleted;
    }

    public ListItemInOrderReturnedId getId() {
        return id;
    }

    public void setId(ListItemInOrderReturnedId id) {
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

    public UserOrderReturned getOrderReturned() {
        return id.getUserOrderReturned();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}
