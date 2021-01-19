package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.interfaces.CartDao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CartDaoImpl extends ConnectionPool implements CartDao {
    private static final String INSERT_PRODUCT_INTO_CART = "INSERT cart(product_id, user_id) VALUES(?, ?)";

    public void addProductToCart(Long productId, Long userId)throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT_INTO_CART);
            pstmt.setLong(1,productId);
            pstmt.setLong(2,userId);

            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");

            pstmt.close();
            releaseConnection(con);
        }catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            System.out.println(e);
        }
    }
}
