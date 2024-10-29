package fptu.shopee.Model.ManyToManyRelationshipTable;

import fptu.shopee.Model.CategoryAttribute;
import fptu.shopee.Model.Product;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CategoryValueId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_category_attribute")
    private CategoryAttribute categoryAttribute;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

    // Constructors, Getters, Setters, hashCode, and equals
    public CategoryValueId() {}

    public CategoryValueId(CategoryAttribute categoryAttribute, Product product) {
        this.categoryAttribute = categoryAttribute;
        this.product = product;
    }

    public CategoryAttribute getCategoryAttribute() {
        return categoryAttribute;
    }

    public void setCategoryAttribute(CategoryAttribute categoryAttribute) {
        this.categoryAttribute = categoryAttribute;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryValueId)) return false;
        CategoryValueId that = (CategoryValueId) o;
        return Objects.equals(categoryAttribute, that.categoryAttribute) &&
                Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryAttribute, product);
    }
}
