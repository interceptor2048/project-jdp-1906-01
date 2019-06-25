package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    //     RELACJE MIĘDZY KLASAMI SĄ ZAKOMENTWANE ZE WZGLĘDU NA BRAK ENCJI USER i PRODUCT
//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(
//            name = "JOIN_ORDER_PRODUCT",
//            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
//    )
//    @MapKeyColumn(name = "PRODUCT_QUANTITY")
//    private Map<Integer, ProductEntity> quantityOfProducts = new HashMap<>();
//
//    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinColumn(name = "USER")
//    private UserEntity user;
}