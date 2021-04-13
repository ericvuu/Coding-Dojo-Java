package com.codingdojo.objectmaster;

public class Wizard extends Human {
	public Wizard() {
		this.health = 50;
		this.intelligence = 8;
	}
	
	public void heal(Human person) {
		int currentIntelligence = this.getIntelligence();
		person.health += currentIntelligence;
	}
	
	public void fireball(Human person) {
		int currentIntelligence = this.getIntelligence() * 3;
		person.health -= currentIntelligence;
	}
}
