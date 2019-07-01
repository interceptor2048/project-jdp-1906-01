package com.kodilla.ecommerce.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "CART")
public class CartEntity {

    //    RELACJE MIĘDZY KLASAMI SĄ ZAKOMENTOWANE ZE WZGLĘDU NA BRAK ENCJI USER i GROUP
    //@ManyToMany(cascade = CascadeType.ALL)
   // @JoinTable(
            //name = "JOIN_CART_PRODUCT",
           // joinColumns = {@JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")},
           // inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}
   // )
  //  @MapKeyColumn(name = "PRODUCT_QUANTITY")
  //  private Map<Integer,ProductEntity> quantityOfProductsInCart = new HashMap<>();

   // @OneToOne(cascade =  CascadeType.ALL, fetch = FetchType.EAGER)
   // private UserEntity user;
}

