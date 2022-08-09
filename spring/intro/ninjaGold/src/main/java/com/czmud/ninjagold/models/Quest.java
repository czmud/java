package com.czmud.ninjagold.models;

public class Quest extends Activity {
	public Quest() {
		super("Quest", -50, 50);
	}
	
	@Override
	public String generateEarningStatement() {
		if (this.goldEarned > 0) {
			return String.format("You completed a %s and earned %d gold. (%s)", name, goldEarned, createdAt.toString());
		}
		int goldLost = goldEarned * -1;
		return String.format("You failed a %s and lost %d gold. Ouch. (%s)", name, goldLost, createdAt.toString());
	}
}
