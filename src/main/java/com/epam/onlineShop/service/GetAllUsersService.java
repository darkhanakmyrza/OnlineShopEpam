package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;


public class GetAllUsersService implements Service {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        User currentUser = (User)session.getAttribute(USER);
        if(currentUser.isAdmin()){
            List<User> users = userDao.getUsers();
            request.setAttribute(USERS, users);

            dispatcher = request.getRequestDispatcher(ALL_USERS_JSP);
            dispatcher.forward(request, response);

        }else {
            response.sendRedirect(LOGIN_SERVICE);
        }
    }
}
