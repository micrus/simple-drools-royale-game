package com.sample;

public class Wall extends LocatedOnMap {

	public Wall(String simbol, int col, int row) {
		super(simbol, col, row, 0);
	}

	@Override
	public String toString() {
		return "Wall [simbol=" + simbol + ", col=" + col + ", row=" + row + "]";
	}

}
