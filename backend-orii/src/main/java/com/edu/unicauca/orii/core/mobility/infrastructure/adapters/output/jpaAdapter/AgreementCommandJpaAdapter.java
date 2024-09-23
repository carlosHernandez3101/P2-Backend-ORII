package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter;

import org.springframework.stereotype.Component;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IAgreementCommandPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IAgreementAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IAgreementRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor

public class AgreementCommandJpaAdapter implements IAgreementCommandPersistencePort {

    private final IAgreementRepository agreementRepository;

    private final IAgreementAdapterMapper agreementAdapterMapper;

    @Override
    public Agreement createAgreement(Agreement agreement) {
        return agreementAdapterMapper
                .toAgreement(agreementRepository.save(agreementAdapterMapper.toAgreementEntity(agreement)));
    }

    @Override
    public Agreement updateAgreement(Long id, Agreement agreement) {
        if (!agreementRepository.existsById(id)) {
            throw new EntityNotFoundException("Agreement not found");
        }

        agreement.setAgreementId(id);

        return agreementAdapterMapper
                .toAgreement(agreementRepository.save(agreementAdapterMapper.toAgreementEntity(agreement)));
    }

}
