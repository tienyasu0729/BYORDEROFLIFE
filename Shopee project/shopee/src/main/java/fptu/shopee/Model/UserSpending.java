package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_spending")
public class UserSpending {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_number", nullable = false)
    private int orderNumber;

    @Column(name = "spending", length = 500)
    private String spending;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getSpending() {
        return spending;
    }

    public void setSpending(String spending) {
        this.spending = spending;
    }
}
