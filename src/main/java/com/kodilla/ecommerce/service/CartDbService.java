package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.CartEntity;
import com.kodilla.ecommerce.domain.CartProduct;
import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Service
public class CartDbService {
    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Autowired
    private ProductEntityRepository productEntityRepository;

    @Autowired
    private CartEntityRepository cartEntityRepository;

    @Autowired
    private CartProductRepository cartProductRepository;

    public Optional<UserEntity> findUser(final String userName) {
        return userEntityRepository.findByUserName(userName);
    }

    public CartEntity addCart(final CartEntity cart){
        return cartEntityRepository.save(cart);
    }

    public Optional<CartEntity> getCart(final Long id) {
        return cartEntityRepository.findById(id);
    }

    public Optional<ProductEntity> findProduct(final String productName) {
        return productEntityRepository.findProductEntitiesByName(productName);
    }

    public Optional<CartProduct> findCartProduct(final Long id) {
        return cartProductRepository.findById(id);
    }
}
