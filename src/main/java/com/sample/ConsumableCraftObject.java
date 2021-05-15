package com.sample;

public class ConsumableCraftObject extends CraftObject{

	StatAbility statToIncrease;
	int bonus;
	
	public ConsumableCraftObject(int col, int row, StatAbility stat, int bonus, int avaiability) {
		super(col, row, avaiability);
		this.statToIncrease = stat;
		this.bonus = bonus;
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


	@Override
	public String toString() {
		return "ConsumableCraftObject [statToIncrease=" + statToIncrease + ", bonus=" + bonus + ", avaiability="
				+ avaiability + ", simbol=" + simbol + ", col=" + col + ", row=" + row + ", removable=" + removable
				+ ", steppable=" + steppable + "]";
	}



	
}
