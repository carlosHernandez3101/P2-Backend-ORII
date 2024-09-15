package com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.edu.unicauca.orii.core.mobility.domain.model.Person;
import com.edu.unicauca.orii.core.mobility.infrastructure.adapters.input.rest.data.PersonData;


@Mapper(componentModel = "spring")
public interface IPersonRestMapper {

    @Mapping(target = "forms", ignore = true)
    Person toPerson(PersonData personData);

}
