package com.epam.onlineShop.database.dao.impl;

import com.epam.onlineShop.database.connection.ConnectionPool;
import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.epam.onlineShop.util.constants.ConstantNames.*;


public class UserDaoImpl extends ConnectionPool implements UserDao{
    private final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    private static final String INSERT_INTO_USERS = "INSERT USER(first_name, last_name, email, password, admin, active) VALUES" +
            "(?, ?, ?, ?, ?, ?)";
    private static final String GET_USER_BY_LOGIN_PASSWORD = "SELECT id, first_name, last_name, email, password, admin, active FROM" +
            " USER WHERE email = ? AND password = ?";
    private static final String GET_ALL_USERS = "SELECT * FROM USER WHERE admin = 0";
    private static final String UPDATE_USER_ACTIVITY = "UPDATE USER SET  active = ? WHERE id = ?";
    private static final String CHECK_LOGIN = "SELECT * FROM user WHERE email = ?";

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
            LOGGER.error(e);
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
                user.setId(resultSet.getLong(ID));
                user.setFirstName(resultSet.getString(FIRST_NAME_TABLE));
                user.setLastName(resultSet.getString(LAST_NAME_TABLE));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setAdmin(resultSet.getBoolean(ADMIN));
                user.setActive(resultSet.getBoolean(ACTIVE));
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
            LOGGER.error(e);
        }
        return user;
    }

    public boolean isEmailExist(String email) throws SQLException, IOException {
        boolean isExist = false;
        Connection con = null;
        try {
            con = getConnection();
            PreparedStatement preparedStatement = con.prepareStatement(CHECK_LOGIN);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                isExist = true;
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
            LOGGER.error(e);
        }
        return isExist;
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
                user.setId(resultSet.getLong(ID));
                user.setFirstName(resultSet.getString(FIRST_NAME_TABLE));
                user.setLastName(resultSet.getString(LAST_NAME_TABLE));
                user.setEmail(resultSet.getString(EMAIL));
                user.setPassword(resultSet.getString(PASSWORD));
                user.setAdmin(resultSet.getBoolean(ADMIN));
                user.setActive(resultSet.getBoolean(ACTIVE));
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
            LOGGER.error(e);
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
            LOGGER.error(e);
        }
    }

}