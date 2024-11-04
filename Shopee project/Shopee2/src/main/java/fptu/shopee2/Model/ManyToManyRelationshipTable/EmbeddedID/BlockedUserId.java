package fptu.shopee2.Model.ManyToManyRelationshipTable.EmbeddedID;

import fptu.shopee.Model.UserPackage.User;
import fptu.shopee.Model.ShopPackage.Shop;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BlockedUserId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_shop")
    private Shop shop;

    // Constructors, Getters, Setters, hashCode, and equals
    public BlockedUserId() {}

    public BlockedUserId(User user, Shop shop) {
        this.user = user;
        this.shop = shop;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BlockedUserId)) return false;
        BlockedUserId that = (BlockedUserId) o;
        return Objects.equals(user, that.user) && Objects.equals(shop, that.shop);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, shop);
    }
}
