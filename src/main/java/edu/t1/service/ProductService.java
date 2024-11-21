package edu.t1.service;

import edu.t1.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    public Product getProduct(Long productId) throws SQLException;
    public List<Product> getAllProducts(Long userId) throws SQLException;
}
