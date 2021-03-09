package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantNames.*;
import static com.epam.onlineShop.util.constants.ConstantPageNames.*;
public class UserFactory {
    private static UserFactory instance = new UserFactory();

    public User fillUser(HttpServletRequest request, boolean admin) {
        User newUser = new User();
        newUser.setFirstName(request.getParameter(FIRST_NAME));
        newUser.setLastName(request.getParameter(LAST_NAME));
        newUser.setEmail(request.getParameter(EMAIL));
        String password = request.getParameter(PASSWORD);
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
