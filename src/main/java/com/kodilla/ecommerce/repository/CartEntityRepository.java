package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.CartEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartEntityRepository extends CrudRepository<CartEntity, Long> {
    @Override
    CartEntity save(CartEntity order);

    @Override
    Optional<CartEntity> findById(Long id);

    @Query(nativeQuery = true)
    Optional<CartEntity> retrieveCartWithUserName(@Param("NAME") String userName);
}
