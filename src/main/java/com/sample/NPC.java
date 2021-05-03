package com.sample;

public class NPC extends Character{


	public NPC(int col, int row, Statistic stat) {
		super("NPC", col, row, stat);
		
	}

	@Override
	public String toString() {
		return "NPC [baseStat=" + baseStat + ", actualStat=" + actualStat + ", simbol=" + simbol + ", col=" + col
				+ ", row=" + row + ", removable=" + removable + "]";
	}

}


