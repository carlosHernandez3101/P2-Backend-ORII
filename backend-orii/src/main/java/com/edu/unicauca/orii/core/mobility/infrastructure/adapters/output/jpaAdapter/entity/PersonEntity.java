package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity;

import java.util.List;

import com.edu.unicauca.orii.core.mobility.domain.enums.IdentificationTypeEnum;
import com.edu.unicauca.orii.core.mobility.domain.enums.PersonTypeEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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


@Entity
@Getter
@Table(name = "persons")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
    @Column(name = "id_person")
    private Long personId;

    @Column(nullable = false)
    private IdentificationTypeEnum identificationType;

    @Column(nullable = false)
    private PersonTypeEnum personType;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String identification;

    private String email;

    // Relationship with Form
    @OneToMany(mappedBy = "person")
    private List<FormEntity> forms;
}
