package com.czmud.ninjagold.models;

import java.util.Date;
import java.util.Random;

public abstract class Activity {
	protected String name;
	protected int goldHigh;
	protected int goldLow;
	protected int goldEarned;
	protected Date createdAt;
	
	public Activity(String name, int goldHigh, int goldLow) {
		this.name = name;
		this.goldHigh = goldHigh;
		this.goldLow = goldLow;
		this.goldEarned = earnGold();
		this.createdAt = new Date();
	}
	
	public int earnGold() {
		Random rand = new Random();
		if( goldHigh - goldLow < 0) {			
			return (rand.nextInt(goldLow - goldHigh) * -1 + goldLow);
		}
		return rand.nextInt(goldHigh - goldLow) + goldLow;
	}
	
	public String generateEarningStatement() {
		return String.format("You entered a %s and earned %d gold. (%s)", name, goldEarned, createdAt.toString());
	};

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGoldHigh() {
		return goldHigh;
	}

	public void setGoldHigh(int goldHigh) {
		this.goldHigh = goldHigh;
	}

	public int getGoldLow() {
		return goldLow;
	}

	public void setGoldLow(int goldLow) {
		this.goldLow = goldLow;
	}

	public int getGoldEarned() {
		return goldEarned;
	}

	public void setGoldEarned(int goldEarned) {
		this.goldEarned = goldEarned;
	}
	
	
}
