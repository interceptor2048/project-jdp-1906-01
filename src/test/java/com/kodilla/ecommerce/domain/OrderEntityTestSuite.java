package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.OrderEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Test
    public void testAddingSingleOrderToOrderEntity() {
        //given
        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        UserEntity user = new UserEntity("name", false);
        user.getOrders().add(order1);
        user.getOrders().add(order2);
        order1.setUser(user);
        order2.setUser(user);

        //when
        userEntityRepository.save(user);
        orderEntityRepository.save(order1);
        long id1 = order1.getId();
        long userId = user.getId();

        //then
        assertNotEquals(0L, id1);
        assertNotEquals(0L, userId);
    }

    @Test
    public void testAddingProductsToOrderEntity(){
        //given
        OrderEntity order = new OrderEntity();
        UserEntity user = new UserEntity("Rafał Kowalski", false);
        user.getOrders().add(order);
        order.setUser(user);

        ProductEntity product1 = new ProductEntity("product3", "description3", 1.50);
        ProductEntity product2 = new ProductEntity("product4", "description4", 9.00);

        OrderProduct orderProduct1 = new OrderProduct(order, product1, 4);
        OrderProduct orderProduct2 = new OrderProduct(order, product2, 1);

        product1.getOrders().add(orderProduct1);
        product2.getOrders().add(orderProduct2);

        order.getProducts().add(orderProduct1);
        order.getProducts().add(orderProduct2);

        //when
        userEntityRepository.save(user);
        orderEntityRepository.save(order);
        long id = orderProduct1.getId();
        long orderId = order.getId();
        long product1Id = product1.getId();

        //then
        assertNotEquals(0L, id);
        assertNotEquals(0L, orderId);
        assertNotEquals(0L, product1Id);
    }
}