package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Employee;

import java.util.List;
import java.util.Optional;

public class EmployeeRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public EmployeeRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public boolean insertEmployee(Employee employee){
        try {
            transaction.begin();
            em.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
            return false;
        }
        return true;
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

    public boolean deleteEmployee(long id){
        try {
            transaction.begin();
            em.remove(em.find(Employee.class,id));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
            return false;
        }
        return true;
    }

    public Optional<Employee> findEmployee(long id){
        return Optional.ofNullable(em.find(Employee.class, id));
    }

    public List<Employee> getAllEmployee(){
        return em.createNamedQuery("Employee.findAll",Employee.class).getResultList();
    }

}
