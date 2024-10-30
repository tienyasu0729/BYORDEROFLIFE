package fptu.shopee.Model.UserPackage;


import fptu.shopee.Model.Message;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "user_identification_information")
public class UserIdentificationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_identification_information")
    private int id;

    @NotNull
    @Column(name = "cccd", nullable = false, length = 12)
    @Pattern(regexp = "\\d{12}", message = Message.messRegexpCCCD)
    @Size(min = 12, max = 12, message = Message.messSizeCCCD)
    private String cccd;

    @NotNull
    @Column(name = "image_selfie", nullable = false, length = 500)
    private String imageSelfie;

    @NotNull
    @Column(name = "image_cccd_front", nullable = false, length = 500)
    private String imageCccdFront;

    @NotNull
    @Column(name = "image_cccd_back", nullable = false, length = 500)
    private String imageCccdBack;

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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    public String getImageSelfie() {
        return imageSelfie;
    }

    public void setImageSelfie(String imageSelfie) {
        this.imageSelfie = imageSelfie;
    }

    public String getImageCccdFront() {
        return imageCccdFront;
    }

    public void setImageCccdFront(String imageCccdFront) {
        this.imageCccdFront = imageCccdFront;
    }

    public String getImageCccdBack() {
        return imageCccdBack;
    }

    public void setImageCccdBack(String imageCccdBack) {
        this.imageCccdBack = imageCccdBack;
    }
}
