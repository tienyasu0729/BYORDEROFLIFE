package fptu.shopee2.Model.ShopPackage;

import fptu.shopee.Model.Message;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;

import java.util.Set;

@Entity
@Table(name = "area")
public class Area {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_area")
    private int idArea;

    @Column(name = "name_area", nullable = false)
    @Pattern(regexp = "^[\\p{L}\\s]+$", message = Message.messRegexpNameArea)
    private String nameArea;

    @OneToMany(mappedBy = "area", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MainAccount> mainAccounts;

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
