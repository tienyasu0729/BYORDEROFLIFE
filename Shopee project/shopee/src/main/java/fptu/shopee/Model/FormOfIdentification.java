package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "form_of_identification")
public class FormOfIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private Long idForm;

    @Column(name = "name_form", nullable = false)
    private String nameForm;

    // Getters và Setters
    public Long getIdForm() {
        return idForm;
    }

    public void setIdForm(Long idForm) {
        this.idForm = idForm;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }
}