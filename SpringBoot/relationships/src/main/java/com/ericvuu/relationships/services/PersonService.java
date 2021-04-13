package com.ericvuu.relationships.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ericvuu.relationships.models.Person;
import com.ericvuu.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	
	private final PersonRepository personRepository;
	
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<Person> allPeople() {
		return personRepository.findAll();
	}
	
	public Person createPerson(Person person) {
		return personRepository.save(person);
	}
	
}
