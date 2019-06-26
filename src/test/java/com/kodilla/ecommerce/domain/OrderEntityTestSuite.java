package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.OrderEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class OrderEntityTestSuite {

    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Test
    public void testAddingSingleOrderToOrderEntity(){
        //given
        OrderEntity order1 = new OrderEntity();
        OrderEntity order2 = new OrderEntity();
        UserEntity user = new UserEntity("Anna", "Szczech");
        user.getOrders().add(order1);
        user.getOrders().add(order2);
        order1.setUser(user);
        order2.setUser(user);

        //when
        OrderEntity saveInDB = testEntityManager.persist(order1);
        OrderEntity getFromDB = orderEntityRepository.save(saveInDB);
        Long id = order1.getId();
        Long idUser = user.getId();

        //then
        assertEquals(getFromDB, saveInDB);
        assertEquals(id, saveInDB.getId());
        assertEquals(idUser, saveInDB.getUser().getId());
    }

    @Test
    public void testAddingProductsToOrderEntity(){
        //given
        OrderEntity order = new OrderEntity();
        UserEntity user = new UserEntity("Anna", "Szczech");
        user.getOrders().add(order);
        order.setUser(user);

        ProductEntity product1 = new ProductEntity("product1", "description1", 2.50);
        ProductEntity product2 = new ProductEntity("product2", "description2", 5.50);
        product1.getOrders().add(order);
        product2.getOrders().add(order);
        order.getQuantityOfProducts().put(3, product1);
        order.getQuantityOfProducts().put(1, product2);

        //when
        OrderEntity saveInDB = testEntityManager.persist(order);
        OrderEntity getFromDB = orderEntityRepository.save(saveInDB);
        Long id = order.getId();

        //then
        assertEquals(getFromDB, saveInDB);
        assertEquals(id, saveInDB.getId());
        assertTrue(saveInDB.getQuantityOfProducts().containsValue(product1));
        assertTrue(saveInDB.getQuantityOfProducts().containsValue(product2));
    }
}