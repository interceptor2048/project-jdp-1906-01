package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "CART_PRODUCT")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_PRODUCT_ID", unique = true, nullable = false)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "CART_ID")
    private CartEntity cart;

    @ManyToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_IN_CART_ID")
    private ProductEntity productInCart;

    @Column(name = "QUANTITY_OF_PRODUCTS")
    private int quantity;

    public CartProduct(CartEntity cart, ProductEntity product, int quantity) {
        this.cart = cart;
        this.productInCart = product;
        this.quantity = quantity;
    }
}
