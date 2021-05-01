package com.sample;

public class Hero extends LocatedOnMap{

public Hero(String simbol, int col, int row) {
	super(simbol, col, row, 1);
}
@Override
public String toString() {
	return "Hero [simbol=" + simbol + ", col=" + col + ", row=" + row + "]";
}

}
