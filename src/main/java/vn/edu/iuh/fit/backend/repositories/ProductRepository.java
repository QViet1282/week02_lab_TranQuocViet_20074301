package vn.edu.iuh.fit.backend.repositories;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vn.edu.iuh.fit.backend.models.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private EntityManager em;
    private EntityTransaction transaction;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass().getName());
    public ProductRepository() {
        em = Persistence.createEntityManagerFactory("my_persistence_unit").createEntityManager();
        transaction = em.getTransaction();
    }

    public void insertProduct(Product product) {
        try {
            transaction.begin();
            em.persist(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void updateProduct(Product product) {
        try {
            transaction.begin();
            em.merge(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public void deleteProduct(Product product) {
        try {
            transaction.begin();
            em.remove(product);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            LOGGER.error(e.getMessage());
        }
    }

    public Optional<Product> findProduct(long id) {
        return Optional.ofNullable(em.find(Product.class, id));
    }

    public List<Product> getAll(){
//        return em.createNamedQuery("PRODUCT.findAll",Product.class).getResultList();
            return em.createNativeQuery("select * from product where status = 1",Product.class).getResultList();
    }



}
