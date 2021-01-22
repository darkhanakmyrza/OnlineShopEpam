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
import static com.epam.onlineShop.validator.ValidateRegistration.*;

import static com.epam.onlineShop.util.constants.ConstantNames.ADMIN;
import static com.epam.onlineShop.util.constants.ConstantNames.USER;

public class RegistrationUserService implements Service{
    private UserFactory userFactory = UserFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;



        if(request.getParameter("email") != null) {
            String email = request.getParameter("email") ;
            if(userDao.isEmailExist(email)){
                System.out.println("r1");
                request.setAttribute("error", "Email already exist");
                dispatcher = request.getRequestDispatcher("registration.jsp");

                dispatcher.forward(request, response);
            }else if(!validateMailWithRegex(email)) {
                System.out.println("r2");
                request.setAttribute("error", "Not correct format of mail, please type it again");
                dispatcher = request.getRequestDispatcher("registration.jsp");
                dispatcher.forward(request, response);
            }else if(!validatePasswordWithRegex(request.getParameter("password"))){
                System.out.println("r3");
                request.setAttribute("error", "Not correct format of password, please type it again");
                dispatcher = request.getRequestDispatcher("registration.jsp");
                dispatcher.forward(request, response);
            }else{
                User newUser = userFactory.fillUser(request,false);
                userDao.addUser(newUser);
                newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());
                session.setAttribute(USER, newUser);
                session.setAttribute(ADMIN, newUser.isAdmin());
                response.sendRedirect("home");
            }

        }else{
            dispatcher = request.getRequestDispatcher("registration.jsp");
            dispatcher.forward(request, response);
        }
    }
}
