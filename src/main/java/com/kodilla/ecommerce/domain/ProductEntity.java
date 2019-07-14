package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

//@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    public ProductEntity(String name, String description, double price) {
//        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", unique = true, nullable = false)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;


    @OneToMany(
            targetEntity = OrderProduct.class,
            mappedBy = "product",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<OrderProduct> orders = new ArrayList<>();

    @OneToMany(
            targetEntity = CartProduct.class,
            mappedBy = "productInCart",
            cascade = {CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<CartProduct> productsInCart = new ArrayList<>();

    @ManyToOne(cascade = {CascadeType.MERGE}, fetch = FetchType.LAZY)
    @JoinColumn(name = "GROUP_ID")
    private GroupEntity group;
}

