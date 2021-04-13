package com.codingdojo.objectmaster;

public class Samurai extends Human {
	private static int counter = 0;
	
	public Samurai(){
		this.health = 200;
		counter++;
	}
	
	public void deathBlow(Human person) {
		int currentHealth = this.getHealth();
		person.health = 0;
		this.setHealth(currentHealth/2);
	}
	
	public void meditate() {
		int currentHealth = this.getHealth();
		this.setHealth(currentHealth + (currentHealth/2));
	}
	
	public void howMany() {
		System.out.println("There are " + counter + " samurai.");
	}
}
