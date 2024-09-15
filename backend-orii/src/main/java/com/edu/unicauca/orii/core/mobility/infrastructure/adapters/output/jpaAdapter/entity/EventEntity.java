package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "events")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Evento_seq")
    @SequenceGenerator(name = "Evento_seq", sequenceName = "Evento_seq", allocationSize = 1)
    private Long eventId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, length = 1024)
    private String description;

    // Relationship with Form
    @OneToOne(mappedBy = "event")
    private FormEntity forms;

    // Relationship with EventType
    @ManyToOne
    @JoinColumn(name = "event_type_id")
    private EventTypeEntity eventType;
}
