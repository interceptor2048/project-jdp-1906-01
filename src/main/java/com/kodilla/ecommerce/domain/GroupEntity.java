package com.kodilla.ecommerce.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "GROUPS")
public class GroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    public GroupEntity(String name) {
        this.name = name;
    }

    //  TO BE ADDED ONCE PRODUCT ENTITY IS CREATED AND MERGED
//
//  @OneToMany(mappedBy = "")
//  private List<> = new ArrayList<>();
}
