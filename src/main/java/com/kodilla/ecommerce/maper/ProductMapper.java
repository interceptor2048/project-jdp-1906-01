package com.kodilla.ecommerce.maper;

import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.domain.dto.ProductDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {
    public ProductEntity mapToProduct(final ProductDto productDto) {
        return new ProductEntity(
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice()
        );
    }

    public ProductDto mapToProductDto(ProductEntity product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

    public List<ProductDto> mapToProductDtoList(final List<ProductEntity> productList) {
        return productList
                .stream()
                .map(this::mapToProductDto)
                .collect(Collectors.toList());
    }

    public List<ProductEntity> mapToProductList(final List<ProductDto> productDtoList){
        return productDtoList
                .stream()
                .map(this::mapToProduct)
                .collect(Collectors.toList());
    }
}
