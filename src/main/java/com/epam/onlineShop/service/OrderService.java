package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.CartDaoImpl;
import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.CartDao;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.onlineShop.util.constants.ConstantNames.USER;
import static com.epam.onlineShop.util.constants.ConstantNames.USERS;
import static com.epam.onlineShop.util.constants.ConstantPageNames.ALL_USERS_JSP;

public class OrderService implements Service{
    CartDao cartDao = new CartDaoImpl();
    ProductDao productDao = new ProductDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();

        List<Long> productIdsInCart = cartDao.getProductsInCart(userId);
        long totalPrice = 0;
        for(long productId: productIdsInCart){
            totalPrice+= productDao.getProductById(productId).getPrice();
        }

        request.setAttribute("totalPrice", totalPrice);

        dispatcher = request.getRequestDispatcher("order.jsp");
        dispatcher.forward(request, response);
    }
}
