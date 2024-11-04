package fptu.shopee2.Model.ProductPakage;

import fptu.shopee.Model.Message;
import fptu.shopee.Model.ShopPackage.Shop;
import fptu.shopee.Model.UserPackage.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product_review")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private int idReview;

    @Column(name = "user_comment", length = 1000)
    private String userComment;

    @Column(name = "shop_answer", length = 1000)
    private String shopAnswer;

    @NotNull
    @Min(value = 1, message = Message.messStarReview)
    @Max(value = 5, message = Message.messStarReview)
    @Column(name = "star", nullable = false)
    private int star;

    @ManyToOne
    @JoinColumn(name = "id_classification", nullable = false)
    private Classification classification;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_shop", nullable = false)
    private Shop shop;

    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getUserComment() {
        return userComment;
    }

    public void setUserComment(String userComment) {
        this.userComment = userComment;
    }

    public String getShopAnswer() {
        return shopAnswer;
    }

    public void setShopAnswer(String shopAnswer) {
        this.shopAnswer = shopAnswer;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}