package com.kodilla.ecommerce.service;

import com.kodilla.ecommerce.controller.exceptions.ProductNotFoundException;
import com.kodilla.ecommerce.domain.ProductEntity;
import com.kodilla.ecommerce.repository.ProductEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class ProductDbService {

    @Autowired
    ProductEntityRepository productEntityRepository;

    public List<ProductEntity> getAllProducts() {
        return productEntityRepository.findAll();
    }

    public ProductEntity getProduct(String name) {
        return productEntityRepository.findProductEntitiesByName(name).orElseThrow(ProductNotFoundException::new);
    }

    public ProductEntity saveProduct(ProductEntity product) {
        return productEntityRepository.save(product);
    }

    public void deleteProduct(long id) {
        productEntityRepository.deleteById(id);
    }
}
