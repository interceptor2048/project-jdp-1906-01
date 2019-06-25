package com.kodilla.ecommercee.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import javax.persistence.criteria.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class CartEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private Long cartId;
    ////     RELACJE MIĘDZY KLASAMI SĄ ZAKOMENTOWANE ZE WZGLĘDU NA BRAK ENCJI USER i GROUP
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private List<ProductEntity> productList = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "cart")
     private UserEntity user;

    @MapKeyColumn(name = "PRODUCT_QUANTITY")
     private Map<Integer, CartEntity> quantityOfProductsInCart = new HashMap<>();
}

