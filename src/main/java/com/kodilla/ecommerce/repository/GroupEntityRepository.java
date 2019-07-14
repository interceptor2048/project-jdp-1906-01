package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.GroupEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface GroupEntityRepository extends CrudRepository<GroupEntity, Long> {

    @Override
    List<GroupEntity> findAll();

    @Override
    Optional<GroupEntity> findById(Long id);

    @Override
    GroupEntity save(GroupEntity group);

    Optional<GroupEntity> findByName( String groupName);
}

