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
@Table(name = "GROUPS")
public class GroupEntity {

    @Id
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    private Long idd;

    @Column(name = "NAME")
    private String name;

//    TO BE ADDED ONCE PRODUCT ENTITY IS CREATED AND MERGED
////
////    @OneToMany(mappedBy = "")
////    private List<> = new ArrayList<>();
}
