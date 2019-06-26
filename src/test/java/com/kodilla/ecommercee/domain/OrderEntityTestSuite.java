package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.repository.OrderEntityRepository;
import com.kodilla.ecommercee.repository.UserEntityRepository;
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
        Long id = order1.getId();
        Long idUser = user.getId();

        //then
        assertEquals(id, saveInDB.getId());
        assertEquals(idUser, saveInDB.getUser().getId());
    }
}