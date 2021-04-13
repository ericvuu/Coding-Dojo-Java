package com.codingdojo.objectmaster;

public class Ninja extends Human {
	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(Human person) {
		int currentStealth = this.getStealth();
		person.health -= currentStealth;
		this.setHealth(this.health + currentStealth);
	}
	
	public void runAway() {
		this.health -= 10;
	}
}
