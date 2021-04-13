package com.ericvuu.relationships.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.relationships.models.License;
import com.ericvuu.relationships.models.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
	
	List<Person>findAll();
	
	Optional<Person>findByLicenseNumber(License license);
}
