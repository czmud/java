package com.zoosuites.zookeeper;

public class Bat extends Mammal {
	
	public Bat() {
		energyLevel = 300;
	}
	public void fly() {
		System.out.println("Whoooooosh!");
		energyLevel -= 50;
		return;
	}
	public void eatHumans() {
		energyLevel += 25;
		return;
	}
	public void attackTown() {
		System.out.println("The town is burning... what shall we do?");
		energyLevel -= 100;
		return;
	}
}
