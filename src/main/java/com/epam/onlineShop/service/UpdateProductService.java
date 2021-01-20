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

public class UpdateProductService implements Service {
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        //do check authentication
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        String productName = request.getParameter("name");
        System.out.println(productName);
        if(productName!=null) {
            Product product = new Product();
            product.setName(request.getParameter("name"));
            product.setDescription(request.getParameter("description"));
            product.setImage_url(request.getParameter("image_url"));
            product.setPrice(Long.valueOf(request.getParameter("price")));
            product.setUserId(((User)session.getAttribute("user")).getId());
            product.setId(Long.valueOf(request.getParameter("productId")));
            productDao.updateProduct(product);
            response.sendRedirect("home");
        }else{
            Product product = productDao.getProductById(Long.valueOf(request.getParameter("productId")));
            request.setAttribute("product", product);
            dispatcher = request.getRequestDispatcher("updateProduct.jsp");
            dispatcher.forward(request, response);
        }
    }
}
