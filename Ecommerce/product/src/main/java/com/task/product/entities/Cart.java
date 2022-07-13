package com.task.product.entities;

// import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;


@Entity(name = "cart")
public class Cart {
@Id
@GeneratedValue(generator = "system-uuid")
@GenericGenerator(name="system-uuid", strategy = "uuid")
public String cartItemId;
public int cartItemQty;

@Column(name = "productId",nullable = false,insertable = true,updatable = true)

public String productId;

    public Cart(String cartItemId, int cartItemQty, String productId) {
        this.cartItemId = cartItemId;
        this.cartItemQty = cartItemQty;
        this.productId = productId;
    }

    public Cart() {

    }

    public String getCartItemId() {
        return this.cartItemId;
    }

    public void setCartItemId(String cartItemId) {
        this.cartItemId = cartItemId;
    }

    public int getCartItemQty() {
        return this.cartItemQty;
    }

    public void setCartItemQty(int cartItemQty) {
        this.cartItemQty = cartItemQty;
    }

    public String getProductId() {
        return this.productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public String toString() {
        return "{" +
            " cartItemId='" + getCartItemId() + "'" +
            ", cartItemQty='" + getCartItemQty() + "'" +
            ", productId='" + getProductId() + "'" +
            "}";
    }

    public void save(Cart cartObj) {
    }





}


