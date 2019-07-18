package com.kodilla.ecommerce.domain;

import com.kodilla.ecommerce.repository.OrderProductEntityRepository;
import com.kodilla.ecommerce.repository.ProductEntityRepository;
import com.kodilla.ecommerce.repository.GroupEntityRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.acl.Group;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductEntityTestSuite {

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private OrderProductEntityRepository orderProductEntityRepository;

    @Autowired
    private GroupEntityRepository groupEntityRepository;

    @Test
    public void testAddingProductToProductEntity() {
        //given
        ProductEntity product = new ProductEntity("product", "description", 1);

        //when
        productEntityRepository.save(product);
        long id = product.getId();

        //then
        assertNotEquals(0L, id);

    }

    @Test
    public void testAddingProductsToGroupEntity() {
        //given
        ProductEntity product1 = new ProductEntity("product1", "description1", 1);
        ProductEntity product2 = new ProductEntity("product2", "description2", 2);
        GroupEntity group1 = new GroupEntity("group1");
        product1.setGroup(group1);
        product2.setGroup(group1);

        //when
        groupEntityRepository.save(group1);
        long id = group1.getId();

        //then
        assertNotEquals(0, id);

    }

    @Test
    public void testAddingCartProductToProductEntity() {
        //given
        CartProduct cart1 = new CartProduct(new CartEntity(1L), new ProductEntity("name1", "product1", 1) , 1 );
        CartProduct cart2 = new CartProduct(new CartEntity(2L), new ProductEntity("name2", "product2", 2), 2);
        ProductEntity product1 = new ProductEntity("product", "description", 1);
        cart1.setProductInCart(product1);
        cart2.setProductInCart(product1);

        //when
        productEntityRepository.save(product1);
        long id = product1.getId();

        //then
        assertNotEquals(0, id);

    }

    @Test
    public void testAddingOrderProductToProductEntity(){
        //given
        OrderProduct order1 = new OrderProduct(new OrderEntity(1L), new ProductEntity("name1", "product1", 1) , 1 );
        OrderProduct order2 = new OrderProduct(new OrderEntity(2L), new ProductEntity("name2", "product2", 2) , 2 );
        ProductEntity product1 = new ProductEntity("product", "description", 1);
        order1.setProduct(product1);
        order2.setProduct(product1);

        //when
        productEntityRepository.save(product1);
        long id = product1.getId();

        //then
        assertNotEquals(0, id);
    }
}
