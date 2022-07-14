package com.task.product.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.task.product.entities.Product;
import com.task.product.entities.STATUS;
import com.task.product.repository.ProductRepository;

@Service
public class ProductImpl implements PriceInterface {

    @Autowired
    ProductRepository repoObj;

    public List<Product> fetchAllProducts(){
        return repoObj.findAll();
    }

    public Optional<Product> fetchByProductId(Product productId){
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
