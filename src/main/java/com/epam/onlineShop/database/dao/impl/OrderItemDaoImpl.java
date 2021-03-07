package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.OrderItemDao;
import com.epam.onlineShop.entity.OrderItem;
import com.epam.onlineShop.entity.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderItemDaoImpl extends ConnectionPool implements OrderItemDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String INSERT_INTO_ORDER_ITEM = "INSERT order_item(product_id, user_id, order_id, id) VALUES(?,?,?,?)";
    private static final String SELECT_PRODUCT_ID = "SELECT product_id FROM onlineshopepam.order_item WHERE order_id = ?";
    private static final String DELETE_ORDER_ITEMS = "DELETE FROM onlineshopepam.order_item WHERE order_id = ?";

    @Override
    public void createOrderItem(OrderItem orderItem) throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_ORDER_ITEM);
            pstmt.setLong(1, orderItem.getProductId());
            pstmt.setLong(2, orderItem.getUserId());
            pstmt.setLong(3, orderItem.getOrderId());
            pstmt.setLong(4,orderItem.getId());

            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");

            pstmt.close();
            releaseConnection(con);

        }catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        }
    }

    @Override
    public ArrayList<Long> getProductsIdFromOrderItem(Long orderId ) throws SQLException, IOException {
        ArrayList<Long> productsId =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_PRODUCT_ID);
            pstmt.setLong(1,orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                productsId.add(rs.getLong("product_id"));
            }
            pstmt.close();
            releaseConnection(con);

        }catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error(e);
        }
        return productsId;
    }

    @Override
    public void deleteOrderItemsByOrderId(Long orderId) throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(DELETE_ORDER_ITEMS);
            pstmt.setLong(1, orderId);

            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("deleted " + count + " rows");

            pstmt.close();
            releaseConnection(con);

        }catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        }
    }


}
