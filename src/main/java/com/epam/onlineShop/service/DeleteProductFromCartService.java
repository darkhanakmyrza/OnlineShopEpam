package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.CartDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.CartDao;
import com.epam.onlineShop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class DeleteProductFromCartService implements Service {
    CartDao cartDao = new CartDaoImpl();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        HttpSession session = request.getSession();
        long userId = ((User)session.getAttribute(USER)).getId();

        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        cartDao.DeleteProductInCart(productId,userId);
        response.sendRedirect(CART_SERVICE);


    }
}
