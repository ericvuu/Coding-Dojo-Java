package com.ericvuu.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ericvuu.dojooverflow.models.Answer;
import com.ericvuu.dojooverflow.repositories.AnswerRepo;

@Repository
public class AnswerService {
	
	@Autowired
	private AnswerRepo answerRepo;
	
	public List<Answer> getAllAnswers(){
		return answerRepo.findAll();
	}
	
	public Answer createAnswer(Answer answer){
		return answerRepo.save(answer);
	}
	
	public Answer findAnswer(Long id){
		Optional<Answer> optionalAnswer = answerRepo.findById(id);
		if(optionalAnswer.isPresent()) {
			return optionalAnswer.get();
		} else {
			return null;
		}
	}
}
