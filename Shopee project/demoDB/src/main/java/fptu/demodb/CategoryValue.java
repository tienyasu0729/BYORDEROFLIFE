package fptu.demodb;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "category_value")
public class CategoryValue {

    @EmbeddedId
    private CategoryValueId id;

    @Column(name = "attribute_value", nullable = false)
    private String attributeValue;

    // Constructors
    public CategoryValue() {}

    public CategoryValue(Product product, CategoryAttribute categoryAttribute, String attributeValue) {
        this.id = new CategoryValueId(product, categoryAttribute);
        this.attributeValue = attributeValue;
    }

    // Getters and Setters
    public CategoryValueId getId() {
        return id;
    }

    public void setId(CategoryValueId id) {
        this.id = id;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    public Product getProduct() {
        return id.getProduct();
    }

    public CategoryAttribute getCategoryAttribute() {
        return id.getCategoryAttribute();
    }
}