package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface OrderEntityRepository extends CrudRepository<OrderEntity, Long> {
    @Override
    OrderEntity save(OrderEntity order);
}
