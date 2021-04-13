package com.ericvuu.dojooverflow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.dojooverflow.models.Tag;
import com.ericvuu.dojooverflow.repositories.TagRepo;

@Service
public class TagService {
	
	@Autowired
	private TagRepo tagRepo;
	
	public List<Tag> getAllTags() {
		return tagRepo.findAll();
	}
	
	public Tag createOrRetrieveTag(Tag tag){
		// check if inputed tag is present but grabbing subject attribute
		String subject = tag.getSubject();
		if (tagRepo.findAllBySubject(subject).size() == 0) {
			return tagRepo.save(tag);
	} else {
		Tag existingTag = tagRepo.findAllBySubject(subject).get(0);
		System.out.println(existingTag.getId());
		return existingTag;
		}
	}
	
	public Tag findTag(Long id){
		Optional<Tag> optionalTag = tagRepo.findById(id);
		if(optionalTag.isPresent()) {
			return optionalTag.get();
		} else {
			return null;
		}
	}
	
}
