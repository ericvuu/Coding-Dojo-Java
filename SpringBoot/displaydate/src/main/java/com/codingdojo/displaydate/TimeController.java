package com.codingdojo.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TimeController {
	@RequestMapping("/time")
	public String time(Model model) {
		String timePattern = "h:mm a";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timePattern);
		String formatedTime = simpleDateFormat.format(new Date());
		model.addAttribute("time", formatedTime);
		return "time.jsp";
	}
}
