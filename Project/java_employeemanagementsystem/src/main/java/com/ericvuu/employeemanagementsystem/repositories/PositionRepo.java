package com.ericvuu.employeemanagementsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.employeemanagementsystem.models.Position;

@Repository
public interface PositionRepo extends CrudRepository<Position, Long>{
	
	List<Position>findAll();
}
