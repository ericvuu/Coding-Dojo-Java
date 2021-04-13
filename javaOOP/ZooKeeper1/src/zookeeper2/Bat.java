package zookeeper2;
import zookeeper1.Mammal;

public class Bat extends Mammal{
	public Bat() {
		this.energyLevel = 300;
	}
	
	public void fly() {
		this.energyLevel -= 50;
		System.out.println("Swoosh Swoosh Swoosh");
		
	}
	
	public void eatHumans() {
		this.energyLevel += 25;
		System.out.println("Humans are tasty!");
	}
	
	public void attackTown() {
		this.energyLevel -= 100;
		System.out.println("Run Everyone! The bat is here!");
	}
}
