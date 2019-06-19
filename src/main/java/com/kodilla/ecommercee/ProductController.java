package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.ProductDto;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/ecommercee/product")
public class ProductController {

    @RequestMapping(method = RequestMethod.GET, value = "getProducts")
    public List<ProductDto> getProducts(){
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public ProductDto getProduct(Long productId){
        return new ProductDto(1L, "product1", "description1", 1.00);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(ProductDto product){}

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public ProductDto updateProduct(ProductDto product){
        return new ProductDto(1L, "Edited product1", "Edited description1", 1.00);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void Product(Long productId){}

}
