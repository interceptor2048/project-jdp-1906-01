package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NamedNativeQuery(
        name = "CartEntity.retrieveCartWithUserName",
        query = "SELECT * FROM CART " +
                "JOIN USERS ON CART.USER = USERS.USER_ID " +
                "WHERE USERS.USERNAME = :NAME",
        resultClass = CartEntity.class
)
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class CartEntity {

    public CartEntity(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CART_ID", unique = true, nullable = false)
    private Long id;

    @OneToMany(
            targetEntity = CartProduct.class,
            mappedBy = "cart",
            fetch = FetchType.LAZY,
            cascade = {CascadeType.REFRESH,  CascadeType.DETACH, CascadeType.PERSIST},
            orphanRemoval = true
    )
    private List<CartProduct> products = new ArrayList<>();

    @OneToOne(cascade =  CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER")
    private UserEntity user;
}

