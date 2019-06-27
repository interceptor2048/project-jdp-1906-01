package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.OrderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    OrderEntity save(OrderEntity order);
}
