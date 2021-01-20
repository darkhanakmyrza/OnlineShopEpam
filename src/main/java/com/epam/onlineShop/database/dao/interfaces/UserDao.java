package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.entity.User;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UserDao {
    void addUser(User user) throws SQLException, IOException;
    List<User> getUsers() throws SQLException, IOException;
    User getUserByLoginPassword(String login,String password) throws SQLException, IOException;
    void ActivateUser(long userId, boolean isActive) throws SQLException, IOException;

}
