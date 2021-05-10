package com.sample;

public class NPC extends Character{


	public NPC(String name, int col, int row, Weapon weapon, Statistic stat) {
		super(name, col, row, weapon, stat);
		
	}

	@Override
	public String toString() {
		return "NPC [baseStat=" + baseStat + ", actualStat=" + actualStat + ", status=" + status + ", weapon=" + weapon
				+ ", simbol=" + simbol + ", col=" + col + ", row=" + row + ", removable=" + removable + ", steppable="
				+ steppable + "]";
	}



}


