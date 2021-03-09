package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.OrderItemDaoImpl;
import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.impl.StatusDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.OrderItemDao;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.database.dao.interfaces.StatusDao;
import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class OrderDetailAdminService implements Service{

    OrderItemDao orderItemDao = new OrderItemDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    StatusDao statusDao = new StatusDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        RequestDispatcher dispatcher;

        long orderId = Long.valueOf(request.getParameter(ORDER_ID));
        ArrayList<Long> productsIds = orderItemDao.getProductsIdFromOrderItem(orderId);

        ArrayList<Product> products = new ArrayList<>();
        for(Long productId : productsIds){
            products.add(productDao.getProductById(productId));
        }

        List<Status> statuses = statusDao.getAllStatuses();
        Status currentStatus = statusDao.getStatusByOrderId(orderId);

        request.setAttribute(PRODUCTS, products);
        request.setAttribute(STATUSES, statuses);
        request.setAttribute(CURRENT_STATUS, currentStatus);
        request.setAttribute(ORDER_ID, orderId);
        System.out.println(products);
        dispatcher = request.getRequestDispatcher(ORDER_DETAIL_JSP);
        dispatcher.forward(request, response);
    }
}
