package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.edu.unicauca.orii.core.mobility.domain.model.Event;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.EventEntity;

@Mapper(componentModel = "spring")
public interface IEventAdapterMapper {

    @Mapping(target = "forms", ignore = true)
    @Mapping(target = "eventType", ignore = true)
    EventEntity toEventEntity(Event event);

    @Mapping(target = "forms", ignore = true)
    Event toEvent(EventEntity eventEntity);
}
