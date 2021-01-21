package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;
import com.epam.onlineShop.service.factory.UserFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.onlineShop.util.constants.ConstantNames.ADMIN;
import static com.epam.onlineShop.util.constants.ConstantNames.USER;

public class RegistrationAdminService implements Service {
    private UserFactory userFactory = UserFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;
        String email = request.getParameter("email");



        if(email != null) {
            User newUser = userFactory.fillUser(request,true);
            userDao.addUser(newUser);

            newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());

            session.setAttribute(USER, newUser);
            session.setAttribute(ADMIN, newUser.isAdmin());

            response.sendRedirect("home");
        }else{
            dispatcher = request.getRequestDispatcher("registrationAdmin.jsp");
            dispatcher.forward(request, response);
        }
    }
}
