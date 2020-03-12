package com.bigpappasmurfsarchitecture.cleanonion.client.persistence.devlocal;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.Person;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.PersonPersistenceFacade;
import com.bigpappasmurfsarchitecture.cleanonion.client.persistence.devlocal.mappers.PersonLocalDaoMapper;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Profile("localdao")
@Service
public class PersonLocalPersistenceService implements PersonPersistenceFacade {

    private Map<UUID, PersonLocalDao> personMap = new HashMap<>();

    private final PersonLocalDaoMapper personLocalDaoMapper;

    public PersonLocalPersistenceService(PersonLocalDaoMapper personLocalDaoMapper) {
        this.personLocalDaoMapper = personLocalDaoMapper;
    }

    @Override
    public Person createPerson(Person person) {
        UUID uuid = UUID.randomUUID();
        PersonLocalDao personLocalDao = personLocalDaoMapper.domainToLocalDao(person);
        personLocalDao.setId(uuid);
        personMap.put(uuid,personLocalDao);
        return personLocalDaoMapper.localDaoToDomain(personLocalDao);
    }

    @Override
    public Person findPersonById(UUID id) {
        if( personMap.containsKey(id))
            return personLocalDaoMapper.localDaoToDomain(personMap.get(id));
        return null;
    }

    @Override
    public List<Person> findPersonsByFirstName(String firstName) {
        return personMap
                .values()
                .stream()
                .filter(personLocalDao -> personLocalDao.getFirstName() != null &&
                        personLocalDao.getFirstName().equalsIgnoreCase(firstName))
                .map(personLocalDaoMapper::localDaoToDomain)
                .collect(Collectors.toList());
    }
}
