package fptu.shopee.Model.UserPackage;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "user_notifications")
public class UserNotifications {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_notifications")
    private int id;

    @NotNull
    @Column(name = "email_notification_switch", nullable = false)
    private boolean emailNotificationSwitch = false;

    @NotNull
    @Column(name = "order_update_via_email", nullable = false)
    private boolean orderUpdateViaEmail = false;

    @NotNull
    @Column(name = "promotional_email_notification", nullable = false)
    private boolean promotionalEmailNotification = false;

    @NotNull
    @Column(name = "survey_notification_via_email", nullable = false)
    private boolean surveyNotificationViaEmail = false;

    @NotNull
    @Column(name = "SMS_notification_switch", nullable = false)
    private boolean smsNotificationSwitch = false;

    @NotNull
    @Column(name = "promotional_SMS_notification", nullable = false)
    private boolean promotionalSmsNotification = false;

    @OneToOne
    @MapsId // Maps khóa ngoại thành khóa chính
    @JoinColumn(name = "id_user")
    private User user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isEmailNotificationSwitch() {
        return emailNotificationSwitch;
    }

    public void setEmailNotificationSwitch(boolean emailNotificationSwitch) {
        this.emailNotificationSwitch = emailNotificationSwitch;
    }

    public boolean isOrderUpdateViaEmail() {
        return orderUpdateViaEmail;
    }

    public void setOrderUpdateViaEmail(boolean orderUpdateViaEmail) {
        this.orderUpdateViaEmail = orderUpdateViaEmail;
    }

    public boolean isPromotionalEmailNotification() {
        return promotionalEmailNotification;
    }

    public void setPromotionalEmailNotification(boolean promotionalEmailNotification) {
        this.promotionalEmailNotification = promotionalEmailNotification;
    }

    public boolean isSurveyNotificationViaEmail() {
        return surveyNotificationViaEmail;
    }

    public void setSurveyNotificationViaEmail(boolean surveyNotificationViaEmail) {
        this.surveyNotificationViaEmail = surveyNotificationViaEmail;
    }

    public boolean isSmsNotificationSwitch() {
        return smsNotificationSwitch;
    }

    public void setSmsNotificationSwitch(boolean smsNotificationSwitch) {
        this.smsNotificationSwitch = smsNotificationSwitch;
    }

    public boolean isPromotionalSmsNotification() {
        return promotionalSmsNotification;
    }

    public void setPromotionalSmsNotification(boolean promotionalSmsNotification) {
        this.promotionalSmsNotification = promotionalSmsNotification;
    }
}
