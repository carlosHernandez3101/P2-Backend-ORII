package com.edu.unicauca.orii.core.mobility.application.ports.output;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.unicauca.orii.core.mobility.domain.model.Form;

public interface IFormQueryPersistencePort {
    Page<Form> findAll(Pageable pageable);
}
