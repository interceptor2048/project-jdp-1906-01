package com.kodilla.ecommerce.controller;


import com.kodilla.ecommerce.controller.exceptions.CartNotFoundException;
import com.kodilla.ecommerce.controller.exceptions.ProductNotFoundInCartExcepton;
import com.kodilla.ecommerce.controller.exceptions.UserNotFoundException;
import com.kodilla.ecommerce.domain.*;
import com.kodilla.ecommerce.domain.dto.CartDto;
import com.kodilla.ecommerce.domain.dto.CartProductDto;
import com.kodilla.ecommerce.maper.CartMapper;
import com.kodilla.ecommerce.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/v1/ecommerce/cart")
public class CartController {

    @Autowired
    private CartDbService cartDbService;

    @Autowired
    private CartMapper cartMapper;

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        UserEntity user = cartDbService.findUser(cartDto.getUser_name()).orElseThrow(UserNotFoundException::new);
        cartDbService.addCart(cartMapper.mapToCart(cartDto, user));
    }

    @GetMapping(value = "getProductsFromCart")
    public CartDto getProducts(@RequestParam("cartId") Long cartId) {
        return cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new));
    }

    @GetMapping(value = "addProductsToCart")
    public CartDto addProducts(@RequestParam("cartId") Long cartId, @RequestBody CartProductDto cartProductDto) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        addProductToCartEntity(cart, cartProductDto);
        return cartMapper.mapToCartDto(cart);
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProduct(@RequestParam("cartId") Long cartId, @RequestParam("cartProductId") Long cartProductId) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        CartProduct cartProduct = cartDbService.findCartProduct(cartProductId).orElseThrow(ProductNotFoundInCartExcepton::new);
        cart.getProducts().remove(cartProduct);
        cartDbService.addCart(cart);
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestParam("cartId") Long cartId) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        createOrder(cart);
        cart.getProducts().clear();
        cartDbService.addCart(cart);
    }

    private void addProductToCartEntity(CartEntity cart, CartProductDto cartProductDto) {
        ProductEntity product = cartDbService.findProduct(cartProductDto.getName()).orElseThrow(CartNotFoundException::new);
        cart.getProducts().add(new CartProduct(cart, product, cartProductDto.getQuantity()));
    }

    private void createOrder(CartEntity cart){
        OrderEntity order = new OrderEntity();
        order.setUser(cart.getUser());
        for (CartProduct product : cart.getProducts()) {
            order.getProducts().add(new OrderProduct(order, product.getProduct(), product.getQuantity()));
        }
    }

}
