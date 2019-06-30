package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ORDER_PRODUCT")
public class OrderProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_PRODUCT_ID", unique = true)
    private Long id;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private OrderEntity order;

    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    private ProductEntity product;

    @Column(name = "QUANTITY_OF_PRODUCTS")
    private int quantity;

    public OrderProduct(OrderEntity order, ProductEntity product, int quantity) {
        this.order = order;
        this.product = product;
        this.quantity = quantity;
    }
}

