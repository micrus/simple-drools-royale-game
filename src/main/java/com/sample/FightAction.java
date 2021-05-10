package com.sample;
import java.util.concurrent.ThreadLocalRandom;

public class FightAction extends PlayerAction{

	Character defender;
	int randomD20;
	int randomWeapon;
	
	public FightAction(Character whoMoves, Character defender, int priority) {
		super(Moves.FIGHT, whoMoves, priority);
		this.defender = defender;
		this.randomD20 = ThreadLocalRandom.current().nextInt(0, 21);
		this.randomWeapon = ThreadLocalRandom.current().nextInt(0, whoMoves.getWeapon().modifier + 1);
	}

	public Character getDefender() {
		return defender;
	}

	public void setDefender(Character defender) {
		this.defender = defender;
	}

	public int getRandomD20() {
		return randomD20;
	}

	public void setRandomD20(int randomD20) {
		this.randomD20 = randomD20;
	}

	public int getRandomWeapon() {
		return randomWeapon;
	}

	public void setRandomWeapon(int randomWeapon) {
		this.randomWeapon = randomWeapon;
	}

	
	public int offenderTryAttackValue() {
		return this.whoMoves.getStat(StatAbility.DEXTERITY)+this.randomD20;
	}
	
	public int defenderTryEludeValue() {
		return this.defender.getStat(StatAbility.DEFENCE) + defender.getStat(StatAbility.ELUSION);
	}
	
	public int offenderDamageValue() {
		return this.whoMoves.getStat(StatAbility.ATTACK)+whoMoves.getWeapon().getBaseDamage()+this.randomWeapon;
	}
	
	@Override
	public String toString() {
		return "FightAction [defender=" + defender + ", randomD20=" + randomD20 + ", randomWeapon=" + randomWeapon
				+ ", action=" + action + ", whoMoves=" + whoMoves + ", priority=" + priority + "]";
	}
	
	

}
