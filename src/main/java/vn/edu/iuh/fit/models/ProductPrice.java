package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "product_price")
public class ProductPrice {
    @Id
    @Column(name = "price_date_time",columnDefinition = "DATETIME(6)")
    private LocalDateTime price_date_time;
    @Column(name = "note",columnDefinition = "VARCHAR(255)")
    private String note;
    @Column(name = "price",columnDefinition = "DOUBLE")
    private double price;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id",referencedColumnName = "product_id",columnDefinition = "BIGINT(20)")
    private Product product;

    public ProductPrice() {
    }

    public ProductPrice(LocalDateTime price_date_time, String note, double price, Product product) {
        this.price_date_time = price_date_time;
        this.note = note;
        this.price = price;
        this.product = product;
    }

    public LocalDateTime getPrice_date_time() {
        return price_date_time;
    }

    public void setPrice_date_time(LocalDateTime price_date_time) {
        this.price_date_time = price_date_time;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductPrice{" +
                "price_date_time=" + price_date_time +
                ", note='" + note + '\'' +
                ", price=" + price +
                ", product=" + product +
                '}';
    }
}
