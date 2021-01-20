package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDaoImpl extends ConnectionPool implements UserDao{
    private static final String INSERT_INTO_USERS = "INSERT USER(first_name, last_name, email, password, admin, active) VALUES" +
            "(?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN_PASSWORD = "SELECT id, first_name, last_name, email, password, admin, active FROM" +
            " USER WHERE email = ? AND password = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM USER WHERE admin = 0";
    private static final String UPDATE_USER_ACTIVITY = "UPDATE USER SET  active = ? WHERE id = ?";

    public UserDaoImpl()  {
    }


    public void addUser(User user) throws SQLException, IOException {
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_INTO_USERS);

            pstmt.setString(1, user.getFirstName());
            pstmt.setString(2, user.getLastName());
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getPassword());
            pstmt.setBoolean(5, user.isAdmin());
            pstmt.setBoolean(6, user.isActive());
            int count = pstmt.executeUpdate();
            if (count != 1)
                throw new SQLException("Insert updated " + count + " rows");

            pstmt.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) { /* ignore */
            }
            System.out.println(e);
        }
    }

    public User getUserByLoginPassword(String login, String password) throws SQLException, IOException {
        User user = null;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_USER_BY_LOGIN_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("admin"));
                user.setActive(resultSet.getBoolean("active"));
            }

            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        }
        return user;
    }
    public List<User> getUsers() throws SQLException, IOException{
        List<User> users = new ArrayList<>();
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(GET_ALL_USERS);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFirstName(resultSet.getString("first_name"));
                user.setLastName(resultSet.getString("last_name"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setAdmin(resultSet.getBoolean("admin"));
                user.setActive(resultSet.getBoolean("active"));
                users.add(user);
            }

            resultSet.close();
            preparedStatement.close();
            releaseConnection(con);

        } catch (Exception e) {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e2) {
            }
            System.out.println(e);
        }
        return users;

    }public void ActivateUser(long userId,boolean isActive) throws SQLException, IOException{
        Connection con = null;
        try{
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(UPDATE_USER_ACTIVITY);

            preparedStatement.setBoolean(1,isActive);
            preparedStatement.setLong(2,userId);

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

}