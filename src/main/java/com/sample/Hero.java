package com.sample;

public class Hero extends Character{

public Hero(int col, int row, Weapon weapon, Statistic stat) {
	super("X", col, row, weapon, stat);
}

@Override
public String toString() {
	return "Hero [baseStat=" + baseStat + ", actualStat=" + actualStat + ", status=" + status + ", weapon=" + weapon
			+ ", simbol=" + simbol + ", col=" + col + ", row=" + row + ", removable=" + removable + ", steppable="
			+ steppable + "]";
}





}
