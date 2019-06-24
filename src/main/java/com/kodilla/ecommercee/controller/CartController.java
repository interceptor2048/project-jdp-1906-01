package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.dto.CartDto;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/ecommercee/cart")
public class CartController {
    @RequestMapping(method = RequestMethod.POST, value = "createCart")
    public void createCart(@RequestBody CartDto cart){}

    @RequestMapping(method = RequestMethod.GET, value = "getProductsFromCart")
    public CartDto getProducts(@RequestParam("productsId") Long productsId){
        return new CartDto(1, 2);
    }

    @RequestMapping(method = RequestMethod.GET, value = "addProductsToCart")
    public CartDto addProducts(@RequestParam("productsId") Long productsId) {
        return new CartDto(1, 2);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProductFromCart")
    public CartDto deleteProduct(@RequestParam("productId") Long productsId) {
        return new CartDto(1, 2);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createOrder")
    public CartController createOrder(@RequestBody CartDto order){}
}
