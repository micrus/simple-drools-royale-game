package com.sample;

public class Wall extends LocatedOnMap {

	public Wall(String simbol, int col, int row) {
		super(simbol, col, row);
	}

	@Override
	public String toString() {
		return "Wall [simbol=" + simbol + ", col=" + col + ", row=" + row + "]";
	}

}
