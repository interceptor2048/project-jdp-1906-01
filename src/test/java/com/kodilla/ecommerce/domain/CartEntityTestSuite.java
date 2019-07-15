package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.CartEntityRepository;
import com.kodilla.ecommerce.repository.CartProductRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CartEntityTestSuite {

    @Autowired
    private CartEntityRepository cartEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private CartProductRepository cartProductRepository;


    @Test
    public void testAddingCart() {
        //Given
        CartEntity cart = new CartEntity();
        //When
        cartEntityRepository.save(cart);
        long id = cart.getId();
        //Then
        assertNotEquals(0L, id);
    }

    @Test
    public void testFindCartByUserName() {
        //Given
        CartEntity cart = new CartEntity();
        UserEntity user = new UserEntity("Test", false);
        cart.setUser(user);
        //When
        userEntityRepository.save(user);
        cartEntityRepository.save(cart);
        String userName = cart.getUser().getUserName();
        //Then
        assertEquals("Test", userName);
    }

    @Test
    public void testAddingProductToCart() {
        //Given
        CartEntity cart = new CartEntity();
        UserEntity user = new UserEntity("Test", false);

        cart.setUser(user);

        ProductEntity product = new ProductEntity("Product", "Description", 2.50);
        CartProduct cartProduct = new CartProduct(cart, product, 2);

        product.getProductsInCart().add(cartProduct);
        cart.getProducts().add(cartProduct);
        //When
        userEntityRepository.save(user);
        cartEntityRepository.save(cart);
        cartProductRepository.save(cartProduct);
        long id1 = cartProduct.getId();
        //Then
        assertNotEquals(0L, id1);
    }
}
