package fptu.shopee2.Model.UserPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_spending")
public class UserSpending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_spending")
    private int id;

    @NotNull
    @Column(name = "order_number", nullable = false, columnDefinition = "int default 0")
    private int orderNumber = 0;

    @NotNull
    @Column(name = "spending", nullable = false, columnDefinition = "int default 0")
    private int spending = 0;

    @OneToOne
    @MapsId // Maps khóa ngoại thành khóa chính
    @JoinColumn(name = "id_user")
    private User user;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getSpending() {
        return spending;
    }

    public void setSpending(int spending) {
        this.spending = spending;
    }
}
