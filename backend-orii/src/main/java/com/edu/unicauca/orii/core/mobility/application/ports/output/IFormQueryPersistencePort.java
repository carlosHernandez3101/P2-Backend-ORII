package com.edu.unicauca.orii.core.mobility.application.ports.output;

import com.edu.unicauca.orii.core.mobility.domain.model.Form;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

public interface IFormQueryPersistencePort {
    Page<Form> findAll(Pageable pageable);
}
