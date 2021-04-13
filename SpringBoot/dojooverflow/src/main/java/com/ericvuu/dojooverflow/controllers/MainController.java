package com.ericvuu.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ericvuu.dojooverflow.models.Question;
import com.ericvuu.dojooverflow.services.AnswerService;
import com.ericvuu.dojooverflow.services.QuestionService;
import com.ericvuu.dojooverflow.services.TagService;

@Controller
public class MainController {
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private TagService tagService;
	
	@Autowired
	private AnswerService answerService;
	
	@GetMapping("/")
	public String redirectToDashboard() {
		return "redirect:/questions";
	}
	
	@GetMapping("questions")
	public String dashboard(Model model) {
		List<Question> allQuestions = questionService.getAllQuestions();
		model.addAttribute("allQuestions", allQuestions);
		return "dashboard.jsp";
	}
	
	@GetMapping("questions/new")
	public String newQuestion(@ModelAttribute("newQuestion") Question question) {
		return "new_question.jsp";
	}
	
	@PostMapping("questions/new")
	public String createQuestion(@Valid @ModelAttribute("newQuestion") Question question, BindingResult result) {
		if(result.hasErrors()) {
			return "new_question.jsp";
		} else {
			// add each tag to our question that was submitted
			return "redirect:/";
		}
	}
	
	@GetMapping("questions/{id}")
	public String showQuestion() {
		return "show_question.jsp";
	}
	
	
}
