package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.Order;

import java.io.IOException;
import java.sql.SQLException;

public interface OrderDao {
    void createOrder(Order order)throws SQLException, IOException;
    Long takeLastID() throws SQLException;
}
