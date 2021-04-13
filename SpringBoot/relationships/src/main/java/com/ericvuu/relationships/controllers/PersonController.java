package com.ericvuu.relationships.controllers;

//import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.ericvuu.relationships.models.Person;
import com.ericvuu.relationships.services.LicenseService;
import com.ericvuu.relationships.services.PersonService;

@Controller
public class PersonController {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public PersonController(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@RequestMapping("/persons/new")
		public String createPerson(@ModelAttribute("person") Person person, Model model) {
			return "new-person.jsp";
		}
	
	@RequestMapping(path="/addPerson", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("person") Person person, BindingResult result) {
		 if (result.hasErrors()) {
	            return "/persons/new.jsp";			 
	        } else {
	            personService.createPerson(person);
	            return "redirect:/person/new";
	        }
	 }
}
