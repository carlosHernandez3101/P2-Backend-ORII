package com.edu.unicauca.orii.core.mobility.application.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.edu.unicauca.orii.core.mobility.application.ports.input.IAgreementQueryPort;
import com.edu.unicauca.orii.core.mobility.application.ports.output.IAgreementQueryPersistencePort;
import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AgreementQueryService implements IAgreementQueryPort {

    private final IAgreementQueryPersistencePort agreementQueryPersistencePort;

    @Override
    public Page<Agreement> getAgreement(Pageable pageable) {
        return agreementQueryPersistencePort.getAgreement(pageable);
    }

    @Override
    public List<Agreement> getAgreementByNumberOrName(String search) {
       return agreementQueryPersistencePort.getAgreementByNumberOrName(search);
    }
    
  
}
