package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class OrderEntity {
    private Long id;
    private int quantity;
    private ProductEntity product;
    private UserEntity user;


    public OrderEntity(Long id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ORDER_ID", unique = true)
    public Long getId(){
        return id;
    }

    @Column(name = "QUANTITY")
    @NotNull
    public int getQuantity() {
        return quantity;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRODUCT_ID")
    public ProductEntity getProduct() {
        return product;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER")
    public UserEntity getUser() {
        return user;
    }

    public void setProduct(ProductEntity product){
        this.product = product;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}