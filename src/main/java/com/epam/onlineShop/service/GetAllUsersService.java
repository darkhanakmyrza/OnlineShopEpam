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

public class GetAllUsersService implements Service {
    UserDao userDao = new UserDaoImpl();
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        User currentUser = (User)session.getAttribute("user");
        if(currentUser.isAdmin()){
            List<User> users = userDao.getUsers();
            request.setAttribute("users", users);

            dispatcher = request.getRequestDispatcher("all_users.jsp");
            dispatcher.forward(request, response);

        }else {
            response.sendRedirect("login");
        }
    }
}
