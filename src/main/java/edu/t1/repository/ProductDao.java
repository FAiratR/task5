package edu.t1.repository;

import edu.t1.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public Product getProduct(Long productId) throws SQLException;
    public List<Product> getAllProduct(Long userId) throws SQLException;
}
