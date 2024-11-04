package fptu.shopee2.Model.ManyToManyRelationshipTable.EmbeddedID;

import fptu.shopee.Model.ProductPakage.Product;
import fptu.shopee.Model.ProductPakage.CategoryAttribute;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoryValueId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "id_category_attribute")
    private CategoryAttribute categoryAttribute;

    // Constructors, Getters, Setters, hashCode, and equals
    public CategoryValueId() {}

    public CategoryValueId(Product product, CategoryAttribute categoryAttribute) {
        this.product = product;
        this.categoryAttribute = categoryAttribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CategoryAttribute getCategoryAttribute() {
        return categoryAttribute;
    }

    public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryValueId)) return false;
        CategoryValueId that = (CategoryValueId) o;
        return Objects.equals(product, that.product) &&
                Objects.equals(categoryAttribute, that.categoryAttribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, categoryAttribute);
    }
}