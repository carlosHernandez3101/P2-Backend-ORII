package com.edu.unicauca.orii.core.mobility.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.edu.unicauca.orii.core.mobility.application.ports.input.IFormCommandPort;
import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormCommandPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;

import lombok.RequiredArgsConstructor;
/**
 * Service implementation for managing {@link Form} entities.
 * <p>
 * This class implements the {@link IFormCommandPort} interface and provides methods 
 * to create, update, and delete {@link Form} entities by delegating the operations 
 * to the {@link IFormCommandPersistencePort}.
 * </p>
 * 
 * <p>It uses the {@link IFormCommandPersistencePort} for persistence-related operations.</p>
 * 
 * <p>
 * This class is annotated with {@link Service} to mark it as a Spring service and
 * {@link RequiredArgsConstructor} to automatically generate the constructor for final fields.
 * </p>
 * @author JulianRuano
 */
@Service
@RequiredArgsConstructor
public class FormCommandService implements IFormCommandPort {

    private final IFormCommandPersistencePort persistencePort;
    /**
     * {@inheritDoc}
     * <p>This method delegates the creation of a {@link Form} to the persistence layer.</p>
     */
    @Override
    public Form createForm(Form form) {
        return persistencePort.createForm(form);
    }

    /**
     * {@inheritDoc}
     * <p>This method delegates the updating of a {@link Form} to the persistence layer.</p>
     */
    @Override
    public Form updateForm(Long id, Form form) {
        return persistencePort.updateForm(id, form);
    }

    /**
     * {@inheritDoc}
     * <p>This method delegates the deletion of a {@link Form} to the persistence layer.</p>
     */
    @Override
    public void deleteForm(Long id) {
     persistencePort.deleteForm(id);
    }

    @Override
    public List<Form> findAllForms(){
        return persistencePort.findAllForms();
    }
}
