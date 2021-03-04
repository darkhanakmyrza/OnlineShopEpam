package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.StatusDao;
import com.epam.onlineShop.entity.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StatusDaoImpl extends ConnectionPool implements StatusDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    private static final String SELECT_ID_BY_STATUS_NAME = "SELECT id FROM ordering_status WHERE status_name = ? ";

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
}
