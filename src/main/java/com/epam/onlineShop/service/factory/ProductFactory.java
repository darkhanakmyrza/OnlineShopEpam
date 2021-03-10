package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static com.epam.onlineShop.util.constants.ConstantNames.*;

public class ProductFactory {
    private static ProductFactory instance = new ProductFactory();



    public Product fillProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Product product = new Product();
        product.setName(request.getParameter(NAME));
        product.setDescription(request.getParameter(DESCRIPTION));
        product.setImage_url(request.getParameter(IMAGE_URL));
        product.setPrice(Long.valueOf(request.getParameter(PRICE)));
        product.setUserId(((User)session.getAttribute(USER)).getId());
        return product;
    }
    public Product updateProduct(HttpServletRequest request){
        HttpSession session = request.getSession();
        Product product = new Product();
        product.setName(request.getParameter(NAME));
        product.setDescription(request.getParameter(DESCRIPTION));
        product.setImage_url(request.getParameter(IMAGE_URL));
        product.setPrice(Long.valueOf(request.getParameter(PRICE)));
        product.setUserId(((User)session.getAttribute(USER)).getId());
        product.setId(Long.valueOf(request.getParameter(PRODUCT_ID)));
        return product;
    }

    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
}
