package com.bigpappasmurfsarchitecture.cleanonion.client.web.in.mappers;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Sex;
import com.bigpappasmurfsarchitecture.cleanonion.client.web.dto.PersonCreateResource;
import com.bigpappasmurfsarchitecture.cleanonion.client.web.dto.PersonResource;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersonDtoMapper {

    @Mapping(source = "sex", target = "sex", qualifiedByName = "sexEnumToString")
    PersonResource domainToDto(Person person);

    @Mapping(source = "sex", target="sex", qualifiedByName = "sexStringToEnum")
    Person dtoToDomain(PersonCreateResource personCreateResource);

    @Named("sexEnumToString")
    default String sexEnumToString(Sex sex){
        return sex.name();
    }

    @Named("sexStringToEnum")
    default Sex sexStringToEnum(String sex){
        return Sex.valueOf(sex);
    }
}
