package com.epam.onlineShop.service;

import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.database.dao.impl.UserDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.UserDao;
import com.epam.onlineShop.entity.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.DigestUtils;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.onlineShop.validator.ValidateActiveUser.checkAccess;

public class LoginUserService implements Service {

    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private UserDao userDao = new UserDaoImpl();


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        RequestDispatcher dispatcher;
        HttpSession session = request.getSession();


        String login = request.getParameter("email");
        String password = request.getParameter("password");

        if (login != null && password != null) {
            String securedPassword = DigestUtils.md5Hex(password);
            User user = userDao.getUserByLoginPassword(login, securedPassword);

            if (user != null) {
                if(checkAccess(user)) {
                    session.setAttribute("user", user);
                    session.setAttribute("admin", user.isAdmin());
                    serviceFactory.getService("/home").execute(request, response);
                }else{
                    request.setAttribute("error", "You are blocked");
                    dispatcher = request.getRequestDispatcher("login.jsp");
                    dispatcher.forward(request, response);

                }
            } else {
                request.setAttribute("error", "Email or password is wrong");
                dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            }

        } else {
            dispatcher = request.getRequestDispatcher("login.jsp");
            dispatcher.forward(request, response);
        }
    }
}
