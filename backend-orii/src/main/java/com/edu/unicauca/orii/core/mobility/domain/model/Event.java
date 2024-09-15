package com.edu.unicauca.orii.core.mobility.domain.model;

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
public class Event {

    private Long eventId;
    private String description;
    
    private Form forms;
    private EventType eventType;
}
