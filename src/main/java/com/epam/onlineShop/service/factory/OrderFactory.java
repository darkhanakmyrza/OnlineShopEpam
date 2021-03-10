package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.database.dao.impl.OrderDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;
import com.epam.onlineShop.entity.Address;
import com.epam.onlineShop.entity.Order;
import com.epam.onlineShop.entity.Status;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class OrderFactory {
    public static OrderFactory instance = new OrderFactory();
    OrderDao orderDao = new OrderDaoImpl();

    public Order fillOrder(HttpServletRequest request, Status status, Address address) throws SQLException {
        Order order = new Order();
        order.setId(orderDao.takeLastID() + 1);
        LocalDateTime now = LocalDateTime.now();
        Timestamp dateTime = Timestamp.valueOf(now);
        order.setDateTime(dateTime);
        order.setStatusId(status.getId());
        order.setDeliveryAddressId(address.getId());
        return order;

    }

    public static OrderFactory getInstance() {
        if (instance == null) {
            instance = new OrderFactory();
        }
        return instance;
    }

}
