package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.OrderProductEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTestSuite {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private OrderProductEntityRepository orderProductEntityRepository;

    @Test
    public void testAddingSingleUserToUserEntity(){
        //given
        UserEntity user = new UserEntity("name", false);

        //when
        UserEntity saveInDB = testEntityManager.persist(user);
        UserEntity getFromDB = userEntityRepository.save(saveInDB);
        Long id = user.getId();

        //then
        assertEquals(getFromDB, saveInDB);
        assertEquals(id, saveInDB.getId());
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
        ProductEntity product3 = new ProductEntity("product3", "description3", 10.50);

        OrderProduct orderProduct1 = new OrderProduct(order1, product1, 3);
        OrderProduct orderProduct2 = new OrderProduct(order1, product2, 1);
        OrderProduct orderProduct3 = new OrderProduct(order2, product2, 4);
        OrderProduct orderProduct4 = new OrderProduct(order2, product3, 2);

        product1.getOrders().add(orderProduct1);
        product2.getOrders().add(orderProduct2);
        product2.getOrders().add(orderProduct3);
        product3.getOrders().add(orderProduct4);
        order1.getProducts().add(orderProduct1);
        order1.getProducts().add(orderProduct2);
        order2.getProducts().add(orderProduct3);
        order2.getProducts().add(orderProduct4);

        //when
        OrderProduct saveInDB = testEntityManager.persist(orderProduct1);
        OrderProduct getFromDB = orderProductEntityRepository.save(saveInDB);
        Long id = orderProduct1.getId();

        //then
        assertEquals(getFromDB, saveInDB);
        assertEquals(id, saveInDB.getId());
        assertTrue(saveInDB.getProduct().equals(product1));
        assertTrue(saveInDB.getOrder().equals(order1));
        assertEquals(3, saveInDB.getQuantity());
    }

    //Gdy powstanie Encja Cart trzeba dodać testAddingCartToEntity !!!

}




//TEST KTORY DODAJE DANE DO BAZY MYSQL
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class UserEntityTestSuite {
//
//
//    @Autowired
//    private UserEntityRepository userEntityRepository;
//
//    @Autowired
//    private OrderProductEntityRepository orderProductEntityRepository;
//
//    @Test
//    public void testAddingSingleUserToUserEntity(){
//        //given
//        UserEntity user = new UserEntity("Anna Szczech", false);
//
//        //when
//        userEntityRepository.save(user);
//    }
//}
