package com.kodilla.ecommerce.domain.dto;

import com.kodilla.ecommerce.domain.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderDto {
    private long id;
    private String userName;
    private List<OrderedProductDto> products;
}
