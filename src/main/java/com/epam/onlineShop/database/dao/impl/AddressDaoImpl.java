package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.AddressDao;
import com.epam.onlineShop.entity.Address;
import com.epam.onlineShop.entity.Product;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressDaoImpl extends ConnectionPool implements AddressDao {

    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    private static final String INSERT_ADDRESS = "INSERT address(country, city, street, phone) VALUES(?,?,?,?)";
    private static final String SELECT_LAST_ID_FROM_ADDRESS = "SELECT MAX(id) FROM address";

    @Override
    public void createAddress(Address address) throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_ADDRESS);
            pstmt.setString(1,address.getCountry());
            pstmt.setString(2,address.getCity());
            pstmt.setString(3, address.getStreet());
            pstmt.setString(4,address.getPhone());

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
    @Override
    public Long takeLastID() throws SQLException {
        long lastId = 0;
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_LAST_ID_FROM_ADDRESS);
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
