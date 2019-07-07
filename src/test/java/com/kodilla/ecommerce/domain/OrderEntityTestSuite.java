package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.OrderEntityRepository;
import com.kodilla.ecommerce.repository.OrderProductEntityRepository;
import com.kodilla.ecommerce.repository.ProductEntityRepository;
import org.h2.tools.Server;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.SQLException;

import static org.junit.Assert.*;

//@RunWith(SpringRunner.class)
////@SpringBootTest
//@DataJpaTest
//@AutoConfigureTestDatabase
//public class OrderEntityTestSuite {
//
//    @Autowired
//    private TestEntityManager testEntityManager;
//
//    @Autowired
//    private OrderEntityRepository orderEntityRepository;
//
//    @Autowired
//    private OrderProductEntityRepository orderProductEntityRepository;
//
//    @Test
//    public void testAddingSingleOrderToOrderEntity(){
//        //given
//        OrderEntity order1 = new OrderEntity();
//        OrderEntity order2 = new OrderEntity();
//        UserEntity user = new UserEntity("name", false);
//        user.getOrders().add(order1);
//        user.getOrders().add(order2);
//        order1.setUser(user);
//        order2.setUser(user);
//
//        //when
//        OrderEntity saveInDB = testEntityManager.persist(order1);
//        OrderEntity getFromDB = orderEntityRepository.save(saveInDB);
//        Long id = order1.getId();
//        Long idUser = user.getId();
//
//        //then
//        assertEquals(getFromDB, saveInDB);
//        assertEquals(id, saveInDB.getId());
//        assertEquals(idUser, saveInDB.getUser().getId());
//    }
//
//    @Test
//    public void testAddingProductsToOrderEntity(){
//        //given
//        OrderEntity order = new OrderEntity();
//        UserEntity user = new UserEntity("Rafał Kowalsk", false);
//        user.getOrders().add(order);
//        order.setUser(user);
//
//        ProductEntity product1 = new ProductEntity("product3", "description3", 1.50);
//        ProductEntity product2 = new ProductEntity("product4", "description4", 9.00);
//
//        OrderProduct orderProduct1 = new OrderProduct(1L, order, product1, 4);
//        OrderProduct orderProduct2 = new OrderProduct(2L, order, product2, 1);
//
//        product1.getOrders().add(orderProduct1);
//        product2.getOrders().add(orderProduct2);
//
//        order.getProducts().add(orderProduct1);
//        order.getProducts().add(orderProduct2);
//
//        //when
//        OrderProduct saveInDB = testEntityManager.persist(orderProduct1);
//        OrderProduct getFromDB = orderProductEntityRepository.save(saveInDB);
//        Long id = orderProduct1.getId();
//
//        //then
//        assertEquals(getFromDB, saveInDB);
//        assertEquals(id, saveInDB.getId());
//        assertTrue(saveInDB.getProduct().equals(product1));
//    }
//}


//TEST KTORY DODAJE DANE DO BAZY MYSQL
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class OrderEntityTestSuite {
//
////    @Autowired
////    private TestEntityManager testEntityManager;
//
//    @Autowired
//    private OrderEntityRepository orderEntityRepository;
//
//    @Autowired
//    private OrderProductEntityRepository orderProductEntityRepository;
//
//    @Test
//    public void testAddingProductsToOrderEntity(){
//        //given
//        OrderEntity order = new OrderEntity();
//        UserEntity user = new UserEntity("Anna Szczech", true);
//        user.getOrders().add(order);
//        order.setUser(user);
//
//        ProductEntity product1 = new ProductEntity("product1", "description1", 5.50);
//        ProductEntity product2 = new ProductEntity("product2", "description2", 2.40);
//
//        OrderProduct orderProduct1 = new OrderProduct(order, product1, 3);
//        OrderProduct orderProduct2 = new OrderProduct(order, product2, 2);
//
//        product1.getOrders().add(orderProduct1);
//        product2.getOrders().add(orderProduct2);
//
//        order.getProducts().add(orderProduct1);
//        order.getProducts().add(orderProduct2);
//
//        orderProductEntityRepository.save(orderProduct1);
//    }
//}

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderEntityTestSuite {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Test
    public void testAddingProductsToOrderEntity() {
        //given
        ProductEntity product1 = new ProductEntity("product1", "description1", 5.50);
//        ProductEntity product2 = new ProductEntity("product2", "description2", 2.40);


        productEntityRepository.save(product1);
//        productEntityRepository.save(product2);
    }
}