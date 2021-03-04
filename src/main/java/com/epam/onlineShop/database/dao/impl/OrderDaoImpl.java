package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;
import com.epam.onlineShop.entity.Order;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class OrderDaoImpl extends ConnectionPool implements OrderDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String SELECT_LAST_ID_FROM_ORDER = "SELECT MAX(id) FROM onlineshopepam.order";
    private static final String INSERT_INTO_ORDER = "INSERT onlineshopepam.order(date_time, status, delivery_address) VALUES(?,?,?)";


    @Override
    public void createOrder(Order order) throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_ORDER);
            pstmt.setTimestamp(1,order.getDateTime());
            pstmt.setLong(2, order.getStatusId());
            pstmt.setLong(3, order.getDeliveryAddressId());

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
    public Long takeLastID() throws SQLException {
        long lastId = 0;
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_LAST_ID_FROM_ORDER);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                lastId =rs.getLong("MAX(ID)");
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
        return lastId;
    }
}
