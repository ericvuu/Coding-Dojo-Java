package com.ericvuu.employeemanagementsystem.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.ericvuu.employeemanagementsystem.models.Department;
import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.services.DepartmentService;
import com.ericvuu.employeemanagementsystem.services.EmployeeService;

@Controller
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("admin/departments")
	public String showDepartments(@ModelAttribute("department") Department department, HttpSession session, Model model) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			List<Department> allDepartments = departmentService.allDepartments();
			model.addAttribute("allDepartments", allDepartments);
			return "department/viewDepartments.jsp";
		} else {
			System.out.println("User does not have priviledges");
			return "redirect:/login";
		}
	}
	
	@GetMapping("admin/departments/create")
	public String createDepartment(@ModelAttribute("department") Department department, HttpSession session) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			return "department/addDepartment.jsp";
		} else {
			System.out.println("User does not have priviledges");
			System.out.println(thisEmployee.getId());
			return "redirect:/login";
		}
	}
	
	@PostMapping("admin/departments/create")
	public String createDepartment(@Valid @ModelAttribute("department") Department department, BindingResult result) {
		if (result.hasErrors()) {
			return "department/addDepartment.jsp";
		} else {
			departmentService.createDepartment(department);
			return "redirect:/admin/departments";
		}
	}
	
	
}
