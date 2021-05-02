package com.sample;

public abstract class Character extends LocatedOnMap {

	Statistic stat;
	
	public Character(String simbol, int col, int row, Statistic stat) {
		super(simbol, col, row, 1);
		this.stat = stat;
	}

	public Statistic getStat() {
		return stat;
	}

	public void setStat(Statistic stat) {
		this.stat = stat;
	}

	
}
