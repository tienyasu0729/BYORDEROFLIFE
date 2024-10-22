package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "chat_settings")
public class ChatSettings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotNull
    @Column(name = "Receive_messages_from_Shopee_Rewards", nullable = false)
    private Boolean receiveMessagesFromShopeeRewards = false;

    @NotNull
    @Column(name = "Receive_messages_from_Personal_Page", nullable = false)
    private Boolean receiveMessagesFromPersonalPage = false;

    @NotNull
    @Column(name = "Play_sound_notification_for_new_messages", nullable = false)
    private Boolean playSoundNotificationForNewMessages = false;

    @NotNull
    @Column(name = "Push_new_popup_message", nullable = false)
    private Boolean pushNewPopupMessage = false;

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

    public Boolean getReceiveMessagesFromShopeeRewards() {
        return receiveMessagesFromShopeeRewards;
    }

    public void setReceiveMessagesFromShopeeRewards(Boolean receiveMessagesFromShopeeRewards) {
        this.receiveMessagesFromShopeeRewards = receiveMessagesFromShopeeRewards;
    }

    public Boolean getReceiveMessagesFromPersonalPage() {
        return receiveMessagesFromPersonalPage;
    }

    public void setReceiveMessagesFromPersonalPage(Boolean receiveMessagesFromPersonalPage) {
        this.receiveMessagesFromPersonalPage = receiveMessagesFromPersonalPage;
    }

    public Boolean getPlaySoundNotificationForNewMessages() {
        return playSoundNotificationForNewMessages;
    }

    public void setPlaySoundNotificationForNewMessages(Boolean playSoundNotificationForNewMessages) {
        this.playSoundNotificationForNewMessages = playSoundNotificationForNewMessages;
    }

    public Boolean getPushNewPopupMessage() {
        return pushNewPopupMessage;
    }

    public void setPushNewPopupMessage(Boolean pushNewPopupMessage) {
        this.pushNewPopupMessage = pushNewPopupMessage;
    }
}
