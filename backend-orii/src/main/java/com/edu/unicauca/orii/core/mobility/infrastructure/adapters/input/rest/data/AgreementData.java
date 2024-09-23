package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data;

import com.edu.unicauca.orii.core.mobility.domain.enums.AgreementStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "The name of institution is required")
    private String institution;

    @NotBlank(message = "The agreement number is required")
    private String agreementNumber;

    @NotBlank(message = "The agreemet status is required")
    private AgreementStatus status;

    @NotBlank(message = "The agreement country is required")
    private String country;
}
