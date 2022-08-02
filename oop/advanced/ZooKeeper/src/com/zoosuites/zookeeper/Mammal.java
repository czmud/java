package com.zoosuites.zookeeper;

public class Mammal {
	protected double energyLevel;
	
	public Mammal() {
		energyLevel = 100;
	}
	public Mammal( double energyLevel ) {
		this.energyLevel = energyLevel;
	}
	// GETTERS
	public double displayEnergy() {
		System.out.println( energyLevel );
		return energyLevel;
	}
}
