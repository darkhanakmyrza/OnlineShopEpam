package com.epam.onlineShop.database.dao.interfaces;

import java.io.IOException;
import java.sql.SQLException;

public interface CartDao {
    void addProductToCart(Long productId, Long userId)throws SQLException, IOException;
}
