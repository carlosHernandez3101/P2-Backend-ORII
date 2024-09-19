package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter;

import com.edu.unicauca.orii.core.mobility.domain.enums.AgreementStatus;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.AgreementEntity;
import org.springframework.stereotype.Component;

import com.edu.unicauca.orii.core.mobility.application.ports.output.IAgreementCommandPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper.IAgreementAdapterMapper;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.repository.IAgreementRepository;

import lombok.RequiredArgsConstructor;

import java.util.Optional;

@Component
@RequiredArgsConstructor

public class AgreementCommandJpaAdapter implements IAgreementCommandPersistencePort {

    private final IAgreementRepository agreementRepository;
    
    private final IAgreementAdapterMapper agreementAdapterMapper;

    @Override
    public Agreement createAgreement(Agreement agreement) {
       return agreementAdapterMapper.toAgreement(agreementRepository.save(agreementAdapterMapper.toAgreementEntity(agreement)));
    }

    @Override
    public Agreement deleteAgreement(Long id) {
        Optional<AgreementEntity> agreementEntity = this.agreementRepository.findById(id);
        Agreement agreementInactive = null;
        if (!agreementEntity.isEmpty()) {
            AgreementEntity agreementToInactive = agreementEntity.get();
            agreementToInactive.setStatus(AgreementStatus.INACTIVE);
            this.agreementRepository.save(agreementToInactive);
            agreementInactive = agreementAdapterMapper.toAgreement(agreementToInactive);
        }
        return agreementInactive;
    }
}
