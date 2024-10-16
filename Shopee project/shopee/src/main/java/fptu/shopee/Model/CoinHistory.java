package fptu.shopee.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "coin_history")
public class CoinHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_coin_history")
    private Long idCoinHistory;

    @Column(name = "number_coin", nullable = false)
    private Integer numberCoin;

    @Column(name = "notification_subject", nullable = false)
    private String notificationSubject;

    @Column(name = "notification_receipt_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date notificationReceiptDate;

    public Long getIdCoinHistory() {
        return idCoinHistory;
    }

    public void setIdCoinHistory(Long idCoinHistory) {
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
