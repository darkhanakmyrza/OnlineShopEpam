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

public class RegistrationUserService implements Service{

    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    public RegistrationUserService()  {
    }


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();

        User newUser =new User();
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setEmail(request.getParameter("email"));
        newUser.setPassword(request.getParameter("password"));
        newUser.setAdmin(false);

        try{
            userDao.addUser(newUser);
        }catch (Exception e){
            System.out.println(e);
        }
        newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());

        session.setAttribute("user", newUser);
        session.setAttribute("admin",newUser.isAdmin());

        serviceFactory.getService("/home").execute(request,response);


    }
}
