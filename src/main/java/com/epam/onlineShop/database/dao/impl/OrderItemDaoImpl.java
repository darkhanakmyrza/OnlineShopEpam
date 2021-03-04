package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.OrderItemDao;
import com.epam.onlineShop.entity.OrderItem;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrderItemDaoImpl extends ConnectionPool implements OrderItemDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String INSERT_INTO_ORDER_ITEM = "INSERT order_item(product_id, user_id, order_id) VALUES(?,?,?)";

    @Override
    public void createOrderItem(OrderItem orderItem) throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_ORDER_ITEM);
            pstmt.setLong(1, orderItem.getProductId());
            pstmt.setLong(2, orderItem.getUserId());
            pstmt.setLong(3, orderItem.getOrderId());

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
            LOGGER.error(e);
        }
    }
}
