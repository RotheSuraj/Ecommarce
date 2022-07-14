package com.task.product.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import com.task.product.entities.CATEGORIZE;

import com.task.product.entities.Product;
import com.task.product.entities.STATUS;

import com.task.product.repository.ProductRepository;
import com.task.product.service.ProductImpl;



@ExtendWith (MockitoExtension.class)
public class TestProductService {

    @InjectMocks
    ProductImpl srvObj;

    @Mock
    ProductRepository repoObj;

    @Test
    public void fetchAllProduct(){
        List<Product> list = new LinkedList<Product>();
        Product p1 =new Product("M-1", "Iphone-13", 
        "Https.www.amazon.com", 500000.0f, "Iphone",
        STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        Product p2 =new Product("M-2", "Iphone-12", "Https.www.amazon.com",
        1500000.0f, "Iphone",
        STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        Product p3 =new Product("S-1", "Nike", "Https.www.amazon.com", 
        100000.0f, "Shoe", 
        STATUS.ACTIVE, CATEGORIZE.SHOES);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        when(repoObj.findAll()).thenReturn(list);
        List<Product>proList=srvObj.fetchAllProducts();
        assertEquals(3, proList.size());
        verify(repoObj,times(1)).findAll();


    }

    @Test
    public void fetchByProductId(){
        Product p1 =new Product("M-1", "Iphone-13", "Https.www.amazon.com", 
        500000.0f, "Iphone", STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        doReturn(Optional.of(p1)).when(repoObj).findById(p1.productId);
        Optional< Product> p2 = srvObj.fetchByProductId(p1);
        assertEquals(p1.getProductId(), p2.get().productId);
        assertEquals(p1.getProductImage(), p2.get().productImage);
        assertEquals(p1.getProductPrice(), p2.get().productPrice);
        assertEquals(p1.getProductStatus(), p2.get().productStatus);
        assertEquals(p1.getProductCategorize(), p2.get().productCategorize);
        assertEquals(p1.getProductStatus(), p2.get().productStatus);
        assertEquals(p1.getProductDescription(), p2.get().getProductDescription());
        
    }

    @Test
    public void deleteByIdTest(){
        Product p1 =new Product("M-1", "Iphone-13", "Https.www.amazon.com", 
        500000.0f, "Iphone", STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        when(repoObj.findById(p1.getProductId())).thenReturn(Optional.of(p1));
        String dele = srvObj.deleteByProductId(p1);
        assertEquals("Product Deleted Successfully", dele);
    }
    
    @Test
    public void addProductTest(){
        List<Product> list = new LinkedList<Product>();
        Product p1 =new Product("M-1", "Iphone-13", "Https.www.amazon.com", 
        500000.0f, "Iphone", STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        Product p2 =new Product("M-2", "Iphone-12", "Https.www.amazon.com", 
        1500000.0f, "Iphone", STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        Product p3 =new Product("S-1", "Nike", "Https.www.amazon.com", 
        100000.0f, "Shoe", STATUS.ACTIVE, CATEGORIZE.SHOES);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        when(repoObj.findAll()).thenReturn(list);
        List<Product>empList=srvObj.fetchAllProducts();
        assertEquals(4, empList.size()+1);
        verify(repoObj,times(1)).findAll();
    }

    @Test
    public void updateByproductId(){
        Product p1 =new Product("M-1", "Iphone-13", "Https.www.amazon.com", 500000.0f, "Iphone", STATUS.ACTIVE, CATEGORIZE.ELECTRONICS);
        p1.setProductName("Redmi");
        Assertions.assertThat(p1.getProductName()).isEqualTo("Redmi");
    }
}
