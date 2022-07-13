package com.task.product.service;




import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.product.entities.Cart;
import com.task.product.entities.Product;
import com.task.product.entities.STATUS;
import com.task.product.repository.CartRepository;
import com.task.product.repository.ProductRepository;

@Service
public class CartImpl implements CartInterface {

    @Autowired
    CartRepository cartrepoObj;
    @Autowired
    ProductRepository proObj;

   
    // public String addProduct(Cart cartObj){

    //     Optional <Product> p1 = proObj.findById(cartObj.getProductId());
    //     if(p1.isPresent()){
            
    //         if(p1.get().getProductStatus() == STATUS.ACTIVE){
    //             cartObj.save(cartObj);
    //             return "Product added succesfully";
    //         }
    //         else{
    //             return "Product Not available";
    //         }
    //     }
    //     else{
    //         return "Product Not exist";
    //     }
       
    // }

    //POST
    public String addProduct(Cart cartObj){
        Optional<Product> p1 =proObj.findById(cartObj.getProductId());
        if(p1.isPresent()){
        if(p1.get().getProductStatus() ==STATUS.ACTIVE){
            //d1.get().setProductStatus(STATUS.INACTIVE);
            cartrepoObj.save(cartObj);
           return "Object added";
        }
        else{
            return "Object does not exists";
        }
        }
        else{
            return "product not found";
        }
    }
    //FindById
    public Optional<Cart> fetchproductByCartItemId(String cartItemId){
        return cartrepoObj.findById(cartItemId);
    }
    //UPDATE
    public String updateProductByCartItemId(Cart cartObj){
       
        if(cartObj.getCartItemId()==null){
            return "Id not found";
        }
        else{
            Optional<Cart> c1 =cartrepoObj.findById(cartObj.cartItemId);
            
            c1.get().setCartItemQty(cartObj.getCartItemQty());
            c1.get().setProductId(cartObj.getProductId());
            cartrepoObj.findById(cartObj.getCartItemId());
            cartObj.save(c1.get());
            return "Cart Updated Successfully ";
        }
    }

    // DELTE BY CART ITEM ID
    public String delteProductByCartItemId(String cartItemId){
        cartrepoObj.deleteById(cartItemId);
        return "Item Deleted Successfully";
    }

    //DELETE BY PRODUCT ID
    public String delteProductByproductId(String productId){
        proObj.deleteById(productId);
        return "Item Deleted Successfully";
    }

    public ArrayList fetchAllProduct(){
        // cartrepoObj.findAll();
        float total=0;
        ArrayList list = new ArrayList<>();
        List<Cart> c1 = cartrepoObj.findAll();
        
        // System.out.println(c1);
        for (int i = 0; i < c1.size(); i++) {
            Optional<Product> c2 = proObj.findById(c1.get(i).getProductId());
            int c3 = c1.get(i).getCartItemQty();
            total = total + (c3*c2.get().getProductPrice());

            list.add(Arrays.asList(c2.get().getProductImage(),c2.get().getProductName(),c2.get().getProductPrice(),c2.get().getProductCategorize(),c2.get().getProductDescription(),c2.get().getProductStatus(),total));  
        }
        return list;
        
    }
}
