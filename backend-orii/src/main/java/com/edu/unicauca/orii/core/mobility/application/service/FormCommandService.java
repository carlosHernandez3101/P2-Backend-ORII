package com.edu.unicauca.orii.core.mobility.application.service;

import org.springframework.stereotype.Service;

import com.edu.unicauca.orii.core.mobility.application.ports.input.IFormCommandPort;
import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormCommandPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FormCommandService implements IFormCommandPort {
    private final IFormCommandPersistencePort persistencePort;

    @Override
    public Form createForm(Form form) {
        return persistencePort.createForm(form);
    }

    @Override
    public Form updateForm(Long id, Form form) {
        return persistencePort.updateForm(id, form);
    }

}
