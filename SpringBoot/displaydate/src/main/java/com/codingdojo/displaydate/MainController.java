package com.codingdojo.displaydate;

//import java.text.SimpleDateFormat;
//import java.util.*;

import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
//	@RequestMapping("/date")
//	public String date(Model model) {
//		String alphaDay = "EEEE";
//		String day = "dd";
//		String monthYear = "MMMM, yyyy";
//		
//		SimpleDateFormat alphaDayFormat = new SimpleDateFormat(alphaDay);
//		SimpleDateFormat dayFormat = new SimpleDateFormat(day);
//		SimpleDateFormat monthYearFormat = new SimpleDateFormat(monthYear);
//		
//		String alphaDayFormated = alphaDayFormat.format(new Date());
//		String dayFormated = dayFormat.format(new Date());
//		String monthYearFormated = monthYearFormat.format(new Date());
//		
//		String finalString = alphaDayFormated + ", the " + dayFormated + " of " + monthYearFormated;
//		
//		model.addAttribute("finalString", finalString);
//		
//		return "date.jsp";
//	}
	


//	@RequestMapping("/time")
//	public String time(Model model) {
//		String timePattern = "h:mm a";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timePattern);
//		String formatedTime = simpleDateFormat.format(new Date());
//		model.addAttribute("time", formatedTime);
//		return "time.jsp";
//	}
}


