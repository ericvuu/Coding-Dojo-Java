package com.codingdojo.hellohuman;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class QueryController {
	
	@RequestMapping("/")
	public String index(@RequestParam(value="name", required=false) String nameQuery, Model model) {
		if(nameQuery == null) {
			model.addAttribute("name", "Human");
			return "index.jsp";
		} else {
			model.addAttribute("name", nameQuery);
			return "index.jsp";
		}
	}
}
