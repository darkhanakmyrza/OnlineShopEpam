package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.Order;
import com.epam.onlineShop.entity.OrderItem;

import javax.servlet.http.HttpServletRequest;

public class OrderItemFactory {
    public static OrderItemFactory instance = new OrderItemFactory();

    public OrderItem fillOrderItem(HttpServletRequest request, long productId, long userId, Order order){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(productId);
        orderItem.setUserId(userId);
        orderItem.setOrderId(order.getId());
        return orderItem;
    }
    public static OrderItemFactory getInstance() {
        if (instance == null) {
            instance = new OrderItemFactory();
        }
        return instance;
    }
}
