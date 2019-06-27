package com.kodilla.ecommerce.controller;


import com.kodilla.ecommerce.domain.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommerce/cart")
public class CartController {
    @PostMapping(value = "createCart")
    public void createCart(@RequestBody CartDto cart){}

    @GetMapping(value = "getProductsFromCart")
    public CartDto getProducts(@RequestParam("productsId") Long productsId){
        return new CartDto(1L, 2L);
    }

    @GetMapping(value = "addProductsToCart")
    public CartDto addProducts(@RequestParam("productsId") Long productsId) {
        return new CartDto(1L, 2L);
    }

    @DeleteMapping(value = "deleteProductFromCart")
    public CartDto deleteProduct(@RequestParam("productId") Long productsId) {
        return new CartDto(1L, 2L);
    }

    @PostMapping(value = "createOrder")
    public CartController createOrder(@RequestBody CartDto order){
        return new CartDto (1L, 2L);
    }
}
