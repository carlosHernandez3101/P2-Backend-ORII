package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.EventEntity;

public interface IEventRepository extends JpaRepository<EventEntity, Long> {
    
}
