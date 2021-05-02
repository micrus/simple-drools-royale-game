package com.sample;

public abstract class Character extends LocatedOnMap {

	Statistic baseStat;
	Statistic actualStat;

	public Character(String simbol, int col, int row, Statistic stat) {
		super(simbol, col, row, 1);
		this.baseStat = stat;
		this.actualStat = new Statistic(stat);
	}

	public Statistic getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(Statistic baseStat) {
		this.baseStat = baseStat;
	}

	public Statistic getActualStat() {
		return actualStat;
	}

	public void setActualStat(Statistic actualStat) {
		this.actualStat = actualStat;
	}

	public void increment(StatAbility ability, int increment) {

		int newValue = actualStat.getStat(ability) + increment;
		
		if (newValue <= baseStat.getStat(ability)) {
			actualStat.setStat(ability, newValue);
		} else {
			actualStat.setStat(ability, baseStat.getStat(ability));
		}
		
	}
	
	public int getStat(StatAbility ability) {
		return this.actualStat.getStat(ability);
	}

}
