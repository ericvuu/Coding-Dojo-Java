package com.ericvuu.dojosandninjas.services;

import java.util.List;
//import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.dojosandninjas.models.Dojo;
//import com.ericvuu.dojosandninjas.models.Ninja;
import com.ericvuu.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	private DojoRepository dojoRepository;
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public void addDojo(Dojo dojo) {
		dojoRepository.save(dojo);
	}
	
	
	public List<Dojo>allDojos(){
		return dojoRepository.findAll();
	}

}
