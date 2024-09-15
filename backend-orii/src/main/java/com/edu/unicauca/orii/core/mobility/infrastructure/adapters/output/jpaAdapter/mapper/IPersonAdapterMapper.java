package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.edu.unicauca.orii.core.mobility.domain.model.Person;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.output.jpaAdapter.entity.PersonEntity;

@Mapper(componentModel = "spring")
public interface IPersonAdapterMapper {

    @Mapping(target = "forms", ignore = true)
    Person toPerson(PersonEntity personEntity);

    @Mapping(target = "forms", ignore = true)
    PersonEntity toPersonEntity(Person person);
}
