package com.kodilla.ecommerce.maper;

import com.kodilla.ecommerce.domain.CartEntity;
import com.kodilla.ecommerce.domain.CartProduct;
import com.kodilla.ecommerce.domain.UserEntity;
import com.kodilla.ecommerce.domain.dto.CartDto;
import com.kodilla.ecommerce.domain.dto.CartProductDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CartMapper {
    public CartEntity mapToCart(CartDto cartDto, UserEntity user) {
        CartEntity cart = createCart(cartDto);
        cart.setUser(user);
        return cart;
    }

    private CartEntity createCart(CartDto cartDto) {
        return (cartDto.getId() == null) ? new CartEntity() : new CartEntity(cartDto.getId());
    }

    public CartDto mapToCartDto(CartEntity cart) {
        return new CartDto(cart.getId(), cart.getUser().getUserName(), mapToProductDtoList(cart.getProducts()));
    }

    private List<CartProductDto> mapToProductDtoList(List<CartProduct> orderProductList){
        List<CartProductDto> productsInCart = new ArrayList<>();
        for (CartProduct orderProduct : orderProductList) {
            productsInCart.add(new CartProductDto(orderProduct.getId(), orderProduct.getProduct().getName(), orderProduct.getProduct().getDescription(), orderProduct.getProduct().getPrice(), orderProduct.getQuantity()));
        }
        return productsInCart;
    }
}
