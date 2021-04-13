package com.ericvuu.driverslicense.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericvuu.driverslicense.models.License;
import com.ericvuu.driverslicense.models.Person;
import com.ericvuu.driverslicense.services.LicenseService;
import com.ericvuu.driverslicense.services.PersonService;

@Controller
public class LicenseController {

	private final LicenseService licenseService;
	private final PersonService personService;
	
	public LicenseController(LicenseService licenseService, PersonService personService) {
		this.licenseService = licenseService;
		this.personService = personService;
	}
	
	
	@RequestMapping("/licenses/new")
	public String createLicense(@ModelAttribute("license") License license, Model model) {
		List<Person> allPeople = personService.allPeople();
		model.addAttribute("allPeople", allPeople);
		return "new-license.jsp";
	}
	
	@RequestMapping(value="/addLicense", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("license") License license, BindingResult result) {
		 if (result.hasErrors()) {
	            return "new-license.jsp";			 
	        } else {
	            licenseService.createLicense(license);
	            return "redirect:/licenses/new";
	        }
	 }
}
