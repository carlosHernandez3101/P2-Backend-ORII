package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;

import com.edu.unicauca.orii.core.mobility.domain.model.Event;
import com.edu.unicauca.orii.core.mobility.domain.model.EventType;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.request.EventRequest;

@Mapper(componentModel = "spring")
public interface IEventRestMapper {


    default Event toEvent(EventRequest eventRequest) {
        return Event.builder()
            .description(eventRequest.getDescription())
            .eventType(EventType.builder()
                                .eventTypeId(eventRequest.getEventTypeId())
                                .build())
            .build();
    }

}
