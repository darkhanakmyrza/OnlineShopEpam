package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.*;
import com.epam.onlineShop.database.dao.interfaces.*;
import com.epam.onlineShop.entity.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import java.util.Date;

import static com.epam.onlineShop.util.constants.ConstantNames.USER;
import static com.epam.onlineShop.util.constants.ConstantPageNames.HOME_SERVICE;

public class CreateOrderFromCartProductsService implements Service{
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    AddressDao addressDao = new AddressDaoImpl();
    StatusDao statusDao = new StatusDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();

        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);

        Address address = new Address();
        address.setCountry(request.getParameter("country"));
        address.setCity(request.getParameter("city"));
        address.setStreet(request.getParameter("street"));
        address.setPhone(request.getParameter("phone"));
        address.setId(addressDao.takeLastID() + 1);
        addressDao.createAddress(address);
        System.out.println(address.getId());

        Status status = new Status();
        status.setId(statusDao.getIdByStatusName("pending"));
        status.setStatusName("pending");
        System.out.println(status.getId());

        Order order = new Order();
        order.setId(orderDao.takeLastID() + 1);
        LocalDateTime now = LocalDateTime.now();
        Timestamp dateTime = Timestamp.valueOf(now);
        order.setDateTime(dateTime);
        order.setStatusId(status.getId());
        order.setDeliveryAddressId(address.getId());
        orderDao.createOrder(order);
        System.out.println(order.getId());


        for(Long productId : productIdsInCart){
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(productId);
            orderItem.setUserId(userId);
            orderItem.setOrderId(order.getId());
            orderItemDao.createOrderItem(orderItem);

        }

        response.sendRedirect(HOME_SERVICE);





    }
}
