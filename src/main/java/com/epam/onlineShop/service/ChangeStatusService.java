package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.OrderDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class ChangeStatusService implements Service {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        long orderId = Long.valueOf(request.getParameter("orderId"));
        long statusId = Long.valueOf(request.getParameter("statusId"));
        orderDao.changeOrderStatus(orderId, statusId);

        response.sendRedirect("orderDetail?orderId="+orderId);

    }
}
