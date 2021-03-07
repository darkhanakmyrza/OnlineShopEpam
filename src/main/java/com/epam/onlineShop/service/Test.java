package com.epam.onlineShop.service;

import com.epam.onlineShop.database.dao.impl.AddressDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.AddressDao;

public class Test {
    public static void main(String[] args) {
        AddressDao addressDao = new AddressDaoImpl();
        long a = 21;
        try {
            addressDao.deleteAddressById(a);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
