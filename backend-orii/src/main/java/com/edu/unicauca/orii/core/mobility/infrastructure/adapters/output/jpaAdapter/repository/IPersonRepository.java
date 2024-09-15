package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.PersonEntity;

public interface IPersonRepository extends JpaRepository<PersonEntity, Long> {
    
}
