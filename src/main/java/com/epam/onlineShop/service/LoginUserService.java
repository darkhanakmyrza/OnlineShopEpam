package com.epam.onlineShop.service;

import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class LoginUserService implements Service {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {

        HttpSession session = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");


        User user = userDao.getUserByLoginPassword(login, password);

        if (user != null) {

            session.setAttribute("user", user);
            session.setAttribute("admin", user.isAdmin());


            serviceFactory.getService("/home").execute(request,response);

        }else{
            response.sendRedirect("login.jsp");
        }
    }
}
