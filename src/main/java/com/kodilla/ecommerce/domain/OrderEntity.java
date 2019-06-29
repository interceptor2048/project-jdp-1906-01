package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
    )
    @MapKeyColumn(name = "PRODUCT_QUANTITY")
    private Map<Integer, ProductEntity> quantityOfProducts = new HashMap<>();

    @NotNull
    @ManyToOne(
            targetEntity = UserEntity.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER")
    private UserEntity user;


}