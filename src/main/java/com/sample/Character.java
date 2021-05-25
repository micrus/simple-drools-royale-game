package com.sample;

import java.util.stream.Stream;

//import javafx.beans.Observable;

public abstract class Character extends LocatedOnMap {

	Statistic baseStat;
	Statistic actualStat;
	Status status;
	Weapon weapon;

	public Character(String simbol, int col, int row, Weapon weapon, Statistic stat) {
		super(simbol, col, row, 1, 0);
		this.baseStat = stat;
		this.actualStat = new Statistic(stat);
		this.status = Status.NOT_MOVED;
		this.weapon = weapon;
		this.fixed = false;
	}

	public void increment(StatAbility ability, int increment) {

		int newValue = actualStat.getStat(ability) + increment;

		if (newValue <= baseStat.getStat(ability)) {
			actualStat.setStat(ability, newValue);
		} else {
			actualStat.setStat(ability, baseStat.getStat(ability));
		}
		this.notifyObservers(UpdateType.UPDATE);
		this.checkDeath();
	}

	public int getStat(StatAbility ability) {
		return this.actualStat.getStat(ability);
	}
	
	public void levelUp() {

		Stream.of(StatAbility.values()).forEach(ability -> {
			int bonus = (int)(Math.random()*2);
			this.baseStat.setStat(ability, this.baseStat.getStat(ability)+bonus);
			this.increment(ability, bonus);
		});
	}

	public void moveLeft() {
		this.row--;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveRight() {
		this.row++;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveUp() {
		this.col--;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveDown() {
		this.col++;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveDownRight() {
		this.col++;
		this.row++;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveDownLeft() {
		this.col++;
		this.row--;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveUpRight() {
		this.col--;
		this.row++;
		this.notifyObservers(UpdateType.MOVE);
	}

	public void moveUpLeft() {
		this.col--;
		this.row--;
		this.notifyObservers(UpdateType.MOVE);
	}
	
	public void die() {
		this.actualStat.setStat(StatAbility.LIFE, 0);
		this.notifyObservers(UpdateType.UPDATE);

	}	

	public Statistic getBaseStat() {
		return baseStat;
	}

	public void setBaseStat(Statistic baseStat) {
		this.baseStat = baseStat;
	}

	public Statistic getActualStat() {
		return actualStat;
	}

	public void setActualStat(Statistic actualStat) {
		this.actualStat = actualStat;
		this.notifyObservers(UpdateType.UPDATE);
		this.checkDeath();
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
//		this.notifyObservers(UpdateType.UPDATE);
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.notifyObservers(UpdateType.UPDATE);
	}

	private void checkDeath() {
		if (this.actualStat.getStat(StatAbility.LIFE) <= 0) {
			this.notifyObservers(UpdateType.DELETED);
		}
	}
}
