package com.kodilla.ecommerce.repository;

import com.kodilla.ecommerce.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> { }
