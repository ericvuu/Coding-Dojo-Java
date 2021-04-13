package com.ericvuu.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.dojooverflow.models.Question;
import com.ericvuu.dojooverflow.models.Tag;
import com.ericvuu.dojooverflow.repositories.QuestionRepo;
import com.ericvuu.dojooverflow.repositories.TagRepo;

@Service
public class QuestionService {
	
	@Autowired
	private QuestionRepo questionRepo;
	
	@Autowired
	private TagRepo tagRepo;
	
	public List<Question> getAllQuestions(){
		return questionRepo.findAll();
	}
	
	public Question createQuestionWithTags(Question questAndTag){
		List<Tag> tag = new ArrayList<Tag>();
		
		return questionRepo.save(questAndTag);
	}
	
	public Question findQuestion(Long id){
		Optional<Question> optionalQuestion = questionRepo.findById(id);
		if(optionalQuestion.isPresent()) {
			return optionalQuestion.get();
		} else {
			return null;
		}
	}
	
}
