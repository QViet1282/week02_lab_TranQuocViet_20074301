package vn.edu.iuh.fit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Order {
    @Id
    private long order_id;
    private LocalDateTime orderDate;
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Customer customer;
    @OneToMany
    private List<OrderDetails> orderDetails;
    public Order() {
    }

    public Order(long order_id, LocalDateTime orderDate) {
        this.order_id = order_id;
        this.orderDate = orderDate;
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order_id=" + order_id +
                ", orderDate=" + orderDate +
                '}';
    }
}
