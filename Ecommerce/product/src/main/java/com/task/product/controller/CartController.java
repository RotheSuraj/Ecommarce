package com.task.product.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.task.product.entities.Cart;

import com.task.product.service.CartImpl;



// import antlr.collections.List;

@RestController
public class CartController {

    @Autowired
    private CartImpl cImpl;

    @PostMapping (value = "/api/cart")
    public String addProduct(@RequestBody Cart cartobj){
        return cImpl.addProduct(cartobj);
    }

    @GetMapping(value="/api/cart/{cartItemId}")
    public Optional<Cart> fetchByCartItemId(@PathVariable("cartItemId") String cartItemId){
        return cImpl.fetchproductByCartItemId(cartItemId);
    }
    @PutMapping(value = "api/cart")
    public String updateProductByCartItemId(@RequestBody Cart cartObj){
        return cImpl.updateProductByCartItemId(cartObj);
    }

    @DeleteMapping(value = "api/cart/{cartItemId}")
    public String delteProductByCartItemId(@PathVariable ("cartItemId") String cartItemId){
        return cImpl.delteProductByCartItemId(cartItemId);
    }

    @DeleteMapping(value = "api/cart/{productId}")
    public String delteProductByproductId(@PathVariable ("productId") String productId){
        return cImpl.delteProductByCartItemId(productId);
    }

    @GetMapping(value="/api/cart")
    public ArrayList fetchAllProduct() {
        return cImpl.fetchAllProduct();
    }
    
}

