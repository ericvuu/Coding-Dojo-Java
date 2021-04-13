package com.ericvuu.employeemanagementsystem.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ericvuu.employeemanagementsystem.models.Position;
import com.ericvuu.employeemanagementsystem.repositories.PositionRepo;

@Service
public class PositionService {
	@Autowired
	private PositionRepo positionRepo;
	
	public List<Position> allPositions(){
		return positionRepo.findAll();
	}
	
	public Position findPosition(Long id) {
		Optional<Position> optionalPosition = positionRepo.findById(id);
		if(optionalPosition.isPresent()) {
			return optionalPosition.get();
		} else {
			return null;
		}
	}
	
	public Position createPosition(Position position) {
		return positionRepo.save(position);
	}
	
	public Position editPosition(Position position) {
		return positionRepo.save(position);
	}
	
	public void deletePosition(Long id) {
		positionRepo.deleteById(id);
	}
}
