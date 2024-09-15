package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.edu.unicauca.orii.core.mobility.domain.model.Agreement;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.AgreementData;

@Mapper(componentModel = "spring")
public interface IAgreementRestMapper {

    @Mapping(target = "forms", ignore = true)
    Agreement toAgreement(AgreementData agreementData);
    
}
