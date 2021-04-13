package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human testHuman = new Human();
		
		testHuman.getStrength();
		testHuman.getStealth();
		testHuman.getIntelligence();
		testHuman.getHealth();
		
		int upgradeStrength = testHuman.getStrength();
		testHuman.setStrength(upgradeStrength);
		testHuman.getStrength();
		
		testHuman.setHealth(-40);
		testHuman.getHealth();
	}

}
