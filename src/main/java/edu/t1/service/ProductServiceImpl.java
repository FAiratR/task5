package edu.t1.service;

import edu.t1.entity.Product;
import edu.t1.repository.ProductDao;
import edu.t1.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;
    private final User user;

    @Autowired
    public ProductServiceImpl(ProductDao productDao, User user) {
        this.productDao = productDao;
        this.user = user;
    }

    public Product getProduct(Long productId) throws SQLException {
        return productDao.getProduct(productId);
    }

    public List<Product> getAllProducts(Long userId) throws SQLException {
        return productDao.getAllProduct(userId);
    }
}
