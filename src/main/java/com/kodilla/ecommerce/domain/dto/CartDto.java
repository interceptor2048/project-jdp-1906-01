package com.kodilla.ecommerce.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CartDto {
    private Long id;
//    private Long productId;
    private String userName;
    private List<CartProductDto> products;
}
