package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;

@Entity
@Table(name = "product_image")
public class ProductImage {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "image_id",columnDefinition = "BIGINT(20)")
    private long image_id;
    @Column(name = "path",columnDefinition = "VARCHAR(250)")
    private String path;
    @Column(name = "alternative",columnDefinition = "VARCHAR(250)")
    private String alternative;
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id",columnDefinition = "BIGINT(20)")
    private Product product;

    public ProductImage() {
    }

    public ProductImage(String path, String alternative, Product product) {
        this.path = path;
        this.alternative = alternative;
        this.product = product;
    }

    public long getImage_id() {
        return image_id;
    }

    public void setImage_id(long image_id) {
        this.image_id = image_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAlternative() {
        return alternative;
    }

    public void setAlternative(String alternative) {
        this.alternative = alternative;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "productImage{" +
                "image_id=" + image_id +
                ", path='" + path + '\'' +
                ", alternative='" + alternative + '\'' +
                ", product=" + product +
                '}';
    }
}
