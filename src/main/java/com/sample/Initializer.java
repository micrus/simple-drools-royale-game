package com.sample;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Random;

public class Initializer {
	private LinkedList<NPC> npcs = new LinkedList<NPC>();
	private LinkedList<Weapon> weapons = new LinkedList<Weapon>();
	private LinkedList<ConsumableCraftObject> consumableCrafts = new LinkedList<ConsumableCraftObject>();
	private LinkedList<WeaponCraftObject> weaponCrafts = new LinkedList<WeaponCraftObject>();
	private LinkedList<Position> availablePosition = new LinkedList<Position>();
	
	public Initializer(int dimension, int npcNumber, int wcNumber,int ccNumber) {
		fillWeapon();
		fillAvailablePositions(dimension);
		
		initNpcs(npcNumber);
		initWeaponCrafts(wcNumber);
		initConsumableCrafts(ccNumber);
		
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










	public LinkedList<ConsumableCraftObject> getConsumableCrafts() {
		return consumableCrafts;
	}









	public LinkedList<WeaponCraftObject> getWeaponCrafts() {
		return weaponCrafts;
	}






	public Position getPosition() {
		return availablePosition.removeFirst();
	}








	private void initConsumableCrafts(int ccNumber) {
		for(int i=0; i<ccNumber; i++) {
			Random gen = new Random();
			Position pos = this.availablePosition.removeFirst();
			this.consumableCrafts.add(new ConsumableCraftObject("Great Elixyr", pos.getCol(), pos.getRow(),StatAbility.LIFE,gen.nextInt(30), 1));
		}		
	}






	private void initWeaponCrafts(int wcNumber) {
		for(int i=0; i<wcNumber; i++) {
			Weapon weapon = this.weapons.removeFirst();
			Position pos = this.availablePosition.removeFirst();
			this.weaponCrafts.add(new WeaponCraftObject(weapon, pos.getCol(), pos.getRow(), 1));
		}
		
	}



	private void initNpcs(int number) {
		for(int i = 0; i<number; i++) {
			Weapon weapon = this.weapons.removeFirst();
			Position pos = this.availablePosition.removeFirst();
			this.npcs.add(new NPC("PC"+(i+1), pos.getCol(), pos.getRow(), weapon, new Statistic(100)));
		}
	}
	
	private void fillWeapon() {
		Random gen = new Random();
		this.weapons.add(new Weapon("Orenmir", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Worldbreaker", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Destiny's Song", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Renewed Greatsword", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Proud Rapier", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Firestorm Steel Etcher", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Venom Mithril Katana", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Due Diligence, Defiler of Trials", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Slayer of the Night Sky", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Dark Blade of the Phoenix", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Blind Justice", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Devourer", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Peacekeeper", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Vengeful Broadsword", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Glinting Deflector", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Phantom Gold Slicer", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Executing Silver Reaver", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Shortsword of the Wicked", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Winterthorn", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Chaoslauncher", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Doomstopper", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Drillrattler", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Firerapier", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Flameflail", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Fogseeker", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Gloryfist", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Netaxe", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Painnet", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Panzerlance", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Radiolimiter", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Rodcrusher", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Roddriller", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Waterspinner", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Whirlbreaker", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Astropike", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Dragonchucks", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Heliomasher", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Sealimiter", gen.nextInt(30)+1, gen.nextInt(30)+1));
		this.weapons.add(new Weapon("Vibrozooka", gen.nextInt(30)+1, gen.nextInt(30)+1));

		Collections.shuffle(this.weapons);

	}
	
	private void fillAvailablePositions(int dimension) {
		
		for(int i = 0; i<dimension; i++) {
			for(int j = 0; j<dimension;j++) {
				this.availablePosition.add(new Position(i,j));
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
			return "["+row+","+col+"]";
		}

	}
}
