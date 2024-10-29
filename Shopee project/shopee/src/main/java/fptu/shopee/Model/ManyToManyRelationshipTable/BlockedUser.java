package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.Shop;
import fptu.shopee.Model.User;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "blocked_user")
public class BlockedUser implements Serializable {

    @EmbeddedId
    private BlockedUserId id = new BlockedUserId();

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("shopId")
    @JoinColumn(name = "shop_id")
    private Shop shop;

    public BlockedUser() {}

    public BlockedUser(User user, Shop shop) {
        this.user = user;
        this.shop = shop;
        this.id = new BlockedUserId(user.getIdUser(), shop.getIdShop());
    }

    public BlockedUserId getId() {
        return id;
    }

    public void setId(BlockedUserId id) {
        this.id = id;
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
}