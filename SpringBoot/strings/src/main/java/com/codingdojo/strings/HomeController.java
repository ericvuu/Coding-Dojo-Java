package com.codingdojo.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/")
	public String Hello() {
		return "Hello Client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String Random() {
		return "String Boot is great! So easy to just respond with strings.";
	}
}
