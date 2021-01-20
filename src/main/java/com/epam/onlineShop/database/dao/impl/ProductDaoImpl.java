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

    private static final String GET_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String GET_PRODUCT = "SELECT * FROM product WHERE id = ?";
    private static final String INSERT_PRODUCT = "INSERT product(name, description, price, image_url, user_id) VALUES(?,?,?,?,?)";
    private static final String UPDATE_PRODUCT = "UPDATE product SET  name = ?, description = ?, price = ?, image_url= ? WHERE id = ?";
    private static final String SELECT_SEARCHED_PRODUCT = "SELECT * FROM product WHERE name like ? ";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id = ? ";


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

    public void updateProduct(Product product) throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_PRODUCT);

            preparedStatement.setString(1,product.getName());
            preparedStatement.setString(2,product.getDescription());
            preparedStatement.setLong(3,product.getPrice());
            preparedStatement.setString(4,product.getImage_url());
            preparedStatement.setLong(5,product.getId());
            int count = preparedStatement.executeUpdate();
            if (count != 1)
                throw new SQLException("Updated " + count + " rows");

            preparedStatement.close();
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

    public void createProduct(Product product) throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PRODUCT);
            pstmt.setString(1,product.getName());
            pstmt.setString(2,product.getDescription());
            pstmt.setLong(3,product.getPrice());
            pstmt.setString(4,product.getImage_url());
            pstmt.setLong(5,product.getUserId());

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

    public List<Product> getSearchedProducts(String productName) throws SQLException, IOException{
        List<Product> products =new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(SELECT_SEARCHED_PRODUCT);
            String newWord = "'%";
            newWord+=productName;
            newWord+="%'";
            System.out.println(newWord);
            pstmt.setString(1, productName);
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

    }public void deleteProduct(long productId)throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setLong(1,productId);


            int rows = preparedStatement.executeUpdate();
            preparedStatement.close();
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
