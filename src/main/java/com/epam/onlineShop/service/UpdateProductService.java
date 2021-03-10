package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.User;
import com.epam.onlineShop.service.factory.ProductFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;


public class UpdateProductService implements Service {
    ProductDao productDao = new ProductDaoImpl();
    ProductFactory productFactory = ProductFactory.getInstance();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        //do check authentication
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();

        String productName = request.getParameter(NAME);
        System.out.println(productName);
        if(productName!=null) {
            Product product = productFactory.updateProduct(request);
            productDao.updateProduct(product);
            response.sendRedirect(HOME_SERVICE);
        }else{
            Product product = productDao.getProductById(Long.valueOf(request.getParameter(PRODUCT_ID)));
            request.setAttribute(PRODUCT, product);
            dispatcher = request.getRequestDispatcher(UPDATE_PRODUCT_JSP);
            dispatcher.forward(request, response);
        }
    }
}
