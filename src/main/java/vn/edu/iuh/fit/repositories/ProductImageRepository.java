package vn.edu.iuh.fit.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.models.ProductImage;
import java.util.Optional;

public class ProductImageRepository {
    private EntityManager em;
    private EntityTransaction transaction;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());

    public ProductImageRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProductImage(ProductImage productImage) {
        try {
            transaction.begin();
            em.persist(productImage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateProductImage(ProductImage productImage) {
        try {
            transaction.begin();
            em.merge(productImage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteProductImage(ProductImage productImage) {
        try {
            transaction.begin();
            em.remove(productImage);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<ProductImage> findProductImage(long id) {
        return Optional.ofNullable(em.find(ProductImage.class, id));
    }
}
