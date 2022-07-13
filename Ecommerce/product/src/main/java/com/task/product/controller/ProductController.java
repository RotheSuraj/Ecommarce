package com.task.product.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.task.product.entities.Product;
import com.task.product.service.ProductImpl;
// import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class ProductController {

    @Autowired
    private ProductImpl srv;
    //ALL PRODUCTS
    @GetMapping (value = "/api/product")
    public List<Product> fetchAllProducts(){
        return srv.fetchAllProducts();
    }
    //PRODUCT BY ID
    @GetMapping (value = "/api/product/{id}")
    public Optional<Product> fetchByProductId(@PathVariable("id") Product  productId){
        return srv.fetchByProductId(productId);
    }
    //Add PRODUCT
    @PostMapping (value ="/api/product")
    public String addProduct(@RequestBody Product obj){
        return srv.addProduct(obj);
    }
    //UPDATE
    @PutMapping (value ="/api/product")
    public Product updateByproductId(@RequestBody Product obj){
        return srv.updateByproductId(obj);
    }

    //DELETE
    @DeleteMapping(value = "/api/product/{id}")
    public String deleteByProductId(@PathVariable ("id") Product productId){
        return srv.deleteByProductId(productId);
    }
    
    

}
