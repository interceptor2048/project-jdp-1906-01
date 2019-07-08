package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
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
@Table(name = "ORDERS")
public class OrderEntity {

    public OrderEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true, nullable = false)
    private Long id;

    @OneToMany(
            targetEntity = OrderProduct.class,
            mappedBy = "order",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,  CascadeType.DETACH, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private List<OrderProduct> products = new ArrayList<>();

    @ManyToOne(
            targetEntity = UserEntity.class,
            cascade = {CascadeType.MERGE},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER")
    private UserEntity user;
}