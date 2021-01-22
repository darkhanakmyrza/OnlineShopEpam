package com.epam.onlineShop.validator;

import com.epam.onlineShop.entity.User;

import javax.servlet.http.HttpSession;

public class ValidateActiveUser {

    public static boolean checkAccess(User user){
        boolean isAccess = false;
        boolean isActivity = user.isActive();

        if( isActivity == true){
            isAccess =true;
        }

        return isAccess;

    }
}
