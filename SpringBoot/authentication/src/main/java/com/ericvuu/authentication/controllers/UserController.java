package com.ericvuu.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ericvuu.authentication.models.User;
import com.ericvuu.authentication.services.UserService;
import com.ericvuu.authentication.validator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	private UserValidator userValidator;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String redirect(HttpSession session) {
		Long uID = (Long) session.getAttribute("userID");
		if(uID != null) {
			return "redirect:/home";
		} else {
		return "redirect:/login";
		}
	}

	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}

	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValidator.validate(user, result);
		// if result has errors, return the registration page 
		if(result.hasErrors()) {
			return "registrationPage.jsp";
		} else {
			// else, save the user in the database, save the user id in session, and
			User thisUser = userService.registerUser(user);
			session.setAttribute("userID", thisUser.getId());
			// redirect them to the /home route
			return "redirect:/home";
		}
	}

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectAttributes) {
		// if the user is authenticated, save their user id in session
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User thisUser = userService.findByEmail(email);
			session.setAttribute("userID", thisUser.getId());
			return "redirect:/home";
		} else {
			// else, add error messages and return the login page
			redirectAttributes.addFlashAttribute("error", "Login Failure");
			return "redirect:/login";
		}
	}

	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		// get user from session, save them in the model and return the home page
		Long uID = (Long) session.getAttribute("userID");
	    	if(uID != null) {	
			User thisUser = userService.findUserById(uID);
	    	model.addAttribute("user", thisUser);
	    	return "homePage.jsp";
	    } else {
	    	System.out.println("Not Signed in.");
	    	return "redirect:/login";
	    }
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		// invalidate session
		session.invalidate();
		// redirect to login page
		return "redirect:/login";
	}
}
