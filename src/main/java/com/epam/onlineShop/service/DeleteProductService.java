package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.CartDaoImpl;
import com.epam.onlineShop.database.dao.impl.ProductDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.CartDao;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Cart;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class DeleteProductService implements Service{
    ProductDao productDao = new ProductDaoImpl();
    CartDao cartDao = new CartDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        long productId = Long.valueOf(request.getParameter(PRODUCT_ID));

        List<Cart> carts = cartDao.getAllFromCart(productId);
        for(Cart eachProductInCart : carts){
            cartDao.DeleteProductInCart(productId,eachProductInCart.getUserId());
        }

        productDao.deleteProduct(productId);

        response.sendRedirect(HOME_SERVICE);

    }
}
