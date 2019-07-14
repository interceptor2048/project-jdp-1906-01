package com.kodilla.ecommerce.controller;


import com.kodilla.ecommerce.controller.exceptions.*;
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

@RestController
@RequestMapping("/v1/ecommerce/cart")
public class CartController {

    @Autowired
    private CartDbService cartDbService;

    @Autowired
    private CartMapper cartMapper;

    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cartDto) {
        UserEntity user = cartDbService.findUser(cartDto.getUserName()).orElseThrow(UserNotFoundException::new);
        if (cartDbService.findUserCart(cartDto.getUserName()).isPresent()) {
            throw new UserCanHaveOnlyOneCartException();
        }
        checkIfUserIsBlock(user);
        cartDbService.addCart(cartMapper.mapToCart(cartDto, user));

    }

    @GetMapping(value = "getProductsFromCart")
    public CartDto getProducts(@RequestParam("cartId") Long cartId) {
        return cartMapper.mapToCartDto(cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new));
    }

    @GetMapping(value = "addProductsToCart")
    public void addProducts(@RequestParam("cartId") Long cartId, @RequestBody CartProductDto cartProductDto) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        checkIfUserIsBlock(cart.getUser());
        cartDbService.saveProductInCart(addProductToCartEntity(cart, cartProductDto));

    }

    @DeleteMapping(value = "deleteProductFromCart")
    public void deleteProduct(@RequestParam("cartId") Long cartId, @RequestParam("cartProductId") Long cartProductId) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        CartProduct cartProduct = cartDbService.findCartProduct(cartProductId).orElseThrow(ProductNotFoundInCartExcepton::new);
        checkIfUserIsBlock(cart.getUser());
        cart.getProducts().remove(cartProduct);
        cartDbService.addCart(cart);
    }

    @PostMapping(value = "createOrder")
    public void createOrder(@RequestParam("cartId") Long cartId) {
        CartEntity cart = cartDbService.getCart(cartId).orElseThrow(CartNotFoundException::new);
        checkIfUserIsBlock(cart.getUser());
        cartDbService.saveOrder(createOrder(cart));
        cart.getProducts().clear();
        cartDbService.addCart(cart);
    }

    private CartProduct addProductToCartEntity(CartEntity cart, CartProductDto cartProductDto) {
        ProductEntity product = cartDbService.findProduct(cartProductDto.getName()).orElseThrow(CartNotFoundException::new);
        CartProduct cartProduct = new CartProduct(cart, product, cartProductDto.getQuantity());
        product.getProductsInCart().add(cartProduct);
        cart.getProducts().add(cartProduct);
        return cartProduct;
    }

    private OrderEntity createOrder(CartEntity cart) {
        OrderEntity order = new OrderEntity();
        order.setUser(cart.getUser());
        for (CartProduct product : cart.getProducts()) {
            OrderProduct orderProduct = new OrderProduct(order, product.getProductInCart(), product.getQuantity());
            product.getProductInCart().getOrders().add(orderProduct);
            order.getProducts().add(orderProduct);
        }
        return order;
    }

    private void checkIfUserIsBlock(UserEntity user) {
        if (user.isBlocked()) {
            throw new UserIsBlockException();
        }
    }

}
