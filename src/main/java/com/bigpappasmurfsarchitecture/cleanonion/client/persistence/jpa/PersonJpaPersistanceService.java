package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.PersonPersistenceFacade;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.jpa.mappers.PersonJpaDaoMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Profile("jpadao")
@Service
public class PersonJpaPersistanceService implements PersonPersistenceFacade {

    private final PersonJpaRepository repository;
    private final PersonJpaDaoMapper mapper;

    public PersonJpaPersistanceService(PersonJpaRepository repository, PersonJpaDaoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Person createPerson(Person person) {
        return mapper.jpaEntityToModel(repository.save(mapper.modelToJpaEntity(person)));
    }

    @Override
    public Person findPersonById(UUID id) {
        return mapper.jpaEntityToModel(repository.findById(id).orElse(null));
    }

    @Override
    public List<Person> findPersonsByFirstName(String firstName) {
        return repository.findAllByFirstName(firstName)
                .stream()
                .map(mapper::jpaEntityToModel)
                .collect(Collectors.toList());
    }
}
