package com.epam.onlineShop.database.connection;

import com.sun.deploy.util.OrderedHashSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool{
    private List<Connection> connectionPool = new ArrayList<>();

    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
    private String jdbcURL = "jdbc:mysql://localhost:3306/onlineshopepam?serverTimezone=UTC";



    protected synchronized Connection getConnection() throws MyDAOException {

        if (connectionPool.size() > 0) {
            return connectionPool.remove(connectionPool.size() - 1);
        }

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException e) {
            throw new MyDAOException(e);
        }

        try {
            return DriverManager.getConnection(jdbcURL);
        } catch (SQLException e) {
            throw new MyDAOException(e);
        }
    }

    protected synchronized void releaseConnection(Connection con) {
        connectionPool.add(con);
    }
}