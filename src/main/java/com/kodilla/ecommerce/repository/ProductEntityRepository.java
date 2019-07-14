package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.ProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEntityRepository extends CrudRepository<ProductEntity, Long> {
    @Override
    List<ProductEntity> findAll();

    @Override
    ProductEntity save(ProductEntity productEntity);

    Optional<ProductEntity> findProductEntitiesByName(String name);

    @Override
    void deleteById(Long id);
}
