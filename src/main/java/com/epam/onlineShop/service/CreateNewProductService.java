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



public class CreateNewProductService implements Service{
    ProductDao productDao = new ProductDaoImpl();
    ProductFactory productFactory = ProductFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        Product product = new Product();
        String productName = request.getParameter(NAME);

        if(productName!=null) {
            product = productFactory.fillProduct(request);
            productDao.createProduct(product);
            response.sendRedirect(HOME_SERVICE);
        }else{
            dispatcher = request.getRequestDispatcher(CREATE_PRODUCT_JSP);
            dispatcher.forward(request, response);
        }
    }
}
