package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.devlocal.mappers;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Sex;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.devlocal.PersonLocalDao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface PersonLocalDaoMapper {

    @Mapping(source = "sex", target = "sex", qualifiedByName = "sexEnumToString")
    PersonLocalDao domainToLocalDao(Person person);

    @Mapping(source = "sex", target="sex", qualifiedByName = "sexStringToEnum")
    Person localDaoToDomain(PersonLocalDao personLocalDao);


    @Named("sexEnumToString")
    default String sexEnumToString(Sex sex){
        return sex.name();
    }

    @Named("sexStringToEnum")
    default Sex sexStringToEnum(String sex){
        return Sex.valueOf(sex);
    }
}
