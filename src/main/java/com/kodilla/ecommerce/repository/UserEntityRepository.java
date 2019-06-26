package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findBySurname(String surname);

    @Override
    UserEntity save(UserEntity user);
}