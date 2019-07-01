package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    public ProductEntity(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "PRICE")
    private double price;


    @OneToMany(
            mappedBy = "product",
            cascade = {CascadeType.ALL},
            orphanRemoval = true
    )
    private List<OrderProduct> orders = new ArrayList<>();

//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "GROUP")
//    private GroupEntity group;

//    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "quantityOfProductsInCart")
//    private List<CartEntity> carts = new ArrayList<>();
}

