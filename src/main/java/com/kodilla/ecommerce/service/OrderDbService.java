package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.OrderEntity;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.repository.OrderEntityRepository;
import com.kodilla.ecommerce.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDbService {

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    public List<OrderEntity> getAllOrders(){
        return orderEntityRepository.findAll();
    }

    public Optional<OrderEntity> getOrder(final Long id) {
        return orderEntityRepository.findById(id);
    }

    public OrderEntity addOrder(final OrderEntity order){
        return orderEntityRepository.save(order);
    }

    public void deleteOrder(final Long id){
        orderEntityRepository.deleteById(id);
    }

    public Optional<UserEntity> findUser(final String userName) {
        return userEntityRepository.findByUserName(userName);
    }
}
