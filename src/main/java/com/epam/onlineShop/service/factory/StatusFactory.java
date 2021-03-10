package com.epam.onlineShop.service.factory;

import com.epam.onlineShop.database.dao.impl.StatusDaoImpl;
import com.epam.onlineShop.database.dao.interfaces.StatusDao;
import com.epam.onlineShop.entity.Status;

import javax.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.sql.SQLException;

import static com.epam.onlineShop.util.constants.ConstantNames.STATUS_PENDING;

public class StatusFactory {
    public static StatusFactory instance = new StatusFactory();
    StatusDao statusDao = new StatusDaoImpl();

    public Status fillStatus(HttpServletRequest request) throws IOException, SQLException {
        Status status = new Status();
        status.setId(statusDao.getIdByStatusName(STATUS_PENDING));
        status.setStatusName(STATUS_PENDING);
        return status;
    }

    public static StatusFactory getInstance() {
        if (instance == null) {
            instance = new StatusFactory();
        }
        return instance;
    }
}
