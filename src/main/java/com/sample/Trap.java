package com.sample;
import java.util.concurrent.ThreadLocalRandom;

public class Trap extends CraftObject{
	private Character positioner;
	private int malus;
	
	public Trap(int col, int row, Character positioner) {
		super(col, row, 1);
		this.positioner = positioner;
		this.malus = ThreadLocalRandom.current().nextInt(0, positioner.getStat(StatAbility.SHREWDNESS)+ 1);
	}

	public Character getPositioner() {
		return positioner;
	}

	public void setPositioner(Character positioner) {
		this.positioner = positioner;
	}

	public int getMalus() {
		return malus;
	}

	public void setMalus(int malus) {
		this.malus = malus;
	}

}
