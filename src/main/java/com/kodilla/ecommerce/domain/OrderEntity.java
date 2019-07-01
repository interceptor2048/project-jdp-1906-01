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
@Table(name = "ORDERS")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true)
    private Long id;

    @OneToMany(
            mappedBy = "order",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<OrderProduct> products = new ArrayList<>();

    @ManyToOne(
            targetEntity = UserEntity.class,
            cascade = {CascadeType.PERSIST, CascadeType.REFRESH},
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "USER")
    private UserEntity user;

}