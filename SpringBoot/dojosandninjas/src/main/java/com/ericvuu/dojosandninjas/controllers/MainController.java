package com.ericvuu.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ericvuu.dojosandninjas.models.Dojo;
import com.ericvuu.dojosandninjas.models.Ninja;
import com.ericvuu.dojosandninjas.services.DojoService;
import com.ericvuu.dojosandninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private NinjaService ninjaService;
	@Autowired
	private DojoService dojoService;
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/new")
	public String dojoForm(@ModelAttribute("dojo") Dojo dojo, Model model) {
		return "dojo_form.jsp";
	}
	
	@RequestMapping("/addDojo")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "dojo_form.jsp";
		} else {
			dojoService.addDojo(dojo);
			return "redirect:dojos/new";
		}
	}
	
	@RequestMapping("/ninjas/new")
	public String ninjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja_form.jsp";
	}
	
	@RequestMapping("/addNinja")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ninja_form.jsp";
		} else {
			ninjaService.addNinja(ninja);
			return "redirect:ninjas/new";
		}
	}
	
	@RequestMapping("/dojos/{id}")
	public String dojoAndNinjas(@PathVariable("id") Long id, Model model) {
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo", dojo);
		return "show_info.jsp";
	}
	
}
