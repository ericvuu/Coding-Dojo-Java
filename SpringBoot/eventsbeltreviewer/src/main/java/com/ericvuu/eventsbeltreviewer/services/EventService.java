package com.ericvuu.eventsbeltreviewer.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.eventsbeltreviewer.models.Event;
import com.ericvuu.eventsbeltreviewer.models.User;
import com.ericvuu.eventsbeltreviewer.repositories.EventRepo;

@Service
public class EventService {
	
	@Autowired
	private EventRepo eventRepo;
	
	public List<Event> allEvents(){
		return eventRepo.findAll();
	}
	
	public Event findEvent(Long id) {
		Optional<Event> optionalEvent = eventRepo.findById(id);
		if(optionalEvent.isPresent()) {
			return optionalEvent.get();
		} else {
			return null;
		}
	}
	
	public List<Event> inStateEvents(String state) {
    	return eventRepo.findByState(state);
	}

	public List<Event> outOfStateEvents(String state) {
    	return eventRepo.findByStateIsNot(state);
	}
	
	public Event createEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public Event editEvent(Event event) {
		return eventRepo.save(event);
	}
	
	public void addHost(User user, Event event) {
		event.setHost(user);
		eventRepo.save(event);
	}
}
