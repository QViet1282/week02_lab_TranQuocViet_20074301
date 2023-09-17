package vn.edu.iuh.fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import vn.edu.iuh.fit.enums.ProductStatus;

import java.util.List;

@Entity
public class Product {
    @Id
    private long product_id;
    private String name;
    private String manufacturer;
    private String description;
    private String unit;
    private ProductStatus status;
    @OneToMany
    private List<OrderDetails> orderDetails;
    @OneToMany
    private List<productImage> productImageList;

    public Product() {
    }

    public Product(long product_id, String name, String manufacturer, String description, String unit, ProductStatus status) {
        this.product_id = product_id;
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
