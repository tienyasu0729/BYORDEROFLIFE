package fptu.shopee.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "category_attribute")
public class CategoryAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category_attribute")
    private int idCategoryAttribute;

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    public int getIdCategoryAttribute() {
        return idCategoryAttribute;
    }

    public void setIdCategoryAttribute(int idCategoryAttribute) {
        this.idCategoryAttribute = idCategoryAttribute;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }
}