package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.Order;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderDao {
    void createOrder(Order order) throws SQLException, IOException;
    Long takeLastID() throws SQLException;
    ArrayList<Order> getAllOrder() throws SQLException, IOException;
    ArrayList<ArrayList<String>> getFrom4Tables() throws SQLException, IOException;
    void changeOrderStatus(Long orderId, Long statusId) throws SQLException, IOException;
    ArrayList<ArrayList<String>> getOrderByUserId(Long userId) throws SQLException, IOException;
    void deleteOrderById(Long orderId)throws SQLException, IOException;
    Order getOrderById(Long orderId)throws SQLException, IOException;
}
