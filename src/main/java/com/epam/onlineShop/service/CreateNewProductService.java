package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class CreateNewProductService implements Service{
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        //do checking
        //not access without admin login
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        Product product = new Product();
        String productName = request.getParameter("name");

        if(productName!=null) {
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setImage_url(request.getParameter("image_url"));
            product.setPrice(Long.valueOf(request.getParameter("price")));
            product.setUserId(((User)session.getAttribute("user")).getId());
            productDao.createProduct(product);
            response.sendRedirect("home");
        }else{
            dispatcher = request.getRequestDispatcher("createProduct.jsp");
            dispatcher.forward(request, response);
        }
    }
}
