package com.epam.onlineShop.service.builder;

import com.epam.onlineShop.entity.Product;

public interface ProductBuilder {
    public ProductBuilder setId(long id);
    public ProductBuilder setName(String name);
    public ProductBuilder setDescription(String description);
    public ProductBuilder setPrice(long price);
    public ProductBuilder setImage_url(String image_url);
    public ProductBuilder setUserId(long userId);
    public Product build();

}
