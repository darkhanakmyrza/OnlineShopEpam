package com.epam.onlineShop.database.dao.interfaces;

import com.epam.onlineShop.entity.Address;
import com.epam.onlineShop.entity.OrderItem;

import java.io.IOException;
import java.sql.SQLException;

public interface AddressDao {
    void createAddress(Address address)throws SQLException, IOException;
    Long takeLastID() throws SQLException;
    void deleteAddressById(Long addressId) throws SQLException, IOException;
}
