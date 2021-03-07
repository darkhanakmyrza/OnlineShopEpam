package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.AddressDaoImpl;
import com.epam.onlineShop.database.dao.impl.OrderDaoImpl;
import com.epam.onlineShop.database.dao.impl.OrderItemDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.AddressDao;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;
import com.epam.onlineShop.database.dao.interfaces.OrderItemDao;
import com.epam.onlineShop.entity.Address;
import com.epam.onlineShop.entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class DeleteOrderAdminService implements Service {
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    AddressDao addressDao = new AddressDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        long orderId = Long.valueOf(request.getParameter("orderId"));
        long addressId = orderDao.getOrderById(orderId).getDeliveryAddressId();

        orderItemDao.deleteOrderItemsByOrderId(orderId);

        orderDao.deleteOrderById(orderId);
        addressDao.deleteAddressById(addressId);
        response.sendRedirect("ordersAdmin");
    }
}
