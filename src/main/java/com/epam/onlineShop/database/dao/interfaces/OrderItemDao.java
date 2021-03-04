package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.OrderItem;

import java.io.IOException;
import java.sql.SQLException;

public interface OrderItemDao {
    void createOrderItem(OrderItem orderItem)throws SQLException, IOException;

}