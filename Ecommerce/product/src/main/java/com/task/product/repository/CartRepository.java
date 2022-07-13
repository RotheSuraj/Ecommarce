package com.task.product.repository;

import javax.transaction.TransactionScoped;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.product.entities.Cart;
import com.task.product.entities.Product;
@Repository
@TransactionScoped
public interface CartRepository extends JpaRepository<Cart ,String> {

    void save(Product obj);
    
}
