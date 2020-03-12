package com.bigpappasmurfsarchitecture.cleanonion.client.web.in;

import com.bigpappasmurfsarchitecture.cleanonion.client.domain.services.PersonService;
import com.bigpappasmurfsarchitecture.cleanonion.client.web.dto.PersonCreateResource;
import com.bigpappasmurfsarchitecture.cleanonion.client.web.dto.PersonResource;
import com.bigpappasmurfsarchitecture.cleanonion.client.web.in.mappers.PersonDtoMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/client")
public class PersonController {

    private final PersonService personService;
    private final PersonDtoMapper personDtoMapper;

    public PersonController(PersonService personService, PersonDtoMapper personDtoMapper) {
        this.personService = personService;
        this.personDtoMapper = personDtoMapper;
    }

    @GetMapping("/{id}")
    public PersonResource findById(@PathVariable UUID id) {
        return personDtoMapper.domainToDto(personService.findById(id));
    }

    @GetMapping
    public List<PersonResource> findById(@RequestParam String firstName) {
        return personService.findByFirstName(firstName).stream().map(personDtoMapper::domainToDto).collect(Collectors.toList());
    }

    @PostMapping
    public PersonResource createPerson(@RequestBody PersonCreateResource personCreateResource){
        return personDtoMapper.domainToDto(personService.createPerson(personDtoMapper.dtoToDomain(personCreateResource)));
    }
}
