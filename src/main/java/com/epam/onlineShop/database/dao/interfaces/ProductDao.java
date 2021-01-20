package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct() throws SQLException, IOException;
    Product getProductById(Long id) throws SQLException, IOException;
    void createProduct(Product product) throws SQLException, IOException;
    void updateProduct(Product product) throws SQLException, IOException;
    List<Product> getSearchedProducts(String productName) throws SQLException, IOException;
    void deleteProduct(long productId)throws SQLException, IOException;
}
