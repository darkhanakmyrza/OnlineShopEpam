package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.OrderDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class ChangeStatusService implements Service {
    OrderDao orderDao = new OrderDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        long orderId = Long.valueOf(request.getParameter(ORDER_ID));
        long statusId = Long.valueOf(request.getParameter(STATUS_ID));
        orderDao.changeOrderStatus(orderId, statusId);

        response.sendRedirect("orderDetail?orderId="+orderId);

    }
}
