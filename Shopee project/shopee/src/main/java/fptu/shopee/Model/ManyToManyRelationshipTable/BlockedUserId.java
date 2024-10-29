package fptu.shopee.Model.ManyToManyRelationshipTable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BlockedUserId implements Serializable {

    @Column(name = "user_id")
    private int userId;

    @Column(name = "shop_id")
    private int shopId;

    public BlockedUserId() {}

    public BlockedUserId(int userId, int shopId) {
        this.userId = userId;
        this.shopId = shopId;
    }

    // Getters, setters, equals, and hashCode

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlockedUserId that = (BlockedUserId) o;
        return userId == that.userId && shopId == that.shopId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, shopId);
    }
}
