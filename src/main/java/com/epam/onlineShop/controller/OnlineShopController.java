package com.epam.onlineShop.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class OnlineShopController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //String requestString = request.getRequestURI();
//        ServiceFactory serviceFactory = ServiceFactory.getInstance();
//        Service service = serviceFactory.getService(requestString);
//        try {
//            service.execute(request, response);
//        } catch (ParseException | SQLException e) {
//            LOGGER.error(e);
//        }

        HttpSession session = request.getSession();
        session.setAttribute("name", "Tom");
        session.setAttribute("age", 34);

        getServletContext().getRequestDispatcher("/a.jsp").forward(request, response);

        //response.sendRedirect("a.jsp");
    }
}
