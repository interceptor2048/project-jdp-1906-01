package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.CartProductRepository;
import com.kodilla.ecommerce.repository.OrderProductEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserEntityTestSuite {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private OrderProductEntityRepository orderProductEntityRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    @Test
    public void testAddingSingleUserToUserEntity(){
        //given
        UserEntity user = new UserEntity("name", false);

        //when
        userEntityRepository.save(user);
        long id = user.getId();

        //then
        assertNotEquals(0L, id);
    }

    @Test
    public void testAddingOrderToEntity(){
        //given
        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        UserEntity user = new UserEntity("name", false);
        user.getOrders().add(order1);
        user.getOrders().add(order2);
        order1.setUser(user);
        order2.setUser(user);

        ProductEntity product1 = new ProductEntity("product1", "description1", 2.50);
        ProductEntity product2 = new ProductEntity("product2", "description2", 5.50);

        OrderProduct orderProduct1 = new OrderProduct(order1, product1, 3);
        OrderProduct orderProduct2 = new OrderProduct(order1, product2, 1);

        product1.getOrders().add(orderProduct1);
        product2.getOrders().add(orderProduct2);
        order1.getProducts().add(orderProduct1);
        order1.getProducts().add(orderProduct2);

        //when
        userEntityRepository.save(user);
        orderProductEntityRepository.save(orderProduct1);
        long id1 = orderProduct1.getId();
        long id2 = orderProduct2.getId();
        boolean whetherOrderProduct2Exists = orderProductEntityRepository.findById(id2).isPresent();

        //then
        assertNotEquals(0L, id1);
        assertNotEquals(0L, id2);
        assertTrue(whetherOrderProduct2Exists);
    }

    @Test
    public void testAddingCartToEntity(){
        //given
        CartEntity cart1 = new CartEntity();
        CartEntity cart2 = new CartEntity();
        UserEntity user = new UserEntity("name", false);
        cart1.setUser(user);
        cart2.setUser(user);

        ProductEntity product1 = new ProductEntity("product1", "description1", 2.50);
        ProductEntity product2 = new ProductEntity("product2", "description2", 5.50);

        CartProduct cartProduct1 = new CartProduct(cart1, product1, 3);
        CartProduct cartProduct2 = new CartProduct(cart1, product2, 1);

        product1.getProductsInCart().add(cartProduct1);
        product2.getProductsInCart().add(cartProduct2);
        cart1.getProducts().add(cartProduct1);
        cart1.getProducts().add(cartProduct2);

        //when
        userEntityRepository.save(user);
        cartProductRepository.save(cartProduct1);
        long id1 = cartProduct1.getId();
        long id2 = cartProduct2.getId();
        boolean whetherOrderProduct2Exists = orderProductEntityRepository.findById(id2).isPresent();

        //then
        assertNotEquals(0L, id1);
        assertNotEquals(0L, id2);
        assertTrue(whetherOrderProduct2Exists);
    }
}
