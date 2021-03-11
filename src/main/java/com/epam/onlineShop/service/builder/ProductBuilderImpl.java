package com.epam.onlineShop.service.builder;

import com.epam.onlineShop.entity.Product;
import com.epam.onlineShop.service.builder.ProductBuilder;

public class ProductBuilderImpl implements ProductBuilder {
    Product product = new Product();
    public ProductBuilder setId(long id) {
        product.setId(id);
        return this;
    }
    public ProductBuilder setName(String name) {
        product.setName(name);
        return this;
    }

    public ProductBuilder setDescription(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductBuilder setPrice(long price) {
        product.setPrice(price);
        return this;
    }

    public ProductBuilder setImage_url(String image_url) {
        product.setImage_url(image_url);
        return this;
    }

    public ProductBuilder setUserId(long userId) {
        product.setUserId(userId);
        return this;
    }

    @Override
    public Product build() {
        return product;
    }

}
