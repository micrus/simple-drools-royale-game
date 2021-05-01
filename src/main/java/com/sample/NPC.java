package com.sample;

public class NPC extends LocatedOnMap{


	public NPC(String simbol, int col, int row) {
		super(simbol, col, row);
	}
	@Override
	public String toString() {
		return "NPC [simbol=" + simbol + ", col=" + col + ", row=" + row + "]";
	}

}


