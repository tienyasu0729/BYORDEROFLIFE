package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ListItemInOrderPendingPaymentId;
import fptu.shopee.Model.Message;
import fptu.shopee.Model.OrderPakage.UserOrderPendingPayment;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "list_item_in_order_pending_payment")
public class ListItemInOrderPendingPayment {

    @EmbeddedId
    private ListItemInOrderPendingPaymentId id;

    @NotNull
    @Min(value = 1, message = Message.messMinProductQuantity)
    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    public ListItemInOrderPendingPayment() {}

    public ListItemInOrderPendingPayment(UserOrderPendingPayment orderPendingPayment, Classification classification, int productQuantity) {
        this.id = new ListItemInOrderPendingPaymentId(orderPendingPayment, classification);
        this.productQuantity = productQuantity;
    }

    public ListItemInOrderPendingPaymentId getId() {
        return id;
    }

    public void setId(ListItemInOrderPendingPaymentId id) {
        this.id = id;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public UserOrderPendingPayment getOrderPendingPayment() {
        return id.getUserOrderPendingPayment();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}
