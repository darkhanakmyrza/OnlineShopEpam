package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;


public class GetAllProductsService implements Service {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ProductDao productDao = new ProductDaoImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        List<Product> products = productDao.getAllProduct();


        request.setAttribute(PRODUCTS, products);

        dispatcher = request.getRequestDispatcher(HOME_JSP);
        dispatcher.forward(request, response);
    }
}
