package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PersonJpaRepository extends JpaRepository<PersonJpaEntity, UUID> {
    List<PersonJpaEntity> findAllByFirstName(String firstName);
}
