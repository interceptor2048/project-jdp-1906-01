package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
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

    //RELATIONSHIPS TO BE ADDED ONCE OTHER ENTITIES ARE PRESENT
}
