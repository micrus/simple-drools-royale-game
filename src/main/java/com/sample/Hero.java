package com.sample;

public class Hero extends Character{

public Hero(String simbol, int col, int row, Statistic stat) {
	super(simbol, col, row, stat);
}

@Override
public String toString() {
	return "Hero [baseStat=" + baseStat + ", actualStat=" + actualStat + ", simbol=" + simbol + ", col=" + col
			+ ", row=" + row + ", removable=" + removable + "]";
}




}
