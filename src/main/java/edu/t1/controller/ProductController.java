package edu.t1.controller;

import edu.t1.entity.Product;
import edu.t1.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class ProductController {
    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/product/getProduct/{productId}")
    public Product getProduct(@PathVariable("productId") Long productId) throws SQLException {
        return productService.getProduct(productId);
    }

    @GetMapping(value = "/product/getAllProduct/{userId}")
    public List<Product> getAllProducts(@PathVariable("userId")Long userId) throws SQLException {
        return productService.getAllProducts(userId);
    }
}
