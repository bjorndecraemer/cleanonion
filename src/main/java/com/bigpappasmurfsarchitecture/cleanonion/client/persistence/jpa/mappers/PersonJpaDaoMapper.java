package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa.mappers;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa.PersonJpaEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonJpaDaoMapper {

    PersonJpaEntity modelToJpaEntity(Person person);
    Person jpaEntityToModel(PersonJpaEntity personJpaEntity);
}
