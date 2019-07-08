package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserEntityRepository extends CrudRepository<UserEntity, Long> {
    @Override
    UserEntity save(UserEntity order);

    Optional<UserEntity> findByUserName(String userName);
}
