package com.epam.onlineShop.controller;

import com.epam.onlineShop.database.connection.MyDAOException;
import com.epam.onlineShop.service.RegistrationUserService;
import com.epam.onlineShop.service.Service;
import com.epam.onlineShop.service.ServiceFactory;

import javax.servlet.Registration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;


public class OnlineShopController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Service service = serviceFactory.getService(path);
        try {
            service.execute(request, response);
        } catch (ParseException | SQLException e) {
            System.out.println(e);
        }




        //response.sendRedirect("a.jsp");
    }
}
