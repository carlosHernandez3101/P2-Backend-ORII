package com.edu.unicauca.orii.core.mobility.domain.model;
import java.util.List;

import com.edu.unicauca.orii.core.mobility.domain.enums.AgreementStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Agreement {
    
    private Long agreementId;
    private String institution;
    private String agreementNumber;
    private AgreementStatus status;
    private String country;
    private List<Form> form;
}
