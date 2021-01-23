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
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class GetOneProductService implements Service{
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private ProductDao productDao = new ProductDaoImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;

        long productId = Long.valueOf(request.getParameter(ID));
        Product product = productDao.getProductById(productId);

        request.setAttribute(PRODUCT, product);
        dispatcher = request.getRequestDispatcher(PRODUCT_DETAIL_JSP);
        dispatcher.forward(request, response);


    }
}
