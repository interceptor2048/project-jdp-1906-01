package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.OrderEntity;
import com.kodilla.ecommerce.domain.OrderProduct;
import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.repository.OrderEntityRepository;
import com.kodilla.ecommerce.repository.OrderProductEntityRepository;
import com.kodilla.ecommerce.repository.ProductEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class OrderDbService {

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private OrderProductEntityRepository orderProductEntityRepository;

    public List<OrderEntity> getAllOrders(){
        return orderEntityRepository.findAll();
    }

    public Optional<OrderEntity> getOrder(final Long id) {
        return orderEntityRepository.findById(id);
    }

    @Transactional
    public OrderEntity addOrder(final OrderEntity order){
        return orderEntityRepository.save(order);
    }

    public void deleteOrder(final Long id){
        orderEntityRepository.deleteById(id);
    }

    public Optional<UserEntity> findUser(final String userName) {
        return userEntityRepository.findByUserName(userName);
    }

    public Optional<ProductEntity> findProduct(final String productName) {
        return productEntityRepository.findProductEntitiesByName(productName);
    }

    public Optional<OrderProduct> findOrderProduct(final Long id) {
        return orderProductEntityRepository.findById(id);
    }
}
