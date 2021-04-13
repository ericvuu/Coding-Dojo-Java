package zookeeper1;

public class Mammal {
	public int energyLevel;
	
	public Mammal() {
		this.energyLevel = 100;
	}
	
	public int displayEnergy() {
		System.out.println("Energy level: " + energyLevel);
		return this.energyLevel;
	}
	
}
