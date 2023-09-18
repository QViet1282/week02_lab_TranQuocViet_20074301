package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_id",columnDefinition = "BIGINT(20)")
    private long order_id;
    @Column(name = "order_date",columnDefinition = "DATETIME(6)")
    private LocalDateTime orderDate;
    @ManyToOne
    @JoinColumn(name = "emp_id",referencedColumnName = "emp_id",columnDefinition = "BIGINT(20)")
    private Employee employee;
    @ManyToOne
    @JoinColumn(name = "cust_id",referencedColumnName = "cust_id",columnDefinition = "BIGINT(20)")
    private Customer customer;
    @OneToMany(mappedBy = "order",cascade = jakarta.persistence.CascadeType.ALL)
    private List<OrderDetail> orderDetails;
    public Order() {
    }

    public Order(LocalDateTime orderDate) {
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
