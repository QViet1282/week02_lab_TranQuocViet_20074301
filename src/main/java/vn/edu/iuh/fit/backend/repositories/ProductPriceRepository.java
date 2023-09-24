package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.ProductPrice;

import java.util.Optional;

public class ProductPriceRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public ProductPriceRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProductPrice(ProductPrice productPrice) {
        try {
            transaction.begin();
            em.persist(productPrice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateProductPrice(ProductPrice productPrice) {
        try {
            transaction.begin();
            em.merge(productPrice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteProductPrice(ProductPrice productPrice) {
        try {
            transaction.begin();
            em.remove(productPrice);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<ProductPrice> findProductPrice(long id) {
        return Optional.ofNullable(em.find(ProductPrice.class, id));
    }
}
