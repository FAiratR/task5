package edu.t1.repository;

import edu.t1.datasource.DataSource;
import edu.t1.entity.Product;
import edu.t1.entity.TypePruduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDaoImpl implements ProductDao {
    private final DataSource dataSource;

    @Autowired
    public ProductDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Product getProduct(Long productId) throws SQLException {
        Statement statement = dataSource.getConnection().createStatement();
        String SQL = "SELECT id, userId, accNUm, balance, type FROM products WHERE id=" + productId + " and rownum=1";
        ResultSet result = statement.executeQuery(SQL);
        while (result.next()) {
            return new Product(result.getLong("id"),
                                result.getLong("userId"),
                                result.getString("accNum"),
                                result.getLong("balance"),
                                TypePruduct.valueOf(result.getString("type")));
        }
        return null;
    }

    public List<Product> getAllProduct(Long userId) throws SQLException {
        List<Product> products = new ArrayList<Product>();
        Statement statement = dataSource.getConnection().createStatement();
        String SQL = "SELECT id, userId, accNUm, balance, type FROM products WHERE userId=" + userId;
        ResultSet result = statement.executeQuery(SQL);
        while (result.next()) {
            products.add(new Product(result.getLong("id"),
                    result.getLong("userId"),
                    result.getString("accNum"),
                    result.getLong("balance"),
                    TypePruduct.valueOf(result.getString("type"))));
        }
        statement.close();
        return products;
    }
}
