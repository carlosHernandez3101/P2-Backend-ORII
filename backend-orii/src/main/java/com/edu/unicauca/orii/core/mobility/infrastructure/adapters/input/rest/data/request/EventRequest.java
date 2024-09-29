package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.request;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class EventRequest {

    @JsonIgnore
    private Long eventId;
    private String description;

    private Long eventTypeId;
}
