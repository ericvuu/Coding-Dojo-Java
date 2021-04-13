package com.ericvuu.dojosurvey.homecontroller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/process", method=RequestMethod.POST)
	public String process(@RequestParam(value="nameInput")String name, @RequestParam(value="dojoInput")String dojo, @RequestParam(value="languageInput")String language, @RequestParam(value="comments")String comment, HttpSession session){
		session.setAttribute("name", name);
		session.setAttribute("dojo", dojo);
		session.setAttribute("language", language);
		
		if(comment.equals("")) {
			String noComment = "No Comment Submitted";
			session.setAttribute("comment", noComment);
		} else {
			session.setAttribute("comment", comment);
		}
		
		return "redirect:/result";
	}
	
	@RequestMapping("/result")
	public String result() {
		return "result";
	}
}
