package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.domain.*;
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

    public CartProduct saveProductInCart(final CartProduct cartProduct) {
        return cartProductRepository.save(cartProduct);
    }

    public OrderEntity saveOrder(final OrderEntity orderEntity){
        return orderEntityRepository.save(orderEntity);
    }

    public Optional<CartEntity> findUserCart(String name){
        return cartEntityRepository.retrieveCartWithUserName(name);
    }
}
