package com.task.product.service;

import java.util.List;
import java.util.Optional;

// import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.product.entities.Product;
import com.task.product.entities.STATUS;
import com.task.product.repository.ProductRepository;



@Service
public class ProductImpl implements PriceInterface {

    @Autowired
    ProductRepository repoObj;
    // All Products
    public List<Product> fetchAllProducts(){
        return repoObj.findAll();
    }
    // public List<Product> fetchAllProducts(){
       
    //     if()
        
    // }
    // Products By ID
    // public Optional<Product> fetchByProductId(String productId){
    //     return repoObj.findById(productId);
    // }

    // Products By ID
    public Optional<Product> fetchByProductId(Product productId){
        // Optional<Product> ret = repoObj.findById(obj.getProductId());
        // boolean productStatus;
        if(productId.getProductStatus()==STATUS.ACTIVE){
            return repoObj.findById(productId.getProductId()); 
        }
        else{
           return null;
        }
    }

    

    public String addProduct(Product ProductObj){
        repoObj.save(ProductObj);
        return "Saved";
    }

    //UPDATE 
    public Product updateByproductId(Product obj){
            Optional<Product> p1 = repoObj.findById(obj.getProductId());
            p1.get().setProductId(obj.getProductId());
            p1.get().setProductCategorize(obj.getProductCategorize());
            p1.get().setProductDescription(obj.getProductDescription());
            p1.get().setProductImage(obj.getProductImage());
            p1.get().setProductName(obj.getProductName());
            p1.get().setProductPrice(obj.getProductPrice());
            repoObj.save(p1.get());
            return obj;
        }

    //DELETE
    // public Product deleteByProductId(Product obj){
    //     Optional<Product> p1 = repoObj.findById(obj.getProductId() );

    //     if(p1.isPresent()){
    //         p1.get().setProductStatus(obj.getProductStatus());
    //         repoObj.save(p1.get());
    //         return obj;
    //     }
    //     else{
    //         return null;
    //     }
        
    // }

    public String deleteByProductId(Product productObj){
        if(productObj.getProductId() == null) {
            return "Enter a Valid Id";
        }
        else{
            Optional<Product> d1 =repoObj.findById(productObj.getProductId());
            if(d1.get().getProductStatus() ==STATUS.ACTIVE){
                d1.get().setProductStatus(STATUS.INACTIVE);
                repoObj.save(d1.get());
                return "Product Deleted Successfully";
             
            }
            else{
                return "Product does not exists";
            }
        }

   
    }    
}
