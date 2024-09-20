package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data;

import com.edu.unicauca.orii.core.mobility.domain.enums.IdentificationTypeEnum;
import com.edu.unicauca.orii.core.mobility.domain.enums.PersonTypeEnum;

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
public class PersonData {
    
    private Long personId;
    private IdentificationTypeEnum identificationType;
    private PersonTypeEnum personType;
    private String firstName;
    private String lastName;
    private String identification;

    private String email;
}
