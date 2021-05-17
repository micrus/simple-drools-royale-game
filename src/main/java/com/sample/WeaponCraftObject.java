package com.sample;

public class WeaponCraftObject extends CraftObject{

	Weapon weapon;
	
	public WeaponCraftObject(Weapon weapon, int col, int row, int avaiability) {
		super(col, row, avaiability);
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
