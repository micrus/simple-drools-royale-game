package com.sample;

public class Hero extends Character{

public Hero(int col, int row, Statistic stat) {
	super("X", col, row, stat);
}

@Override
public String toString() {
	return "Hero [baseStat=" + baseStat + ", actualStat=" + actualStat + ", simbol=" + simbol + ", col=" + col
			+ ", row=" + row + ", removable=" + removable + "]";
}




}
