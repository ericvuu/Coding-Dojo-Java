package com.ericvuu.eventsbeltreviewer.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericvuu.eventsbeltreviewer.models.Event;
import com.ericvuu.eventsbeltreviewer.models.User;
import com.ericvuu.eventsbeltreviewer.services.CommentService;
import com.ericvuu.eventsbeltreviewer.services.EventService;
import com.ericvuu.eventsbeltreviewer.services.MessageService;
import com.ericvuu.eventsbeltreviewer.services.UserService;
import com.ericvuu.eventsbeltreviewer.validator.UserValidator;

@Controller
public class MainController {

	@Autowired
	private UserService userService;
	@Autowired
	private EventService eventService;
	@Autowired
	private MessageService messageService;
	@Autowired
	private CommentService commentService;
	@Autowired
	private UserValidator userValidator;

	private ArrayList<String> allStates = new ArrayList<String>(Arrays.asList("AL", "AK", "AZ", "AR", "CA", "CO", "CT",
			"DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS", "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO",
			"MT", "NE", "NV", "NH", "NJ", "NM", "NY", "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX",
			"UT", "VT", "VA", "WA", "WV", "WI", "WY"));

	@GetMapping("/")
	public String loginAndRegistration(@ModelAttribute("user") User user, Model model) {
		model.addAttribute("allStates", allStates);
		return "logAndReg.jsp";
	}

	@PostMapping("/registration")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			Model model) {
		userValidator.validate(user, result);
		// if result has errors, return the registration page
		if (result.hasErrors()) {
			model.addAttribute("allStates", allStates);
			return "logAndReg.jsp";
		} else {
			// else, save the user in the database, save the user id in session, and
			User thisUser = userService.registerUser(user);
			session.setAttribute("userID", thisUser.getId());
			return "redirect:/events";
		}
	}

	@PostMapping("/login")
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
			HttpSession session, RedirectAttributes redirectAttributes) {
		// if the user is authenticated, save their user id in session
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if (isAuthenticated) {
			User thisUser = userService.findByEmail(email);
			session.setAttribute("userID", thisUser.getId());
			return "redirect:/events";
		} else {
			// else, add error messages and return the login page
			redirectAttributes.addFlashAttribute("error", "Login Failure");
			return "redirect:/";
		}
	}

	@GetMapping("/events")
	public String events(@ModelAttribute("event") Event event, HttpSession session, Model model) {
		// get user from session, save them in the model and return the home page
		Long uID = (Long) session.getAttribute("userID");
		if (uID != null) {
			User thisUser = userService.findUserById(uID);
			model.addAttribute("inStateEvents", eventService.inStateEvents(thisUser.getState()));
			model.addAttribute("outOfStateEvents", eventService.outOfStateEvents(thisUser.getState()));
			model.addAttribute("allStates", allStates);
			model.addAttribute("user", thisUser);
			return "events.jsp";
		} else {
			System.out.println("Not Signed in.");
			return "redirect:/";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// invalidate session
		session.invalidate();
		// redirect to login page
		return "redirect:/";
	}

	@PostMapping("/createEvent")
	public String createEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			Long uID = (Long) session.getAttribute("userID");
			User thisUser = userService.findUserById(uID);
			model.addAttribute("inStateEvents", eventService.inStateEvents(thisUser.getState()));
			model.addAttribute("user", thisUser);
			model.addAttribute("allStates", allStates);
			return "events.jsp";
		} else {
			eventService.createEvent(event);
			Long uID = (Long) session.getAttribute("userID");
			User thisUser = userService.findUserById(uID);
			eventService.addHost(thisUser, event);
			return "redirect:/events";
		}
	}

	@GetMapping("/events/{id}")
	public String showEvent(Model model, @PathVariable("id") Long id) {
		Event event = eventService.findEvent(id);
		model.addAttribute("event", event);
		return "showEvent.jsp";
	}
	
	@GetMapping("/events/{id}/edit")
	public String editEvent(@ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model model) {
		Event thisEvent = eventService.findEvent(id);
		model.addAttribute("e", thisEvent);
		model.addAttribute("allStates", allStates);
		return "editEvent.jsp";
	}
	
	@PostMapping("/events/{id}/edit")
	public String processEditEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, @PathVariable("id") Long id, Model model) {
		if(result.hasErrors()) {
			Event thisEvent = eventService.findEvent(id);
			model.addAttribute("e", thisEvent);
			model.addAttribute("allStates", allStates);
			return "editEvent.jsp";
		} else {
			eventService.editEvent(event);
			return "redirect:/events";
		}
	}
	
	@PostMapping("/events/{id}/join")
	public String joinEvent(@PathVariable("id") Long id, HttpSession session) {
		Event thisEvent = eventService.findEvent(id);
		Long uID = (Long) session.getAttribute("userID");
		User thisUser = userService.findUserById(uID);
		userService.joinEvent(thisUser, thisEvent);
		return "redirect:/events/" + id;
	}

}
