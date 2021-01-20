package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Product;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class SearchProductsService implements Service{
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        RequestDispatcher dispatcher;

        String searchedWord = (request.getParameter("product"));
        List<Product> products = productDao.getSearchedProducts(searchedWord);
        System.out.println(searchedWord );
        System.out.println(products);
        request.setAttribute("products", products);
        dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);

    }
}
