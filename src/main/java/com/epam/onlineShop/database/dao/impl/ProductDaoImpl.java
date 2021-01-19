package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.dao.interfaces.ProductDao;
import com.epam.onlineShop.entity.Product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl extends ConnectionPool implements ProductDao {


    private static final String GET_ALL_PRODUCTS = "SELECT * FROM PRODUCT";
    private static final String GET_PRODUCT = "SELECT * FROM PRODUCT WHERE id = ?";

    public Product getProductById(Long id) throws SQLException, IOException{
        Product product = null;
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_PRODUCT);
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getLong("price"));
                product.setImage_url(rs.getString("image_url"));
                product.setUserId(rs.getLong("user_id"));
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
        return product;
    }

    public List<Product> getAllProduct() throws SQLException, IOException{
        List<Product> products =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getLong("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getLong("price"));
                product.setImage_url(rs.getString("image_url"));
                product.setUserId(rs.getLong("user_id"));


                products.add(product);
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
        return products;
    }
}
