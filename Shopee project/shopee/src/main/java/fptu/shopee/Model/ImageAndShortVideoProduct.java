package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "image_and_short_video_product")
public class ImageAndShortVideoProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "video", length = 500)
    private String video;

    @NotNull
    @Column(name = "image1", length = 500, nullable = false)
    private String image1;

    @NotNull
    @Column(name = "image2", length = 500, nullable = false)
    private String image2;

    @NotNull
    @Column(name = "image3", length = 500, nullable = false)
    private String image3;

    @Column(name = "image4", length = 500)
    private String image4;

    @Column(name = "image5", length = 500)
    private String image5;

    @Column(name = "image6", length = 500)
    private String image6;

    @Column(name = "image7", length = 500)
    private String image7;

    @Column(name = "image8", length = 500)
    private String image8;

    @Column(name = "image9", length = 500)
    private String image9;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_product")
    private Product product;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getImage5() {
        return image5;
    }

    public void setImage5(String image5) {
        this.image5 = image5;
    }

    public String getImage6() {
        return image6;
    }

    public void setImage6(String image6) {
        this.image6 = image6;
    }

    public String getImage7() {
        return image7;
    }

    public void setImage7(String image7) {
        this.image7 = image7;
    }

    public String getImage8() {
        return image8;
    }

    public void setImage8(String image8) {
        this.image8 = image8;
    }

    public String getImage9() {
        return image9;
    }

    public void setImage9(String image9) {
        this.image9 = image9;
    }
}
