package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Product;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    List<Product> getAllProduct() throws SQLException, IOException;
    Product getProductById(Long id) throws SQLException, IOException;
}
