package fptu.shopee.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private int idArea;

    @Column(name = "name_area", nullable = false)
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = "Name area must only contain letters and spaces, no numbers or special characters")
    private String nameArea;

    public int getIdArea() {
        return idArea;
    }

    public void setIdArea(int idArea) {
        this.idArea = idArea;
    }

    public String getNameArea() {
        return nameArea;
    }

    public void setNameArea(String nameArea) {
        this.nameArea = nameArea;
    }
}
