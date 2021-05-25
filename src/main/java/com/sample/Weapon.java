package com.sample;

public class Weapon {
	private String weaponName;
	private int baseDamage;
	private int modifier;

	public Weapon(String weaponName, int baseDamage, int modifier) {
		super();
		this.weaponName = weaponName;
		this.baseDamage = baseDamage;
		this.modifier = modifier;
	}

	public String getWeaponName() {
		return weaponName;
	}

	public void setWeaponName(String weaponName) {
		this.weaponName = weaponName;
	}

	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getModifier() {
		return modifier;
	}

	public void setModifier(int modifier) {
		this.modifier = modifier;
	}

	@Override
	public String toString() {
		return "Weapon [weaponName=" + weaponName + ", baseDamage=" + baseDamage + ", modifier=" + modifier + "]";
	}

}
