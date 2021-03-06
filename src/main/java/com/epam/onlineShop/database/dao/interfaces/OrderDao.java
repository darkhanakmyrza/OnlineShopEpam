package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.Order;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDao {
    void createOrder(Order order) throws SQLException, IOException;
    Long takeLastID() throws SQLException;
    ArrayList<Order> getAllOrder() throws SQLException, IOException;
    ArrayList<ArrayList<String>> getFrom4Tables() throws SQLException, IOException;
}
