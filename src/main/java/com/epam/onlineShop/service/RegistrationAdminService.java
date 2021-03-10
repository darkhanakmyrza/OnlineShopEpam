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

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantNames.ERROR;
import static com.epam.onlineShop.util.constants.ConstantPageNames.HOME_SERVICE;
import static com.epam.onlineShop.util.constants.ConstantPageNames.REGISTRATION_JSP;
import static com.epam.onlineShop.validator.ValidateRegistration.validateMailWithRegex;
import static com.epam.onlineShop.validator.ValidateRegistration.validatePasswordWithRegex;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

import static com.epam.onlineShop.validator.ValidateActiveUser.checkAccess;

public class RegistrationAdminService implements Service {
    private UserFactory userFactory = UserFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        RequestDispatcher dispatcher;

        if(request.getParameter(EMAIL) != null) {
            String email = request.getParameter(EMAIL) ;
            if(userDao.isEmailExist(email)){

                request.setAttribute(ERROR, ERROR_EMAIL_EXIST);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else if(!validateMailWithRegex(email)) {
                request.setAttribute(ERROR, ERROR_EMAIL_FORMAT);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else if(!validatePasswordWithRegex(request.getParameter(PASSWORD))){
                request.setAttribute(ERROR, ERROR_PASSWORD_FORMAT);
                dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
                dispatcher.forward(request, response);
            }else{
                User newUser = userFactory.fillUser(request,true);
                userDao.addUser(newUser);
                newUser.setId(userDao.getUserByLoginPassword(newUser.getEmail(), newUser.getPassword()).getId());
                session.setAttribute(USER, newUser);
                session.setAttribute(ADMIN, newUser.isAdmin());
                response.sendRedirect(HOME_SERVICE);
            }

        }else{
            dispatcher = request.getRequestDispatcher(REGISTRATION_JSP);
            dispatcher.forward(request, response);
        }
    }
}
