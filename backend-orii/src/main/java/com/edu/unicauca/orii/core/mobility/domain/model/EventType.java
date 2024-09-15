package com.edu.unicauca.orii.core.mobility.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventType {
    private Long eventTypeId;
    private String name;

    private List<Event> events;
}
