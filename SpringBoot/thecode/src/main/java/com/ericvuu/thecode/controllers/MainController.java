package com.ericvuu.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@RequestMapping(value="/checkCode", method = RequestMethod.POST)
	public String checkCode(@RequestParam(value="codeInput") String codeInput, RedirectAttributes redirectAttributes) {
		if(codeInput.equals( "bushido")) {
			return "code.jsp";
		} else {
			redirectAttributes.addFlashAttribute("error", "You must train harder!");
			return "redirect:/";
		}
	}
}
