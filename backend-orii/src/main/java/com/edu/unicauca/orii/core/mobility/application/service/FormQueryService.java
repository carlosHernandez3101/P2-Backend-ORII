package com.edu.unicauca.orii.core.mobility.application.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edu.unicauca.orii.core.mobility.application.ports.input.IFormQueryPort;
import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormQueryPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormQueryService implements IFormQueryPort{

    private final IFormQueryPersistencePort persistencePort;

    @Override
    public Page<Form> findAll(Pageable pageable) {
        return persistencePort.findAll(pageable);
    }
    
}
