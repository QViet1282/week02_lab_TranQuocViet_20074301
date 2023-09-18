package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.OrderDetail;

import java.util.Optional;

public class OrderDetailRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public OrderDetailRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertOrderDetail(OrderDetail orderDetail) {
        try {
            transaction.begin();
            em.persist(orderDetail);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateOrderDetail(OrderDetail orderDetail) {
        try {
            transaction.begin();
            em.merge(orderDetail);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteOrderDetail(OrderDetail orderDetail) {
        try {
            transaction.begin();
            em.remove(orderDetail);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<OrderDetail> findOrderDetail(long id) {
        return Optional.ofNullable(em.find(OrderDetail.class, id));
    }

}
