package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormQueryPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.FormEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IFormAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IFormRepository;

import lombok.RequiredArgsConstructor;

/**
 * JPA adapter for querying forms.
 * This adapter provides a way to query forms from the database using JPA.
 *
 * @author JhossefCons
 */
@Component
@RequiredArgsConstructor
public class FormQueryJpaAdapter implements IFormQueryPersistencePort {

    private final IFormRepository formRepository;
    private final IFormAdapterMapper formAdapterMapper;

    /**
     * Retrieves a paginated list of all forms.
     * 
     * @param pageable the pagination information
     * @return a page of forms
     */
    @Override
    public Page<Form> findAllForms(Pageable pageable) {
       Page<FormEntity> formsEntities=formRepository.findAll(pageable);
       return formsEntities.map(formAdapterMapper::toForm);
    }
}
