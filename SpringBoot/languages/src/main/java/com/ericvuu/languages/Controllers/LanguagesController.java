package com.ericvuu.languages.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ericvuu.languages.models.Language;
import com.ericvuu.languages.services.LanguageService;

@Controller
public class LanguagesController {
	
	private final LanguageService languageService;
	
	public LanguagesController(LanguageService languageService) {
		this.languageService = languageService;
	}

	@RequestMapping("/")
	public String redirect() {
		return "redirect:/languages";
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		return "/languages/index.jsp";
	}
	
	 @RequestMapping(path="/languages", method=RequestMethod.POST)
	 public String create(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
		 if (result.hasErrors()) {
				List<Language> languages = languageService.allLanguages();
				model.addAttribute("languages", languages);
	            return "/languages/index.jsp";			 
	        } else {
	            languageService.createlanguage(language);
	            return "redirect:/languages";
	        }
	 }
	 
	 @RequestMapping("/languages/{id}")
	 public String show(@PathVariable(value="id") Long id, Model model) {
		 Language language = languageService.findLanguage(id);
		 if(language != null) {
	    		model.addAttribute("language", language);
	        	return "/languages/show.jsp";
	    	} else {
	    		return "redirect:/languages";
	    	}
	 }
	 
	 @RequestMapping("/languages/{id}/edit")
	 public String edit(@PathVariable(value="id") Long id, Model model) {
		 Language language = languageService.findLanguage(id);
		 model.addAttribute("language", language);
		 return "/languages/edit.jsp";
	 }
	 
	 
	 @RequestMapping(path="/languages/{id}", method=RequestMethod.PUT)
	 public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		 if (result.hasErrors()) {	 
	         return "/languages/edit.jsp";
		 } else {
			 languageService.updateLanguage(language);
			 return "redirect:/languages";
		 }
		 
	 }
	 
	 @RequestMapping(path="/languages/{id}", method=RequestMethod.DELETE)
	 public String delete(@PathVariable(value="id") Long id) {
		 languageService.deleteLanguage(id);
		 return "redirect:/languages";
	 }
}
