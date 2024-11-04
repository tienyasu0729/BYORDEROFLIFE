package fptu.shopee2.Model.ShopPackage;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "form_of_identification")
public class FormOfIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form")
    private int idForm;

    @Column(name = "name_form", nullable = false)
    private String nameForm;

    @OneToMany(mappedBy = "formOfIdentification", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<ShopIdentification> shopIdentifications;

    public int getIdForm() {
        return idForm;
    }

    public void setIdForm(int idForm) {
        this.idForm = idForm;
    }

    public String getNameForm() {
        return nameForm;
    }

    public void setNameForm(String nameForm) {
        this.nameForm = nameForm;
    }
}