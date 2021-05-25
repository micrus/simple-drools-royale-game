package com.sample;
import java.util.concurrent.ThreadLocalRandom;

public class FightAction extends PlayerAction{

	private Character defender;
	private int randomD20;
	private int randomWeapon;
	
	public FightAction(Character whoMoves, Character defender, int priority) {
		super(Moves.FIGHT, whoMoves, priority);
		this.defender = defender;
		this.randomD20 = ThreadLocalRandom.current().nextInt(0, 21);
		this.randomWeapon = ThreadLocalRandom.current().nextInt(0, whoMoves.getWeapon().getModifier() + 1);
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
		return this.getWhoMoves().getStat(StatAbility.DEXTERITY)+this.randomD20;
	}
	
	public int defenderTryEludeValue() {
		return this.getDefender().getStat(StatAbility.DEFENCE) + this.getDefender().getStat(StatAbility.ELUSION);
	}
	
	public int offenderDamageValue() {
		return this.getWhoMoves().getStat(StatAbility.ATTACK) + this.getWhoMoves().getWeapon().getBaseDamage()+this.randomWeapon;
	}
	
	@Override
	public String toString() {
		return "FightAction [defender=" + this.defender + ", randomD20=" + this.randomD20 + ", randomWeapon=" + this.randomWeapon
				+ ", action=" + this.getAction() + ", whoMoves=" + this.getWhoMoves() + ", priority=" + this.getPriority() + "]";
	}
	
	

}
