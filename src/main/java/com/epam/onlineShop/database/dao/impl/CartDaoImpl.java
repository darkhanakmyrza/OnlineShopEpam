package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.interfaces.CartDao;
import com.epam.onlineShop.entity.Cart;
import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.Logger;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CartDaoImpl extends ConnectionPool implements CartDao {
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    private static final String INSERT_PRODUCT_INTO_CART = "INSERT cart(product_id, user_id) VALUES(?, ?)";
    private static final String GET_PRODUCTS_FROM_CART_BY_USER_ID = "SELECT * FROM cart WHERE user_id = ?";
    private static final String DELETE_PRODUCT_FROM_CART = "DELETE FROM cart WHERE product_id = ? AND user_id = ?";
    private static final String DELETE_PRODUCT_BY_PRODUCT_ID_FROM_CART = "DELETE FROM cart WHERE product_id = ? AND user_id = ?";
    private static final String GET_CART_ID_FROM_CART = "SELECT id FROM cart WHERE product_id = ? AND user_id = ?";
    private static final String GET_ALL_FROM_CART = "SELECT * FROM cart WHERE product_id = ?";

    public void addProductToCart(Cart cart)throws SQLException, IOException {
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT_INTO_CART);
            pstmt.setLong(1,cart.getProductId());
            pstmt.setLong(2,cart.getUserId());

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

    public List<Long> getProductsInCart(long userId)throws SQLException, IOException{
        Connection con = null;
        List<Long> productsIds = null;
        try{
            productsIds = new ArrayList<>();
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_PRODUCTS_FROM_CART_BY_USER_ID);
            preparedStatement.setLong(1, userId);


            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                long productId = resultSet.getLong("product_id");
                productsIds.add(productId);
            }

            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);
        }catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            LOGGER.error(e);
        }
        return productsIds;
    }

    public void DeleteProductInCart(long productId, long userId) throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT_FROM_CART);
            preparedStatement.setLong(1,productId);
            preparedStatement.setLong(2,userId);

            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
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

    public Cart getCart(Cart cart) throws SQLException,IOException {
        Connection con = null;
        Cart newCart = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_CART_ID_FROM_CART);
            preparedStatement.setLong(1, cart.getProductId());
            preparedStatement.setLong(2, cart.getUserId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                newCart.setId(rs.getLong("id"));
            }
            preparedStatement.close();
            releaseConnection(con);

            }catch(Exception e){
                try {
                    if (con != null)
                        con.close();
                } catch (SQLException e2) {
                }
            LOGGER.error(e);
            }
        return newCart;
    }

    public List<Cart> getAllFromCart(long productId) throws SQLException, IOException{
        List<Cart> carts =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_FROM_CART);
            pstmt.setLong(1,productId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setId(rs.getLong("id"));
                cart.setProductId(rs.getLong("product_id"));
                cart.setUserId(rs.getLong("user_id"));

                carts.add(cart);
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
        return carts;
    }




}
