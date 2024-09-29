package com.edu.unicauca.orii.core.mobility.application.ports.input;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;



public interface IAgreementQueryPort {
    Page<Agreement>getAgreement(Pageable pageable);
    List<Agreement>getAgreementByNumberOrName(String search );
}
