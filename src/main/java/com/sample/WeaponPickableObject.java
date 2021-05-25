package com.sample;

public class WeaponPickableObject extends PickableObject{

	Weapon weapon;
	
	public WeaponPickableObject(Weapon weapon, int col, int row, int availability) {
		super(col, row, availability);
		this.weapon = weapon;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
}
