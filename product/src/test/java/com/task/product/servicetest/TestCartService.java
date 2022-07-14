package com.task.product.servicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.hamcrest.core.IsEqual;
// import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.task.product.entities.Cart;
import com.task.product.repository.CartRepository;
import com.task.product.repository.ProductRepository;
import com.task.product.service.CartImpl;





@ExtendWith(MockitoExtension.class)
public class TestCartService {
    @InjectMocks
    CartImpl cartImpl;

    @Mock
    CartRepository cartrepoObj;

    ProductRepository repoObj;

    @Test
    public void fetchproductByCartItemIdTest(){
        Cart c1 = new Cart("C-1", 2, "M-2");
        doReturn(Optional.of(c1)).when(cartrepoObj).findById(c1.cartItemId);
        Optional<Cart>c2 = cartImpl.fetchproductByCartItemId(c1.getCartItemId());
        assertEquals(c1.getCartItemId(), c2.get().getCartItemId());
        assertEquals(c1.getCartItemQty(), c2.get().getCartItemQty());
        assertEquals(c1.getProductId(), c2.get().productId);
    }

    @Test
    public void addProduct(){
        Cart c1 = new Cart("C-1", 2, "M-2");
        cartrepoObj.save(c1);
        verify(cartrepoObj,times(1)).save(c1);

        
        
    }

    @Test
    public void updateProductByCartItemIdTest(){
        Cart c1 = new Cart("C-1", 2, "M-2");
        c1.setCartItemQty(1);
        Assertions.assertThat(c1.getCartItemQty()).isEqualTo(1);
    }

    @Test
    public void delteProductByCartItemId(){
        // Cart c1 = new Cart("C-1", 2, "M-2");
        
        String dele = cartImpl.delteProductByCartItemId("C-1");
        assertEquals("Item Deleted Successfully", dele);
    }

    // @Test
    // public void fetchAllProductTest(){
    //     List<Cart> ar = new ArrayList<>();
    //     Cart c1 = new Cart("C-1", 2, "M-2");
    //     Cart c2 = new Cart("C-2", 1, "M-3");
    //     ar.add(c1);
    //     ar.add(c2);
    //     when(repoObj.findAll()).thenReturn(ar);
    //     List<Cart> cartList= cartImpl.fetchAllProduct();
    //     assertEquals(2, cartList.size());
    // }
}
