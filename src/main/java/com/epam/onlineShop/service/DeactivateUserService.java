package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.UserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class DeactivateUserService implements Service{
    UserDao userDao = new UserDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        long userId = Long.valueOf(request.getParameter(USER_ID));
        userDao.ActivateUser(userId, false);

        response.sendRedirect(ALL_USERS_SERVICE);
    }
}
