package vn.edu.iuh.fit.backend.models;

import jakarta.persistence.*;
import vn.edu.iuh.fit.backend.enums.EmployeeStatus;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "employee")
public class Employee implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_id",columnDefinition = "BIGINT(20)")
    private long id;
    @Column(name = "address",columnDefinition = "VARCHAR(250)")
    private String address;
    @Column(name = "dob",columnDefinition = "DATETIME(6)")
    private LocalDateTime dob;
    @Column(unique = true,columnDefinition = "VARCHAR(150)",name = "email")
    private String email;
    @Column(name = "full_name", columnDefinition = "VARCHAR(150)")
    private String fullName;
    @Column(name = "phone",columnDefinition = "VARCHAR(15)")
    private String phone;
    @Column(name = "status",columnDefinition = "INT(15)")
    private EmployeeStatus status;
    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    private List<Order> lstOrder;

    public Employee() {
    }

    public Employee(String address, LocalDateTime dob, String email, String fullName, String phone, EmployeeStatus status) {
        this.address = address;
        this.dob = dob;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long emp_id) {
        this.id = emp_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getDob() {
        return dob;
    }

    public void setDob(LocalDateTime dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "emp_id=" + id +
                ", address='" + address + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                '}';
    }
}
