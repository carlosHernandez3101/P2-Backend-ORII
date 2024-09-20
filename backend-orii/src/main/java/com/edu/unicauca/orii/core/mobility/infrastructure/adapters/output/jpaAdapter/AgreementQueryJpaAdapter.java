package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IAgreementQueryPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.AgreementEntity;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IAgreementAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IAgreementRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AgreementQueryJpaAdapter implements IAgreementQueryPersistencePort{

    private final IAgreementRepository agreementRepository;
    private final IAgreementAdapterMapper agreementAdapterMapper;

    
    @Override
    public Page<Agreement> getAgreement(Pageable pageable) {
       Page<AgreementEntity> agreementEntities=agreementRepository.findAll(pageable);
       return agreementEntities.map(agreementAdapterMapper::toAgreement);
    }



    
}
