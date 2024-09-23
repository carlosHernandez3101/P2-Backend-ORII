package com.edu.unicauca.orii.core.mobility.application.ports.output;

import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;

public interface IAgreementCommandPersistencePort {
     public Agreement createAgreement(Agreement agreement);

     public Agreement updateAgreement(Long id, Agreement agreement);
}
