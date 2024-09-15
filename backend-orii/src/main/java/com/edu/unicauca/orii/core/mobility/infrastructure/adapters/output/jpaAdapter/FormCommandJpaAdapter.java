package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IFormCommandPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Form;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.AgreementEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.EventEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.EventTypeEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.FormEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.PersonEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IEventAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IFormAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IPersonAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IAgreementRepository;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IEventRepository;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IEventTypeRepository;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IFormRepository;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IPersonRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class FormCommandJpaAdapter implements IFormCommandPersistencePort{
    
    private final IFormRepository formRepository;
    private final IEventRepository eventRepository;
    private final IPersonRepository personRepository;
    private final IAgreementRepository agreementRepository;
    private final IEventTypeRepository eventTypeRepository;

    private final IFormAdapterMapper formAdapterMapper;
    private final IEventAdapterMapper eventAdapterMapper;
    private final IPersonAdapterMapper personAdapterMapper;
    
    @Override
    public Form createForm(Form form) {
  
        AgreementEntity agreementEntity = agreementRepository.findById(form.getAgreement().getAgreementId()).get();
        FormEntity formEntity = formAdapterMapper.toFormEntity(form);
        formEntity.setAgreement(agreementEntity);

        EventEntity eventEntity = eventAdapterMapper.toEventEntity(form.getEvent());
        EventTypeEntity eventTypeEntity = eventTypeRepository.findById(form.getEvent().getEventType().getEventTypeId()).get();
        eventEntity.setEventType(eventTypeEntity);
        eventEntity = eventRepository.save(eventEntity);
        formEntity.setEvent(eventEntity);

        PersonEntity personEntity =  personAdapterMapper.toPersonEntity(form.getPerson());
        personEntity = personRepository.save(personEntity);
        formEntity.setPerson(personEntity);

        formEntity = formRepository.save(formEntity);
        return formAdapterMapper.toForm(formEntity);

    }

    @Override
    public Form updateForm(Long id, Form form) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateForm'");
    }
    
}
