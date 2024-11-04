package fptu.shopee2.Model.ProductPakage;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private int idCategory;

    @Column(name = "name_category", nullable = false)
    private String nameCategory;

    // Mối quan hệ Many-to-One với chính bảng Category để thiết lập danh mục cha
    @ManyToOne
    @JoinColumn(name = "parent_id") // parent_id là khóa ngoại tham chiếu đến idCategory của bảng cha
    private Category category;

    // Mối quan hệ One-to-Many để lấy tất cả danh mục con của danh mục hiện tại
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Category> categories;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<CategoryAttribute> categoryAttributes;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

}