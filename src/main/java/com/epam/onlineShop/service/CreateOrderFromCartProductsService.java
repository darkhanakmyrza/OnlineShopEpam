package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.*;
import com.epam.onlineShop.database.dao.interfaces.*;
import com.epam.onlineShop.entity.*;
import com.epam.onlineShop.service.factory.AddressFactory;
import com.epam.onlineShop.service.factory.OrderFactory;
import com.epam.onlineShop.service.factory.OrderItemFactory;
import com.epam.onlineShop.service.factory.StatusFactory;

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

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class CreateOrderFromCartProductsService implements Service{
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    AddressDao addressDao = new AddressDaoImpl();
    StatusDao statusDao = new StatusDaoImpl();
    OrderDao orderDao = new OrderDaoImpl();
    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    AddressFactory addressFactory = AddressFactory.getInstance();
    StatusFactory statusFactory = StatusFactory.getInstance();
    OrderFactory orderFactory = OrderFactory.getInstance();
    OrderItemFactory orderItemFactory = OrderItemFactory.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();
        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);
        Address address = addressFactory.fillAddress(request);
        addressDao.createAddress(address);
        Status status = statusFactory.fillStatus(request);

        Order order = orderFactory.fillOrder(request, status, address);
        orderDao.createOrder(order);

        for(Long productId : productIdsInCart){
            OrderItem orderItem = orderItemFactory.fillOrderItem(request, productId,userId, order);
            orderItemDao.createOrderItem(orderItem);
        }

        cartDao.deleteProductFromCartByUserId(userId);

        response.sendRedirect(HOME_SERVICE);





    }
}
