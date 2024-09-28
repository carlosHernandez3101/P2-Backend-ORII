package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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

    @NotEmpty(message = "The name of institution is required")
    private String institution;

    @NotEmpty(message = "The agreement number is required")
    private String agreementNumber;

    @NotEmpty(message = "The agreement country is required")
    private String country;

    @NotEmpty(message = "The agreement description is required")
    private String description;

    @NotEmpty(message = "The agreement scope is required")
    private String scope;

    @NotNull(message = "The entry date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date startDate;

}
