package com.sample;

public class PlayerSoul extends CraftObject{

	int lifeBonus;
	
	
	public PlayerSoul(int col, int row, int avaiability, int lifeBonus) {
		super(col, row, avaiability);
		this.lifeBonus = lifeBonus;	
	}


	public int getLifeBonus() {
		return lifeBonus;
	}


	public void setLifeBonus(int lifeBonus) {
		this.lifeBonus = lifeBonus;
	}


	@Override
	public String toString() {
		return "PlayerSoul [lifeBonus=" + lifeBonus + "]";
	}
	
	

}
