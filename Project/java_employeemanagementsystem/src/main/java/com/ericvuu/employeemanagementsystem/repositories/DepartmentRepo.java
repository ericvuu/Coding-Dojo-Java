package com.ericvuu.employeemanagementsystem.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ericvuu.employeemanagementsystem.models.Department;

@Repository
public interface DepartmentRepo extends CrudRepository<Department, Long>{
	
	List<Department>findAll();
	
}

