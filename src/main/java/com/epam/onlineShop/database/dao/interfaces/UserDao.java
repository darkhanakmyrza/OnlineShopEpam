package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.database.connection.DaoException;
import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.entity.User;

import java.io.IOException;
import java.sql.SQLException;

public interface UserDao {
    void addUser(User user) throws MyDAOException;

    User getUserByLoginPassword(String login,String password) throws SQLException, IOException;
}
