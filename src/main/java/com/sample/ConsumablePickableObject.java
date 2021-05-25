package com.sample;

public class ConsumablePickableObject extends PickableObject{
	
	String name;
	StatAbility statToIncrease;
	int bonus;
	
	public ConsumablePickableObject(String name, int col, int row, StatAbility stat, int bonus, int availability) {
		super(col, row, availability);
		this.statToIncrease = stat;
		this.bonus = bonus;
		this.name = name;
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


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "ConsumablePickableObject [name=" + name + ", statToIncrease=" + statToIncrease + ", bonus=" + bonus + "]";
	}






	
}
