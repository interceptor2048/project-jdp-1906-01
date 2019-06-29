package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserEntityTestSuite {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserEntityRepository userEntityRepository;

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
        product1.getOrders().add(order1);
        product2.getOrders().add(order1);
        product2.getOrders().add(order2);
        product3.getOrders().add(order2);
        order1.getQuantityOfProducts().put(3, product1);
        order1.getQuantityOfProducts().put(1, product2);
        order2.getQuantityOfProducts().put(4, product2);
        order2.getQuantityOfProducts().put(2, product3);

        //when
        UserEntity saveInDB = testEntityManager.persist(user);
        UserEntity getFromDB = userEntityRepository.save(saveInDB);
        Long id = user.getId();

        //then
        assertEquals(getFromDB, saveInDB);
        assertEquals(id, saveInDB.getId());
        assertTrue(saveInDB.getOrders().contains(order1));
        assertTrue(saveInDB.getOrders().contains(order2));
        assertTrue(saveInDB.getOrders().get(0).getQuantityOfProducts().containsValue(product1));
        assertTrue(saveInDB.getOrders().get(0).getQuantityOfProducts().containsValue(product2));
        assertTrue(saveInDB.getOrders().get(1).getQuantityOfProducts().containsValue(product2));
        assertTrue(saveInDB.getOrders().get(1).getQuantityOfProducts().containsValue(product3));
    }

    //Gdy powstanie Encja Cart trzeba dodać testAddingCartToEntity !!!

}
