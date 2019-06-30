package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    OrderEntity save(OrderEntity order);

    @Override
    List<OrderEntity> findAll();

    @Override
    Optional<OrderEntity> findById(Long id);

    @Override
    void deleteById(Long id);
}