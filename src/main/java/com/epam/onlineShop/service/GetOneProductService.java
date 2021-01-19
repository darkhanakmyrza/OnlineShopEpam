package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class GetOneProductService implements Service{
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ProductDao productDao = new ProductDaoImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        long productId = Long.valueOf(request.getParameter("id"));
        Product product = productDao.getProductById(productId);

        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("product_detail.jsp");
        dispatcher.forward(request, response);


    }
}
