package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.service.builder.ProductBuilderImpl;
import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epam.onlineShop.util.constants.ConstantNames.*;

public class ProductFactory {
    private static ProductFactory instance = new ProductFactory();



    public Product fillProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = new ProductBuilderImpl().
                setName(request.getParameter(NAME)).
                setDescription(request.getParameter(DESCRIPTION)).
                setImage_url(request.getParameter(IMAGE_URL)).
                setPrice(Long.valueOf(request.getParameter(PRICE))).
                setUserId(((User)session.getAttribute(USER)).getId())
                .build();

        return product;
    }
    public Product updateProduct(HttpServletRequest request){
        HttpSession session = request.getSession();
        Product product = new ProductBuilderImpl().
                setName(request.getParameter(NAME)).
                setDescription(request.getParameter(DESCRIPTION)).
                setImage_url(request.getParameter(IMAGE_URL)).
                setPrice(Long.valueOf(request.getParameter(PRICE))).
                setUserId(((User)session.getAttribute(USER)).getId())
                .setId(Long.valueOf(request.getParameter(PRODUCT_ID)))
                .build();

        return product;
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
}
