package com.edu.unicauca.orii.core.mobility.application.ports.input;

import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;

public interface IAgreementCommandPort {
    //Writing services
    public Agreement createAgreement(Agreement agreement);
    public void deleteAgreement(Long id);
}
