package com.codingdojo.counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	int count = 0;
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		count++;
		session.setAttribute("sessionCount", count);
		return "counter.jsp";
	}
}
