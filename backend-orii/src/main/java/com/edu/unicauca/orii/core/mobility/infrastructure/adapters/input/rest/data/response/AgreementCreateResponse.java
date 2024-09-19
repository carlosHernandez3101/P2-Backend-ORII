package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.response;

import com.edu.unicauca.orii.core.mobility.domain.enums.AgreementStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AgreementCreateResponse {
    
    private Long agreementId;
    private String institution;
    private String agreementNumber;
    private AgreementStatus status;
    private String country;
}
