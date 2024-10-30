package fptu.shopee.Model.UserPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "coin_history")
public class CoinHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coin_history")
    private int idCoinHistory;

    @NotNull
    @Column(name = "number_coin", nullable = false)
    private int numberCoin;

    @NotNull
    @Column(name = "notification_subject", nullable = false)
    private String notificationSubject;

    @NotNull
    @Column(name = "notification_receipt_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date notificationReceiptDate;

    @PrePersist
    protected void onCreate() {
        notificationReceiptDate = new Date(); // Gán ngày hiện tại khi thực thể được lưu lần đầu
    }
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public int getIdCoinHistory() {
        return idCoinHistory;
    }

    public void setIdCoinHistory(int idCoinHistory) {
        this.idCoinHistory = idCoinHistory;
    }

    public Integer getNumberCoin() {
        return numberCoin;
    }

    public void setNumberCoin(Integer numberCoin) {
        this.numberCoin = numberCoin;
    }

    public String getNotificationSubject() {
        return notificationSubject;
    }

    public void setNotificationSubject(String notificationSubject) {
        this.notificationSubject = notificationSubject;
    }

    public Date getNotificationReceiptDate() {
        return notificationReceiptDate;
    }

    public void setNotificationReceiptDate(Date notificationReceiptDate) {
        this.notificationReceiptDate = notificationReceiptDate;
    }
}
