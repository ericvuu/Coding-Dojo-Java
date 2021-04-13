package com.ericvuu.employeemanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.repositories.EmployeeRepo;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public List<Employee> allEmployees(){
		return employeeRepo.findAll();
	}
	
	public Employee findEmployee(Long id) {
		Optional<Employee> optionalEmployee = employeeRepo.findById(id);
		if(optionalEmployee.isPresent()) {
			return optionalEmployee.get();
		} else {
			return null;
		}
	}
	

	// register employee and hash their password
	public Employee createEmployee(Employee employee) {
		String hashed = BCrypt.hashpw(employee.getPassword(), BCrypt.gensalt());
		employee.setPassword(hashed);
		return employeeRepo.save(employee);
	}

	// find employee by email
	public Employee findByEmail(String email) {
		return employeeRepo.findByEmail(email);
	}

	// find employee by id
	public Employee findEmployeeById(Long id) {
		Optional<Employee> e = employeeRepo.findById(id);

		if (e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}

	// authenticate employee
	public boolean authenticateEmployee(String email, String password) {
		// first find the employee by email
		Employee employee = employeeRepo.findByEmail(email);
		// if we can't find it by email, return false
		if (employee == null) {
			return false;
		} else {
			// if the passwords match, return true, else, return false
			if (BCrypt.checkpw(password, employee.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
	
	public List<Employee> employeesInDepartment(Long id) {
    	return employeeRepo.findByDepartmentId(id);
	}
	
	
}
