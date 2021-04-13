package com.ericvuu.eventsbeltreviewer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.eventsbeltreviewer.repositories.MessageRepo;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepo messageRepo;
	
}
