package com.edu.unicauca.orii.core.mobility.domain.model;

import java.util.List;

import com.edu.unicauca.orii.core.mobility.domain.enums.PersonTypeEnum;
import com.edu.unicauca.orii.core.mobility.domain.enums.IdentificationTypeEnum;

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
public class Person {
    
    private Long personId;
    private IdentificationTypeEnum identificationType;
    private PersonTypeEnum personType;
    private String firstName;
    private String lastName;
    private String identification;

    private String email;

    private List<Form> forms;
}
