package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.database.dao.impl.AddressDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.AddressDao;
import com.epam.onlineShop.entity.Address;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;

import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantNames.PHONE;

public class AddressFactory {
    public static AddressFactory instance = new AddressFactory();
    AddressDao addressDao = new AddressDaoImpl();

    public Address fillAddress(HttpServletRequest request)throws ServletException, IOException, SQLException {
        Address address = new Address();
        address.setCountry(request.getParameter(COUNTRY));
        address.setCity(request.getParameter(CITY));
        address.setStreet(request.getParameter(STREET));
        address.setPhone(request.getParameter(PHONE));
        address.setId(addressDao.takeLastID() + 1);
        return address;
    }

    public static AddressFactory getInstance() {
        if (instance == null) {
            instance = new AddressFactory();
        }
        return instance;
    }
}
