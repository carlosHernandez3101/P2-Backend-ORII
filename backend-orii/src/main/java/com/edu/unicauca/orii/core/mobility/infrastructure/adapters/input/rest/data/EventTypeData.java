package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data;


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
public class EventTypeData {

    private Long eventTypeId;
    private String name;
  
}
