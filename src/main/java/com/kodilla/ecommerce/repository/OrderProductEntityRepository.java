package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.OrderProduct;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface OrderProductEntityRepository extends CrudRepository<OrderProduct, Long> {
    @Override
    OrderProduct save(OrderProduct orderProduct);

}
