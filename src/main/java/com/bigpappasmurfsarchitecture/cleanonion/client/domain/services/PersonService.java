package com.bigpappasmurfsarchitecture.cleanonion.client.domain.services;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.PersonPersistenceFacade;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PersonService {

    private final PersonPersistenceFacade personPersistenceFacade;

    public PersonService(PersonPersistenceFacade personPersistenceFacade) {
        this.personPersistenceFacade = personPersistenceFacade;
    }

    public Person findById(UUID id){
        return personPersistenceFacade.findPersonById(id);
    }

    public List<Person> findByFirstName(String firstName){
        return personPersistenceFacade.findPersonsByFirstName(firstName);
    }
    public Person createPerson(Person person){
        return personPersistenceFacade.createPerson(person);
    }
}
