package com.sample;

public class NPC extends Character{


	public NPC(String simbol, int col, int row, Statistic stat) {
		super(simbol, col, row, stat);
		
	}
	@Override
	public String toString() {
		return "NPC [simbol=" + simbol + ", col=" + col + ", row=" + row + "]";
	}

}


