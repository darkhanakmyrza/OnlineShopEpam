package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.CartDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.CartDao;
import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.User;
import com.epam.onlineShop.service.factory.CartFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class AddProductToCartService implements Service {
    CartDao cartDao = new CartDaoImpl();
    CartFactory cartFactory = new CartFactory();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        HttpSession session = request.getSession();

        long productId = Long.valueOf(request.getParameter("productId"));
        long userId = ((User)session.getAttribute("user")).getId();
        List<Long> productInCart =cartDao.getProductsInCart(userId);
        boolean alreadyInCart = false;
        for(Long product : productInCart){
            if(product.equals(productId)){
                alreadyInCart= true;
                break;
            }
        }
        if(!alreadyInCart){
            Cart cart = cartFactory.fillCart(request);
            cartDao.addProductToCart(cart);
            response.sendRedirect("cart");
        }else{
            response.sendRedirect("home");
        }
    }
}
