package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Shop_notification_settings")
public class ShopNotificationSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "order_update_notification", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean orderUpdateNotification = false;

    @NotNull
    @Column(name = "Newsletter_notification", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean newsletterNotification = false;

    @NotNull
    @Column(name = "Product_Update_Notification", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean productUpdateNotification = false;

    @NotNull
    @Column(name = "Personal_Content_Notification", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean personalContentNotification = false;

    @NotNull
    @Column(name = "Chat_Messages_Reminder", nullable = false, columnDefinition = "BOOLEAN DEFAULT false")
    private Boolean chatMessagesReminder = false;

    @OneToOne
    @MapsId // Maps khóa ngoại thành khóa chính
    @JoinColumn(name = "id_shop")
    private Shop shop;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getOrderUpdateNotification() {
        return orderUpdateNotification;
    }

    public void setOrderUpdateNotification(Boolean orderUpdateNotification) {
        this.orderUpdateNotification = orderUpdateNotification;
    }

    public Boolean getNewsletterNotification() {
        return newsletterNotification;
    }

    public void setNewsletterNotification(Boolean newsletterNotification) {
        this.newsletterNotification = newsletterNotification;
    }

    public Boolean getProductUpdateNotification() {
        return productUpdateNotification;
    }

    public void setProductUpdateNotification(Boolean productUpdateNotification) {
        this.productUpdateNotification = productUpdateNotification;
    }

    public Boolean getPersonalContentNotification() {
        return personalContentNotification;
    }

    public void setPersonalContentNotification(Boolean personalContentNotification) {
        this.personalContentNotification = personalContentNotification;
    }

    public Boolean getChatMessagesReminder() {
        return chatMessagesReminder;
    }

    public void setChatMessagesReminder(Boolean chatMessagesReminder) {
        this.chatMessagesReminder = chatMessagesReminder;
    }
}