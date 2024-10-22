package fptu.shopee.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "shop_identification")
public class ShopIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "form_of_identification", nullable = false)
    private String idFormOfIdentification;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "identification_name", nullable = false)
    @Pattern(regexp = "^[\\p{L}\\p{Zs}]+$", message = Message.messRegexpIdentificationName)
    private String identificationName;

    @Column(name = "image_identification_front", length = 500)
    private String imageIdentificationFront;

    @Column(name = "image_identification_back", length = 500)
    private String imageIdentificationBack;

    @ManyToOne
    @JoinColumn(name = "form_of_identification", nullable = false)
    private FormOfIdentification formOfIdentification;

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

    public String getFormOfIdentification() {
        return idFormOfIdentification;
    }

    public void setFormOfIdentification(String formOfIdentification) {
        this.idFormOfIdentification = formOfIdentification;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getIdentificationName() {
        return identificationName;
    }

    public void setIdentificationName(String identificationName) {
        this.identificationName = identificationName;
    }

    public String getImageIdentificationFront() {
        return imageIdentificationFront;
    }

    public void setImageIdentificationFront(String imageIdentificationFront) {
        this.imageIdentificationFront = imageIdentificationFront;
    }

    public String getImageIdentificationBack() {
        return imageIdentificationBack;
    }

    public void setImageIdentificationBack(String imageIdentificationBack) {
        this.imageIdentificationBack = imageIdentificationBack;
    }
}