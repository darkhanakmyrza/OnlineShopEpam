package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.StatusDao;
import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.Status;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatusDaoImpl extends ConnectionPool implements StatusDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String SELECT_ID_BY_STATUS_NAME = "SELECT id FROM ordering_status WHERE status_name = ? ";
    private static final String SELECT_STATUS_FROM_ORDER = "SELECT onlineshopepam.ordering_status.status_name, onlineshopepam.ordering_status.id FROM onlineshopepam.ordering_status " +
            "INNER JOIN onlineshopepam.order ON onlineshopepam.ordering_status.id = onlineshopepam.order.status WHERE onlineshopepam.order.id = ?";
    private static final String SELECT_ALL = "SELECT * FROM ordering_status";

    @Override
    public Long getIdByStatusName(String statusName) throws SQLException, IOException {
        long id = 0;
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ID_BY_STATUS_NAME);
            pstmt.setString(1, statusName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                id = rs.getLong("id");
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
        return id;
    }
    @Override
    public List<Status> getAllStatuses() throws SQLException, IOException {
        List<Status> statuses = new ArrayList<>();
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_ALL);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Status status = new Status();
                status.setId(rs.getLong("id"));
                status.setStatusName(rs.getString("status_name"));
                statuses.add(status);
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
        return statuses;
    }
    @Override
    public Status getStatusByOrderId(Long orderId) throws SQLException, IOException {
        Status status = new Status();
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_STATUS_FROM_ORDER);
            pstmt.setLong(1,orderId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {

                status.setId(rs.getLong("id"));
                status.setStatusName(rs.getString("status_name"));

            }
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
        return status;
    }

}
