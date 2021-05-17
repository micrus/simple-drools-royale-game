package com.sample;

public enum StatAbility {
	LIFE ("LIF"),
	ATTACK ("ATK"),
	DEXTERITY ("DEX"),
	ELUSION ("ELS"),
	DEFENCE ("DEF"),
	SPEED ("SPD"),
	VIEW ("VIW"),
	SHREWDNESS ("SHR"),
	LUCK ("LCK");
	
	private String shortText;
	
	private StatAbility(String shortText) {
		this.shortText = shortText;
	}
	
	public String getShortText() {
		return this.shortText;
	}
}
