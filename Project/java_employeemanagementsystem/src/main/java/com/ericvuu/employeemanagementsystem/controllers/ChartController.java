package com.ericvuu.employeemanagementsystem.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RestController;

import com.ericvuu.employeemanagementsystem.models.Department;
import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.models.Position;
import com.ericvuu.employeemanagementsystem.services.DepartmentService;

@RestController
public class ChartController {
	
	@Autowired
	DepartmentService departmentService;
	
	@GetMapping("/charts/department/employees")
	public Map<String, String> getDepartmentEmployees(){
		
		HashMap<String, String> map = new HashMap<>();
		List<Department> allDepartments = departmentService.allDepartments();
		
		for(Department d: allDepartments) {
			int size = d.getEmployees().size();
			String str = Integer.toString(size);
			map.put(d.getName(), str);
		}
		
		return map;
	}
	
	@GetMapping("/charts/department/salary")
	public Map<String, String> getDepartmentSalary(){
		
		HashMap<String, String> map = new HashMap<>();
		List<Department> allDepartments = departmentService.allDepartments();
		
		for(Department d: allDepartments) {
			Double deptWage = (double) 0;
			for(Employee e: d.getEmployees()) {
				Position thisPosition = e.getPosition();
				deptWage += thisPosition.getWage();
			}
			String str = Double.toString(deptWage);
			map.put(d.getName(), str);
		}
		return map;
	}
}
