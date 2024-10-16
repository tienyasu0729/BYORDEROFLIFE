package fptu.shopee.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "shop_identification")
public class ShopIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "form_of_identification", nullable = false)
    private String formOfIdentification;

    @Column(name = "identification_number", nullable = false)
    private String identificationNumber;

    @Column(name = "identification_name", nullable = false)
    private String identificationName;

    @Column(name = "image_identification_front", length = 500)
    private String imageIdentificationFront;

    @Column(name = "image_identification_back", length = 500)
    private String imageIdentificationBack;

    // Getters và Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFormOfIdentification() {
        return formOfIdentification;
    }

    public void setFormOfIdentification(String formOfIdentification) {
        this.formOfIdentification = formOfIdentification;
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