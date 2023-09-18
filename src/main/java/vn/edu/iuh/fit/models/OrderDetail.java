package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_detail")
//@PrimaryKey(columns = {@jakarta.persistence.Column(name = "order_id"), @jakarta.persistence.Column(name = "product_id")})
//@IdClass(OrderDetailId.class)
public class OrderDetail implements Serializable {
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    public OrderDetailId id;
    @Id
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Id
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "quantity",columnDefinition = "DOUBLE")
    private double quantity;
    @Column(name = "price",columnDefinition = "DOUBLE")
    private double price;
    @Column(name = "note",columnDefinition = "VARCHAR(255)")
    private String note;

    public OrderDetail() {
    }

    public OrderDetail(Order order, Product product, double quantity, double price, String note) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
        this.price = price;
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "order=" + order +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                ", note='" + note + '\'' +
                '}';
    }
}
