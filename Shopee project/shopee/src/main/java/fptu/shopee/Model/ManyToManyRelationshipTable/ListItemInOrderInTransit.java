package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ProductPakage.Classification;
import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.ListItemInOrderInTransitId;
import fptu.shopee.Model.OrderPakage.UserOrderInTransit;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "list_item_in_order_in_transit")
public class ListItemInOrderInTransit {

    @EmbeddedId
    private ListItemInOrderInTransitId id;

    @Column(name = "product_quantity", nullable = false)
    private int productQuantity;

    // Constructors
    public ListItemInOrderInTransit() {}

    public ListItemInOrderInTransit(UserOrderInTransit orderInTransit, Classification classification, int productQuantity) {
        this.id = new ListItemInOrderInTransitId(orderInTransit, classification);
        this.productQuantity = productQuantity;
    }

    // Getters and Setters
    public ListItemInOrderInTransitId getId() {
        return id;
    }

    public void setId(ListItemInOrderInTransitId id) {
        this.id = id;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public UserOrderInTransit getOrderInTransit() {
        return id.getUserOrderInTransit();
    }

    public Classification getClassification() {
        return id.getClassification();
    }
}