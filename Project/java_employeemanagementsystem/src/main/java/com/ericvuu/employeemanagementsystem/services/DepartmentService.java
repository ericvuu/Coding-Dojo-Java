package com.ericvuu.employeemanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.employeemanagementsystem.models.Department;
import com.ericvuu.employeemanagementsystem.repositories.DepartmentRepo;


@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepo departmentRepo;
	@Autowired
	private EmployeeService employeeService;
	
	public List<Department> allDepartments(){
		return departmentRepo.findAll();
	}
	
	public Department findDepartment(Long id) {
		Optional<Department> optionalDepartment = departmentRepo.findById(id);
		if(optionalDepartment.isPresent()) {
			return optionalDepartment.get();
		} else {
			return null;
		}
	}
	
	public Department createDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	public Department editDepartment(Department department) {
		return departmentRepo.save(department);
	}
	
	public void deleteDepartment(Long id) {
		departmentRepo.deleteById(id);
	}
	
	
	
}
