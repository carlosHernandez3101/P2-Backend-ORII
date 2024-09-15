package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity;

import java.util.List;

import com.edu.unicauca.orii.core.mobility.domain.enums.AgreementStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "agreements")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AgreementEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "agreement_seq")
    @SequenceGenerator(name = "agreement_seq", sequenceName = "agreement_seq", allocationSize = 1)
    @Column(name = "id_agreement")
    private Long agreementId;

    @Column(nullable = false)
    private String institution;

    @Column(nullable = false)
    private String agreementNumber;

    @Column(nullable = false)
    private String country;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AgreementStatus status;

    // Relationship with Form
    @OneToMany(mappedBy = "agreement")
    private List<FormEntity> forms;
}
