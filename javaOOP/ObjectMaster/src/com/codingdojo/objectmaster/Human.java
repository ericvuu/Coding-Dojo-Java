package com.codingdojo.objectmaster;

public class Human {
	protected int strength;
	protected int stealth;
	protected int intelligence;
	protected int health;
	
	public Human() {
		this.strength = 3;
		this.stealth = 3;
		this.intelligence = 3;
		this.health = 100;
	}

//	Getters and Setters
	
	public int getStrength() {
		System.out.println("Strength: " + this.strength);
		return this.strength;
	}
	
	public int setStrength(int strength) {
		this.strength = strength;
		return this.strength;
	}
	
	public int getStealth() {
		System.out.println("Stealth: " + this.stealth);
		return this.stealth;
	}
	
	public int setStealth(int stealth) {
		this.stealth = stealth;
		return this.stealth;
	}
	
	public int getIntelligence() {
		System.out.println("Intelligence: " + this.intelligence);
		return this.intelligence;
	}
	
	public int setIntelligence(int intelligence) {
		this.intelligence = intelligence;
		return this.intelligence;
	}
	
	public int getHealth() {
		System.out.println("Health: " + this.health);
		return this.health;
	}
	
	public int setHealth(int health) {
		this.health = health;
		return this.health;
	}
}
