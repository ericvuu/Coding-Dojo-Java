package com.ericvuu.dojosandninjas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.dojosandninjas.models.Ninja;
import com.ericvuu.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	private NinjaRepository ninjaRepository;
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public void addNinja(Ninja ninja) {
		ninjaRepository.save(ninja);
	}
	
}
