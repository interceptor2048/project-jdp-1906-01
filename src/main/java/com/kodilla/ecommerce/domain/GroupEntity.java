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
@Table(name = "ENTITY_GROUPS")
public class GroupEntity {

    public GroupEntity(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(
            targetEntity = ProductEntity.class,
            mappedBy = "group",
            cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.PERSIST},
            fetch = FetchType.LAZY,
            orphanRemoval = true
    )
    private List<ProductEntity> products = new ArrayList<>();
}
