package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface GroupEntityRepository extends CrudRepository<GroupEntity, Long> {
    @Override
    List<GroupEntity> findAll();

    @Override
    Optional<GroupEntity> findById(Long id);

    @Override
    GroupEntity save(GroupEntity group);
}
