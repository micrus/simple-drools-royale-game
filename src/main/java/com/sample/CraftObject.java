package com.sample;

public class CraftObject extends LocatedOnMap{

	StatAbility statToIncrease;
	int bonus;
	int avaiability;
	
	public CraftObject(int col, int row, StatAbility stat, int bonus, int avaiability) {
		super("°", col, row, 1, 1);
		this.statToIncrease = stat;
		this.bonus = bonus;
		this.avaiability = avaiability;
	}


	public StatAbility getStatToIncrease() {
		return statToIncrease;
	}

	public void setStatToIncrease(StatAbility statToIncrease) {
		this.statToIncrease = statToIncrease;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	public int getAvaiability() {
		return avaiability;
	}

	public void setAvaiability(int avaiability) {
		this.avaiability = avaiability;
	}

	@Override
	public String toString() {
		return "DraftObject [statToIncrease=" + statToIncrease + ", bonus=" + bonus + ", avaiablity=" + avaiability
				+ ", simbol=" + simbol + ", col=" + col + ", row=" + row + ", removable=" + removable + "]";
	}

	
}
