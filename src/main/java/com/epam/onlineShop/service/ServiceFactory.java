package com.epam.onlineShop.service;

import java.util.HashMap;
import java.util.Map;

public class ServiceFactory {

    private static final Map<String, Service> SERVICE_MAP = new HashMap<>();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();

    static {
        SERVICE_MAP.put("/registration", new RegistrationUserService()) ;
        SERVICE_MAP.put("/login", new LoginUserService());
        SERVICE_MAP.put("/home", new GetAllProductsService());
        SERVICE_MAP.put("/product", new GetOneProductService());


    }

    public Service getService(String request) {
        Service service = SERVICE_MAP.get("/error");

        for (Map.Entry<String, Service> pair : SERVICE_MAP.entrySet()) {
            if (request.equalsIgnoreCase(pair.getKey())) {
                service = SERVICE_MAP.get(pair.getKey());
            }
        }
        return service;
    }

    public static ServiceFactory getInstance() {
        return SERVICE_FACTORY;
    }

}
