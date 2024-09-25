package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.request;

import java.util.Date;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.edu.unicauca.orii.core.mobility.domain.enums.DirectionEnum;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.PersonData;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FormCreateRequest {
    
    @JsonIgnore
    private Long id;

    private Boolean orii;

    @NotNull(message = "The address is required")
    private DirectionEnum direction;

    @NotNull(message ="The gender is required")
    private String gender;

    @NotNull(message = "CTA is required")
    private Integer cta;

    @NotNull(message = "The entry date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date entryDate;

    @NotNull(message = "The exit date is required")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date exitDate;

    @NotNull(message = "The origin program is required")
    private String originProgram;

    @NotNull(message = "The destination program is required")
    private String destinationProgram;

    @NotNull(message = "The type of mobility is required")
    private String city;

    @NotNull(message = "The country is required")
    private String country;

    @NotNull(message = "The state is required")
    private String teacher;

    @NotNull(message = "The city is required")
    private String faculty;

    @NotNull(message = "The department is required")
    private BigDecimal funding;

    @NotNull(message = "The funding source is required")
    private String fundingSource;

    @NotNull(message = "The destination is required")
    private String destination;

    @NotNull(message = "The origin is required")
    private String origin;

    private Long agreementId;

    private EventRequest event;

    private PersonData person;
}
