package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.OrderDao;
import com.epam.onlineShop.entity.Order;
import com.epam.onlineShop.entity.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends ConnectionPool implements OrderDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String SELECT_LAST_ID_FROM_ORDER = "SELECT MAX(id) FROM onlineshopepam.order";
    private static final String INSERT_INTO_ORDER = "INSERT onlineshopepam.order(date_time, status, delivery_address) VALUES(?,?,?)";
    private static final String SELECT_ALL_FROM_ORDER = "SELECT * FROM onlineshopepam.order";
    private static final String SELECT_FROM_4_TABLES = "SELECT onlineshopepam.order.id order_id, onlineshopepam.order.date_time, onlineshopepam.user.email user_email, onlineshopepam.ordering_status.status_name\n" +
            "FROM onlineshopepam.order \n" +
            "INNER JOIN onlineshopepam.ordering_status ON onlineshopepam.order.status=onlineshopepam.ordering_status.id\n" +
            "INNER JOIN onlineshopepam.order_item ON onlineshopepam.order.id = onlineshopepam.order_item.order_id\n" +
            "INNER JOIN onlineshopepam.user ON onlineshopepam.user.id = onlineshopepam.order_item.user_id\n" +
            "GROUP BY onlineshopepam.order.id";
    private static final String UPDATE_STATUS_ORDER = "UPDATE onlineshopepam.order SET  status = ? WHERE id = ?";

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

    @Override
    public ArrayList<Order> getAllOrder() throws SQLException, IOException {
        ArrayList<Order> orders =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ALL_FROM_ORDER);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setId(rs.getLong("id"));
                order.setDateTime(rs.getTimestamp("date_time"));
                order.setStatusId(rs.getLong("status"));
                order.setDeliveryAddressId(rs.getLong("delivery_address"));
                orders.add(order);
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
        return orders;
    }

    @Override
    public ArrayList<ArrayList<String>> getFrom4Tables() throws SQLException, IOException {
        ArrayList<ArrayList<String>> orders =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_FROM_4_TABLES);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                ArrayList<String> order =new ArrayList<>();
                order.add(String.valueOf(rs.getLong("order_id")));
                order.add(String.valueOf(rs.getTimestamp("date_time")));
                order.add(rs.getString("user_email"));
                order.add(rs.getString("status_name"));
                orders.add(order);
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
        return orders;
    }

    @Override
    public void changeOrderStatus(Long orderId, Long statusId) throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(UPDATE_STATUS_ORDER);

            pstmt.setLong(1,statusId);
            pstmt.setLong(2,orderId);

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
}
