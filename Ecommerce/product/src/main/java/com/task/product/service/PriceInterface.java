package com.task.product.service;

import java.util.List;
import java.util.Optional;

import com.task.product.entities.Product;

public interface PriceInterface {
    public List<Product> fetchAllProducts();

    public Optional<Product> fetchByProductId(Product productId);
    
    public String addProduct(Product ProductObj);

    //UPDATE
    public Product updateByproductId(Product obj);

    //DELETE
    public String deleteByProductId(Product productObj);
}
