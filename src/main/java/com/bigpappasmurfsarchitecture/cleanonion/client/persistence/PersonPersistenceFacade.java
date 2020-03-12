package com.bigpappasmurfsarchitecture.cleanonion.client.persistence;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;

import java.util.List;
import java.util.UUID;

public interface PersonPersistenceFacade {
    Person createPerson(Person person);
    Person findPersonById(UUID id);
    List<Person> findPersonsByFirstName(String firstName);
}
