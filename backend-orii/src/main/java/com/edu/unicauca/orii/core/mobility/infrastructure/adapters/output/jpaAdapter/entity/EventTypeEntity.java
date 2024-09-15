package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
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
import lombok.Setter;

@Entity
@Table(name = "event_type")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventTypeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EventType_seq")
    @SequenceGenerator(name = "EventType_seq", sequenceName = "EventType_seq", allocationSize = 1)
    private Long eventTypeId;

    private String name;

    @OneToMany(mappedBy = "eventType", cascade = CascadeType.ALL)
    private List<EventEntity> events;
    
}
