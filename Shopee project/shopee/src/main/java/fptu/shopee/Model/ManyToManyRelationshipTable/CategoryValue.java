package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.CategoryAttribute;
import fptu.shopee.Model.Product;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "category_value")
public class CategoryValue {

    @EmbeddedId
    private CategoryValueId id;

    @NotNull
    @Column(name = "attribute_value", nullable = false)
    private String attributeValue;

    public CategoryValue() {}

    public CategoryValue(CategoryAttribute categoryAttribute, Product product, String attributeValue) {
        this.id = new CategoryValueId(categoryAttribute, product);
        this.attributeValue = attributeValue;
    }

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

    public CategoryAttribute getCategoryAttribute() {
        return id.getCategoryAttribute();
    }

    public Product getProduct() {
        return id.getProduct();
    }
}