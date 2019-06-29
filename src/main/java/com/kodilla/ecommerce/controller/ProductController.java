package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommerce/product")
public class ProductController {

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>();
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("productId") Long productId){
        return new ProductDto(1L, "product1", "description1", 1.00);
    }

    @PostMapping(value = "createProduct")
    public void createProduct(@RequestBody ProductDto product){}

    @PutMapping(value = "updateProduct")
    public ProductDto updateProduct(@RequestBody ProductDto product){
        return product;
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("productId") Long productId){}

}
