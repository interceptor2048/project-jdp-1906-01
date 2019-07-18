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
public class UserDbService {
    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;


}
