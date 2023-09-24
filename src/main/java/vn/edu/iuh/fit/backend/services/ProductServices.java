package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Product;
import vn.edu.iuh.fit.backend.repositories.ProductRepository;

import java.util.List;

public class ProductServices {
    private ProductRepository productRepository;

    public ProductServices() {
        productRepository = new ProductRepository();
    }

    public List<Product> getAll(){
        return productRepository.getAll();
    }
}
