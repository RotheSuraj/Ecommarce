package com.task.product.service;

import java.util.ArrayList;
// import java.util.List;
import java.util.Optional;

// import java.util.List;
// import java.util.Optional;
// import java.util.Optional;

import com.task.product.entities.Cart;





// import com.task.product.entities.Cart;
// import com.task.product.entities.Product;
// import com.task.product.entities.Product;

public interface CartInterface {
    public String addProduct(Cart cartObj);

    public Optional<Cart> fetchproductByCartItemId(String cartItemId);

    public String updateProductByCartItemId(Cart cartObj);

    public String delteProductByCartItemId(String cartItemId);

    public String delteProductByproductId(String productId);

    public ArrayList fetchAllProduct();
}

