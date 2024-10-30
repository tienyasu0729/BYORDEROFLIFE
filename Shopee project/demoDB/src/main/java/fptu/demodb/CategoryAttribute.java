package fptu.demodb;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category_attribute")
public class CategoryAttribute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category_attribute")
    private int idCategoryAttribute;

    @Column(name = "attribute_name", nullable = false)
    private String attributeName;

    @Column(name = "data_type", nullable = false)
    private String dataType ;

    @OneToMany(mappedBy = "id.categoryAttribute", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CategoryValue> categoryValues;

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