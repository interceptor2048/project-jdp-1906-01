package com.kodilla.ecommerce.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USERS")
public class UserEntity {

    @Id
    @GeneratedValue
    @Column(name = "USER_ID", unique = true)
    private Long id;

    @Column(name = "USERNAME")
    private String userName;

    @Column(name = "IS_BLOCKED")
    private boolean isBlocked;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "user")
    private List<OrderEntity> orders = new ArrayList<>();

    public UserEntity(String userName, boolean isBlocked) {
        this.userName = userName;
        this.isBlocked = isBlocked;
    }


    //RELATIONSHIPS TO BE ADDED ONCE OTHER ENTITIES ARE PRESENT
}