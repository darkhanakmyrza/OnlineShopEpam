package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    void addProductToCart(Cart cart)throws SQLException, IOException;
    List<Long> getProductsInCart(long userId) throws SQLException, IOException;
    void DeleteProductInCart(long productId, long userId) throws SQLException, IOException;
    Cart getCart(Cart cart) throws SQLException, IOException;
    List<Cart> getAllFromCart(long productId) throws SQLException, IOException;
}
