package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> { }
