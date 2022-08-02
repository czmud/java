package com.zoosuites.zookeeper;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("The gorilla threw a banana at you.");
		energyLevel -= 5;
		return;
	}
	public void throwSomething( String objectToThrow ) {
		System.out.printf("The gorilla threw a %s at you.\n", objectToThrow );
		energyLevel -= 5;
		return;
	}
	public void eatBananas() {
		System.out.println("The gorilla ate a banana and is very happy now!");
		energyLevel += 10;
		return;
	}
	public void climb() {
		System.out.println("The gorilla just climbed a tree.");
		energyLevel -= 10;
		return;
	}
}
