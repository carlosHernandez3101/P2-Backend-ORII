package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.response;

import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.EventTypeData;

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
public class EventResponse {

    private Long eventId;
    private String description;

    private EventTypeData eventType;
}
