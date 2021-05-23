package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestNPC {
	
	private NPC npc;
	private Weapon gun;
	private Statistic baseStat;

	@BeforeEach
	void setUp() {		
		gun = new Weapon("gun", 12, 7);
		baseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		npc = new NPC("npc", 2, 5, gun, baseStat);
	}
	
	@Test
	void testNPCConstructor() {
		
		assertEquals("npc", npc.getSimbol());
		assertEquals(2, npc.getCol());
		assertEquals(5, npc.getRow());
		
		assertEquals(false, npc.isFixed());
		assertEquals(1,npc.getRemovable());
		assertEquals(0,npc.getSteppable());
		
		npc.getWeapon().equals(gun);
		npc.getBaseStat().equals(baseStat);
		npc.getActualStat().equals(baseStat);
		npc.getStatus().equals(Status.NOT_MOVED);
		
	}
	
	@Test
	void testIncrement() {

		Statistic newActualStat = new Statistic(100, 9, 6, 9, 5, 9, 8, 6, 6);

		// valore maggiore di baseStat
		npc.setActualStat(newActualStat);
		npc.increment(StatAbility.SPEED, 2);
		assertEquals(8, npc.getStat(StatAbility.SPEED));

		// valore minore o uguale a baseStat
		npc.increment(StatAbility.DEXTERITY, 3);
		assertEquals(9, npc.getStat(StatAbility.DEXTERITY));
	}
	

	@Test
	void testNPCToString() {
		
		String npcExpectedString = "NPC [baseStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8, LUCK=7}], "
				+ "actualStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8, LUCK=7}], status=NOT_MOVED, "
				+ "weapon=Weapon [weaponName=gun, baseDamage=12, modifier=7], simbol=npc, col=2, row=5, removable=1, steppable=0]";
		assertEquals(npcExpectedString, npc.toString());				
	}	

}
