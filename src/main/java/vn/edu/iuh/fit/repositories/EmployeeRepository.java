package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.Employee;

import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertEmployee(Employee employee){
        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateEmployee(Employee employee){
        try {
            transaction.begin();
            em.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteEmployee(Employee employee){
        try {
            transaction.begin();
            em.remove(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<Employee> findEmployee(long id){
        return Optional.ofNullable(em.find(Employee.class, id));
    }



}
