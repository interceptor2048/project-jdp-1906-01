package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "PRODUCTS")
public class ProductEntity {

    public ProductEntity(Long id, String name, String description, double price) {
        this.id = id;
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

    //     RELACJE MIĘDZY KLASAMI SĄ ZAKOMENTWANE ZE WZGLĘDU NA BRAK ENCJI OrderEntity, CartEntity i GroupEntity
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "quantityOfProducts")
    private List<OrderEntity> orders = new ArrayList<>();
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "GROUP")
//    private GroupEntity group;
//
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_PRODUCT_CART",
//            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")}
//    )
//    @MapKeyColumn(name = "PRODUCT_QUANTITY")
//    private Map<Integer, CartEntity> quantityOfProductsInCart = new HashMap<>();
}
