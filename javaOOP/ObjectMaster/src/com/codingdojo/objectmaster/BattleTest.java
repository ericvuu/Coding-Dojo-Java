package com.codingdojo.objectmaster;

public class BattleTest {

	public static void main(String[] args) {
		
		Wizard wizard1 = new Wizard();
		Wizard wizard2 = new Wizard();
		Ninja ninja1 = new Ninja();
		Samurai samurai1 = new Samurai();
		Samurai samurai2 = new Samurai();
		
		wizard1.getHealth();
		wizard2.heal(wizard1);
		wizard1.getHealth();
		
		ninja1.getStealth();
		ninja1.getHealth();
		ninja1.steal(wizard1);
		ninja1.getHealth();
		ninja1.runAway();
		ninja1.getHealth();
		
		samurai1.getHealth();
		samurai1.deathBlow(wizard2);
		wizard2.getHealth();
		samurai2.meditate();
		samurai2.getHealth();
		samurai1.howMany();
	}

}
