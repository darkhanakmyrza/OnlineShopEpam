package com.epam.onlineShop.service.factory;

public class ProductFactory {
    private static ProductFactory instance = new ProductFactory();


    public static ProductFactory getInstance() {
        if (instance == null) {
            instance = new ProductFactory();
        }
        return instance;
    }
}
