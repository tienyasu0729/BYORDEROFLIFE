package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "classification")
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_classification")
    private Long idClassification;

    @Column(name = "classification_name", nullable = false)
    private String classificationName;

    public Long getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(Long idClassification) {
        this.idClassification = idClassification;
    }

    public String getClassificationName() {
        return classificationName;
    }

    public void setClassificationName(String classificationName) {
        this.classificationName = classificationName;
    }
}