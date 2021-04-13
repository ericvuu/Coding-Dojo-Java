package com.ericvuu.employeemanagementsystem.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.models.Position;
import com.ericvuu.employeemanagementsystem.services.EmployeeService;
import com.ericvuu.employeemanagementsystem.services.PositionService;

@Controller
public class PositionController {
	
	@Autowired
	private PositionService positionService;
	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/admin/positions/create")
	public String positionsForm(@ModelAttribute("position") Position position, HttpSession session) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			return "position/addPosition.jsp";
		} else {
			System.out.println("User is not logged in.");
			return "redirect:/login";
		}
	}

	@PostMapping("/admin/positions/create")
	public String createPosition(@Valid @ModelAttribute("position") Position position, BindingResult result) {
		if (result.hasErrors()) {
			return "position/addPosition.jsp";
		} else {
		positionService.createPosition(position);
		return "redirect:/admin/";
		}
	}
}
