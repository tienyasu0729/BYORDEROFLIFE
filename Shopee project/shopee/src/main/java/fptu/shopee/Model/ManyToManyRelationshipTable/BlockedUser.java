package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.ManyToManyRelationshipTable.EmbeddedID.BlockedUserId;
import fptu.shopee.Model.UserPackage.User;
import fptu.shopee.Model.ShopPackage.Shop;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "blocked_user")
public class BlockedUser {

    @EmbeddedId
    private BlockedUserId id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "block_date_time", nullable = false)
    private Date blockDateTime;

    public BlockedUser() {}

    public BlockedUser(User user, Shop shop, Date blockDateTime) {
        this.id = new BlockedUserId(user, shop);
        this.blockDateTime = blockDateTime;
    }

    public BlockedUserId getId() {
        return id;
    }

    public void setId(BlockedUserId id) {
        this.id = id;
    }

    public Date getBlockDateTime() {
        return blockDateTime;
    }

    public void setBlockDateTime(Date blockDateTime) {
        this.blockDateTime = blockDateTime;
    }

    public User getUser() {
        return id.getUser();
    }

    public Shop getShop() {
        return id.getShop();
    }
}