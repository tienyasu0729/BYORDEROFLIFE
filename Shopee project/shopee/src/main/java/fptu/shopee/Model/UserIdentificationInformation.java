package fptu.shopee.Model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_identification_information")
public class UserIdentificationInformation {

    @Id
    @Column(name = "cccd", nullable = false, length = 12)
    private String cccd;

    @Column(name = "image_selfie", length = 500)
    private String imageSelfie;

    @Column(name = "image_cccd_front", length = 500)
    private String imageCccdFront;

    @Column(name = "image_cccd_back", length = 500)
    private String imageCccdBack;

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
