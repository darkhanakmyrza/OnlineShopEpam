package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.OrderItem;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public interface OrderItemDao {
    void createOrderItem(OrderItem orderItem)throws SQLException, IOException;
    ArrayList<Long> getProductsIdFromOrderItem(Long orderId ) throws SQLException, IOException;
    void deleteOrderItemsByOrderId(Long orderId) throws SQLException, IOException;
}