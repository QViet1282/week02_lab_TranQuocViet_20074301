package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Order;

import java.util.Optional;

public class OrderRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    public OrderRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertOrder(Order order){
        try {
            transaction.begin();
            em.persist(order);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateOrder(Order order){
        try {
            transaction.begin();
            em.merge(order);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteOrder(Order order){
        try {
            transaction.begin();
            em.remove(order);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<Order> findOrder(long id){
        return Optional.ofNullable(em.find(Order.class, id));
    }



}
