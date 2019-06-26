package com.kodilla.ecommercee.repository;

import com.kodilla.ecommercee.domain.UserEntity;
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