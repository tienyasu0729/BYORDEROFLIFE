package fptu.shopee.Model.ProductPakage;

import fptu.shopee.Model.ManyToManyRelationshipTable.CategoryValue;
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

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }
}