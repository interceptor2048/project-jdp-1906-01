package com.kodilla.ecommerce.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderedProductDto {
    private Long id;
    private String name;
    private String description;
    private double price;
    private int quantity;
}
