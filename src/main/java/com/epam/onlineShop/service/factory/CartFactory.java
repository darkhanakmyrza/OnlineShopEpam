package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class CartFactory {
    private static CartFactory instance = new CartFactory();

    public Cart fillCart(HttpServletRequest request){
        HttpSession session = request.getSession();
        Cart cart = new Cart();

        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));
        long userId = ((User)session.getAttribute(USER)).getId();
        cart.setUserId(userId);
        cart.setProductId(productId);
        return cart;
    }

    public static CartFactory getInstance() {
        if (instance == null) {
            instance = new CartFactory();
        }
        return instance;
    }
}
