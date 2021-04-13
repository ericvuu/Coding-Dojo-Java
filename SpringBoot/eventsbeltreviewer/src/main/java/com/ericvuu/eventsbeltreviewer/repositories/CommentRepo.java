package com.ericvuu.eventsbeltreviewer.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.eventsbeltreviewer.models.Comment;


@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
	
	List<Comment>findAll();
}
