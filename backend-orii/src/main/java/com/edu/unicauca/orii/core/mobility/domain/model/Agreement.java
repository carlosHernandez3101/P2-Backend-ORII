package com.edu.unicauca.orii.core.mobility.domain.model;
import java.util.Date;
import java.util.List;


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
    private String country;
    private String description;
    private String scope;
    private Date startDate;


    private List<Form> forms;
}
