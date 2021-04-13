package com.ericvuu.driverslicense.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.ericvuu.driverslicense.models.Person;
import com.ericvuu.driverslicense.repositories.PersonRepository;


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
	
	public List<Person>peopleWithoutLicenses(){
		List<Person> list = personRepository.findAll();
		for(Person person: list) {
			if(person.getLicense() != null) {
				list.remove(person);
			}
		}
		return list;
	}
}
