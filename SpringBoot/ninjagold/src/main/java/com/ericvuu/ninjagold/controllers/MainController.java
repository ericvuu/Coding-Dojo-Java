package com.ericvuu.ninjagold.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Random;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {
	
	Random random=new Random();
	ArrayList<String> activityLog = new ArrayList<String>();
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("amount") == null) {
			session.setAttribute("amount", 0);
		}
		;
		return "index";
	}
	
	@RequestMapping(value="/processMoney", method=RequestMethod.POST)
	public String processMoney(@RequestParam(value="which_form") String location, HttpSession session) {
		
		String timeDatePattern = "MMMM dd, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(timeDatePattern);
		String formatedDateTime = simpleDateFormat.format(new Date());
		
		if(location.equals("farm")) {
			int gold = random.nextInt(21 - 10) + 10;
			int currentAmount = (int) session.getAttribute("amount");
			session.setAttribute("amount", currentAmount + gold);
		
			String activity = "You earned " + gold + " gold from the farm." + " (" + formatedDateTime + ")";
			activityLog.add(activity);
			
		} else if(location.equals("cave")) {
			int gold = random.nextInt(11 - 5) + 5;
			int currentAmount = (int) session.getAttribute("amount");
			session.setAttribute("amount", currentAmount + gold);			

			String activity = "You earned " + gold + " gold from the cave." + " (" + formatedDateTime + ")";
			activityLog.add(activity);
			
		} else if(location.equals("house")) {
			int gold = random.nextInt(6 - 2) + 2;
			int currentAmount = (int) session.getAttribute("amount");
			session.setAttribute("amount", currentAmount + gold);

			String activity = "You earned " + gold + " gold from the house." + " (" + formatedDateTime + ")";
			activityLog.add(activity);
			
		} else {
			int gold = random.nextInt(101)-50;
			
			if(gold < 0) {
				int currentAmount = (int) session.getAttribute("amount");
				session.setAttribute("amount", currentAmount + gold);
				String activity = "You loss " + gold + " gold from the casino." + " (" + formatedDateTime + ")";
				activityLog.add(activity);
			} else {
				int currentAmount = (int) session.getAttribute("amount");
				session.setAttribute("amount", currentAmount + gold);
				String activity = "You earned " + gold + " gold from the casino." + " (" + formatedDateTime + ")";
				activityLog.add(activity);
			}
		}
		
		session.setAttribute("activityLog", activityLog);
		System.out.print(activityLog);
		return "redirect:/";
	}
}
