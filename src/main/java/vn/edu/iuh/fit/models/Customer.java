package vn.edu.iuh.fit.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cust_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "address", columnDefinition = "VARCHAR(250)")
    private String address;
    @Column(name = "email",columnDefinition = "VARCHAR(150)", unique = true)
    private String email;
    @Column(name = "cust_name", columnDefinition = "VARCHAR(150)")
    private String name;
    @Column(name = "phone",columnDefinition = "VARCHAR(15)")
    private String phone;
    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private List<Order> orderList;
    public Customer() {
    }

    public Customer(String address, String email, String name, String phone) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.phone = phone;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
