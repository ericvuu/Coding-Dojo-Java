package zookeeper1;

public class Gorilla extends Mammal {
	public Gorilla() {
		this.energyLevel = 100;
	}
	
	public void throwSomething() {
		this.energyLevel -= 5;
		System.out.println("The gorilla threw something!");
		displayEnergy();
	}
	
	public void eatBananas() {
		this.energyLevel += 10;
		System.out.println("The gorilla loves the banana!");
		displayEnergy();
	}
	
	public void climb() {
		this.energyLevel -= 10;
		System.out.println("The gorilla climbed a tree!");
		displayEnergy();
	}
}
