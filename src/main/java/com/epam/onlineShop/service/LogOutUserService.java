package com.epam.onlineShop.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;

public class LogOutUserService implements Service{


    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException, SQLException {
        HttpSession session = request.getSession();
        session.setAttribute(USER, null);

        response.sendRedirect(LOGIN_JSP);
    }
}
