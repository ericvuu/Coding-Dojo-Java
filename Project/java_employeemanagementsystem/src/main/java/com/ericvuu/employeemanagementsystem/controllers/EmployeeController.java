package com.ericvuu.employeemanagementsystem.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericvuu.employeemanagementsystem.models.Department;
import com.ericvuu.employeemanagementsystem.models.Employee;
import com.ericvuu.employeemanagementsystem.models.Position;
import com.ericvuu.employeemanagementsystem.services.DepartmentService;
import com.ericvuu.employeemanagementsystem.services.EmployeeService;
import com.ericvuu.employeemanagementsystem.services.PositionService;
import com.ericvuu.employeemanagementsystem.validator.EmployeeValidator;

@Controller
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private PositionService positionService;
	
	private ArrayList<String> allStates = new ArrayList<String>(Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
			"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX",
			"UT", "VT", "VA", "WA", "WV", "WI", "WY"));
	
	@GetMapping("/login")
	public String login(@ModelAttribute("employee") Employee employee, Model model) {
		return "login.jsp";
	}
	
	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		// if the user is authenticated, save their user id in session
		boolean isAuthenticated = employeeService.authenticateEmployee(email, password);
		Employee thisEmployee = employeeService.findByEmail(email);
		
		if (isAuthenticated && thisEmployee.getPosition().getPrivileges()) {
			session.setAttribute("employeeID", thisEmployee.getId());
			System.out.println(thisEmployee.getPosition().getPrivileges());
			return "redirect:/admin";
		} else if (isAuthenticated) {
			Long employeeID = thisEmployee.getId();
			session.setAttribute("employeeID", employeeID);
			return "redirect:/employee/" + employeeID;
		} else {
			System.out.println("User is not an Admin");
			// else, add error messages and return the login page
			redirectAttributes.addFlashAttribute("error", "Login Failure. Please contact your administrator.");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/admin")
	public String adminHome(HttpSession session) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			return "adminDash.jsp";
		} else {
			System.out.println("User does not have priviledges");
			return "redirect:/login";
		}	
	}
	
	@GetMapping("/admin/employees")
	public String showEmployees(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			List<Employee> allEmployees = employeeService.allEmployees();
			model.addAttribute("allEmployees", allEmployees);
			return "employee/viewEmployees.jsp";
		} else {
			System.out.println("User does not have priviledges");
			return "redirect:/login";
		}	
	}
	
	@GetMapping("/admin/employees/create")
	public String createEmployee(@ModelAttribute("employee") Employee employee, Model model, HttpSession session) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		Employee thisEmployee = employeeService.findEmployeeById(employeeID);
		
		if (thisEmployee.getId() != null && thisEmployee.getPosition().getPrivileges()) {
			List<Department> allDepartments = departmentService.allDepartments();
			List<Position> allPositions = positionService.allPositions();
			model.addAttribute("allDepartments", allDepartments);
			model.addAttribute("allPositions", allPositions);
			model.addAttribute("allStates", allStates);
			return "employee/addEmployee.jsp";
		} else {
			System.out.println("User does not have priviledges");
			return "redirect:/login";
		}
	}
	
	
	@PostMapping("/admin/employees/create")
	public String registerUser(@Valid @ModelAttribute("employee") Employee employee, BindingResult result, HttpSession session, Model model) {
		
		if(session.getAttribute("employeeID") == null){
			return "redirect:/login";
		}
		
		employeeValidator.validate(employee, result);
		// if result has errors, return the registration page
		if (result.hasErrors()) {
			List<Department> allDepartments = departmentService.allDepartments();
			List<Position> allPositions = positionService.allPositions();
			model.addAttribute("allDepartments", allDepartments);
			model.addAttribute("allPositions", allPositions);
			model.addAttribute("allStates", allStates);
			return "employee/addEmployee.jsp";
		} else {
			// else, save the user in the database, save the user id in session, and
			Employee thisEmployee = employeeService.createEmployee(employee);
			session.setAttribute("employeeID", thisEmployee.getId());
			return "redirect:/admin";
		}
	}
	
	
	@GetMapping("/employee/{id}")
	public String employeeHome(Model model, @PathVariable("id") Long id, HttpSession session) {
		
		Long employeeID = (Long) session.getAttribute("employeeID");
		
		if (employeeID != null) {
			Employee employee = employeeService.findEmployeeById(id);
			model.addAttribute("employee", employee);
			return "employee/employeeDash.jsp";
		} else {
			System.out.println("User is not logged in.");
			return "redirect:/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// invalidate session
		session.invalidate();
		// redirect to login page
		return "redirect:/";
	}
	
}
