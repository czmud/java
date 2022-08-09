package com.czmud.ninjagold.models;

public class Spa extends Activity {
	public Spa() {
		super("Spa", -5, -20);
	}
	
	@Override
	public String generateEarningStatement() {
		int goldPaid = goldEarned * -1;
		return String.format("You entered a %s and paid %d gold. (%s)", name, goldPaid, createdAt.toString());
	}
	
}
