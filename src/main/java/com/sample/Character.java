package com.sample;

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
	}
	

	public void increment(StatAbility ability, int increment) {

		int newValue = actualStat.getStat(ability) + increment;
		
		if (newValue <= baseStat.getStat(ability)) {
			actualStat.setStat(ability, newValue);
		} else {
			actualStat.setStat(ability, baseStat.getStat(ability));
		}
		
	}
	
	public int getStat(StatAbility ability) {
		return this.actualStat.getStat(ability);
	}
	
	public void moveLeft() {
		this.row--;
	}
	
	public void moveRight() {
		this.row++;
	}
	
	public void moveUp() {
		this.col--;
	}
	public void moveDown() {
		this.col++;
	}
	public void moveDownRight() {
		this.col++;
		this.row++;
	}
	public void moveDownLeft() {
		this.col++;
		this.row--;
	}
	public void moveUpRight() {
		this.col--;
		this.row++;
	}
	public void moveUpLeft() {
		this.col--;
		this.row--;
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
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}


	public Weapon getWeapon() {
		return weapon;
	}


	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

	// getDamage(){
	// laciodado + modificatori} -> quanti danni faccio
	
	// takeDamage(int damage)
	// {lacio dado elusione se lo supero danno 0 altrimenti calcolo danno effettivo}-> quanti danni prendo effettivi	
	
	/*
	 * A attacca B
	 * A tira dado per colpire -> getDamage
	 */
}
