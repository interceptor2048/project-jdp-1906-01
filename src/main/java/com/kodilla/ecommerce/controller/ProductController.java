package com.kodilla.ecommerce.controller;

import com.kodilla.ecommerce.domain.dto.ProductDto;
import com.kodilla.ecommerce.maper.ProductMapper;
import com.kodilla.ecommerce.service.ProductDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("/v1/ecommerce/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @Autowired
    ProductDbService productDbService;

    @GetMapping(value = "getProducts")
    public List<ProductDto> getProducts(){
        return productMapper.mapToProductDtoList(productDbService.getAllProducts());
    }

    @GetMapping(value = "getProduct")
    public ProductDto getProduct(@RequestParam("productName") String productName){
        return productMapper.mapToProductDto(productDbService.getProduct(productName));
    }

    @PostMapping(value = "createProduct", consumes = APPLICATION_JSON_VALUE)
    public void createProduct(@RequestBody ProductDto product){
        productDbService.saveProduct(productMapper.mapToProduct(product));
    }

    @PutMapping(value = "updateProduct", consumes = APPLICATION_JSON_VALUE)
    public ProductDto updateProduct(@RequestBody ProductDto product){
        return productMapper.mapToProductDto(productDbService.saveProduct(productMapper.mapToProduct(product)));
    }

    @DeleteMapping(value = "deleteProduct")
    public void deleteProduct(@RequestParam("productId") Long productId){
        productDbService.deleteProduct(productId);
    }

}
