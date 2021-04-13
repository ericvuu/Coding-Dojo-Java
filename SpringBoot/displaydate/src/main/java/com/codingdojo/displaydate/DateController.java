package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	@RequestMapping("/date")
	public String date(Model model) {
		String alphaDay = "EEEE";
		String day = "dd";
		String monthYear = "MMMM, yyyy";
		
		SimpleDateFormat alphaDayFormat = new SimpleDateFormat(alphaDay);
		SimpleDateFormat dayFormat = new SimpleDateFormat(day);
		SimpleDateFormat monthYearFormat = new SimpleDateFormat(monthYear);
		
		String alphaDayFormated = alphaDayFormat.format(new Date());
		String dayFormated = dayFormat.format(new Date());
		String monthYearFormated = monthYearFormat.format(new Date());
		
		String finalString = alphaDayFormated + ", the " + dayFormated + " of " + monthYearFormated;
		
		model.addAttribute("finalString", finalString);
		
		return "date.jsp";
	}
}
