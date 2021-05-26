package com.sample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Initializer {
	private LinkedList<NPC> npcs = new LinkedList<NPC>();
	private LinkedList<Weapon> weapons = new LinkedList<Weapon>();
	private LinkedList<ConsumablePickableObject> consumablePicks = new LinkedList<ConsumablePickableObject>();
	private LinkedList<WeaponPickableObject> weaponPicks = new LinkedList<WeaponPickableObject>();
	private LinkedList<Position> availablePosition = new LinkedList<Position>();

	public Initializer(int dimension, int npcNumber, int wcNumber, int ccNumber) {
		fillWeapon();
		fillAvailablePositions(dimension);

		initNpcs(npcNumber);
		initWeaponPicks(wcNumber);
		initConsumablePicks(ccNumber);

	}

	public LinkedList<NPC> getNpcs() {
		return npcs;
	}

	public void setNpcs(LinkedList<NPC> npcs) {
		this.npcs = npcs;
	}

	public Weapon getWeapon() {
		return weapons.removeFirst();
	}

	public LinkedList<ConsumablePickableObject> getConsumablePicks() {
		return consumablePicks;
	}

	public LinkedList<WeaponPickableObject> getWeaponPicks() {
		return weaponPicks;
	}

	public Position getPosition() {
		return availablePosition.removeFirst();
	}

	private void initConsumablePicks(int ccNumber) {
		for (int i = 0; i < ccNumber; i++) {
			Random gen = new Random();
			Position pos = this.availablePosition.removeFirst();
			this.consumablePicks.add(new ConsumablePickableObject("Great Elixyr", pos.getCol(), pos.getRow(),
					StatAbility.LIFE, gen.nextInt(30), 1));
		}
	}

	private void initWeaponPicks(int wcNumber) {
		for (int i = 0; i < wcNumber; i++) {
			Weapon weapon = this.weapons.removeFirst();
			Position pos = this.availablePosition.removeFirst();
			this.weaponPicks.add(new WeaponPickableObject(weapon, pos.getCol(), pos.getRow(), 1));
		}

	}

	private void initNpcs(int number) {
		for (int i = 0; i < number; i++) {
			Weapon weapon = this.weapons.removeFirst();
			Position pos = this.availablePosition.removeFirst();
			this.npcs.add(new NPC("NPC_" + (i + 1), pos.getCol(), pos.getRow(), weapon, new Statistic(100)));
		}
	}

	private void fillWeapon() {
		Random gen = new Random();
		this.weapons.add(new Weapon("Orenmir", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Worldbreaker", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Destiny's Song", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Renewed Greatsword", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Proud Rapier", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Firestorm Steel Etcher", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Venom Mithril Katana", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Due Diligence, Defiler of Trials", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Slayer of the Night Sky", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Dark Blade of the Phoenix", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Blind Justice", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Devourer", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Peacekeeper", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Vengeful Broadsword", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Glinting Deflector", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Phantom Gold Slicer", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Executing Silver Reaver", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Shortsword of the Wicked", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Winterthorn", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Chaoslauncher", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Doomstopper", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Drillrattler", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Firerapier", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Flameflail", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Fogseeker", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Gloryfist", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Netaxe", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Painnet", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Panzerlance", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Radiolimiter", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Rodcrusher", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Roddriller", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Waterspinner", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Whirlbreaker", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Astropike", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Dragonchucks", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Heliomasher", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Sealimiter", gen.nextInt(10) + 1, gen.nextInt(30) + 1));
		this.weapons.add(new Weapon("Programmer tired soul", gen.nextInt(100) + 1, gen.nextInt(100) + 1));

		Collections.shuffle(this.weapons);

	}

	private void fillAvailablePositions(int dimension) {

		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				this.availablePosition.add(new Position(i, j));
			}
		}

		Collections.shuffle(this.availablePosition);

	}

	public class Position {
		int row;
		int col;

		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}

		public int getRow() {
			return this.row;
		}

		public int getCol() {
			return this.col;
		}

		@Override
		public String toString() {
			return "[" + row + "," + col + "]";
		}

	}
}
