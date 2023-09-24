package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.enums.ProductStatus;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "product")
//@NamedQueries(
//        @NamedQueries( name = "PRODUCT.findAll", query = "select p from Product p where p.status = 1")
//)
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "product_id",columnDefinition = "BIGINT(20)")
    private long product_id;
    @Column(name = "name",columnDefinition = "VARCHAR(150)")
    private String name;
    @Column(name = "manufacturer_name",columnDefinition = "VARCHAR(100)")
    private String manufacturer;
    @Column(name = "description",columnDefinition = "VARCHAR(250)")
    private String description;
    @Column(name = "unit",columnDefinition = "VARCHAR(25)")
    private String unit;
    @Column(name = "status",columnDefinition = "INT(11)")
    private ProductStatus status;
    @OneToMany(mappedBy = "product",cascade = jakarta.persistence.CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    @OneToMany(mappedBy = "product",cascade = jakarta.persistence.CascadeType.ALL)
    private List<ProductImage> productImageList;
    @OneToMany(mappedBy = "product",cascade = jakarta.persistence.CascadeType.ALL)
    public List<ProductPrice> productPrices;

    public Product() {
    }

    public Product(String name, String manufacturer, String description, String unit, ProductStatus status) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.description = description;
        this.unit = unit;
        this.status = status;
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ProductStatus getStatus() {
        return status;
    }

    public void setStatus(ProductStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Product{" +
                "product_id=" + product_id +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", description='" + description + '\'' +
                ", unit='" + unit + '\'' +
                ", status=" + status +
                ", orderDetails=" + orderDetails +
                ", productImageList=" + productImageList +
                '}';
    }
}
