package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;
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
public class AgreementData {

     @JsonIgnore
    private Long agreementId;

    @NotNull(message = "The name of institution is required")
    private String institution;

    @NotNull(message = "The agreement number is required")
    private String agreementNumber;

    @NotNull(message = "The agreement country is required")
    private String country;

    @NotNull(message = "The agreement description is required")
    private String description;

    @NotNull(message = "The agreement scope is required")
    private String scope;

    @NotNull(message = "The agreement start date is required")
    private Date startDate;

}
