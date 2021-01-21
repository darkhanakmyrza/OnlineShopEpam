package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import static com.epam.onlineShop.util.constants.ConstantNames.*;

public class UserFactory {
    private static UserFactory instance = new UserFactory();

    public User fillUser(HttpServletRequest request, boolean admin) {
        User newUser = new User();
        newUser.setFirstName(request.getParameter("firstName"));
        newUser.setLastName(request.getParameter("lastName"));
        newUser.setEmail(request.getParameter("email"));
        String password = request.getParameter("password");
        String securedPassword = DigestUtils.md5Hex(password);
        newUser.setPassword(securedPassword);
        newUser.setAdmin(admin);
        newUser.setActive(true);
        return newUser;
    }

    public static UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }
}
