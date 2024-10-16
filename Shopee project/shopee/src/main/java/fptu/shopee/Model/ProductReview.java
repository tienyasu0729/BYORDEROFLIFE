package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "product_review")
public class ProductReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_review")
    private Long idReview;

    @Column(name = "user_comment", nullable = false, length = 1000)
    private String userComment;

    @Column(name = "shop_answer", length = 1000)
    private String shopAnswer;

    @Column(name = "star", nullable = false)
    private Integer star;

    public Long getIdReview() {
        return idReview;
    }

    public void setIdReview(Long idReview) {
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