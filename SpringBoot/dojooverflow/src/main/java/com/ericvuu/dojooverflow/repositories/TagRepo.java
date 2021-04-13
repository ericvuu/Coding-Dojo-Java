package com.ericvuu.dojooverflow.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.dojooverflow.models.Tag;

@Repository
public interface TagRepo extends CrudRepository<Tag, Long> {
	
	List<Tag> findAll();
	
	List<Tag> findAllBySubject(String subject);
}
