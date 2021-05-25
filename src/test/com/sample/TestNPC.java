package com.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	void testLevelUp() {
		Statistic oldBaseStat = npc.getBaseStat();
		npc.levelUp();
		assertFalse(oldBaseStat.getStat(StatAbility.LIFE) != this.npc.getStat(StatAbility.LIFE));
		assertFalse(oldBaseStat.getStat(StatAbility.ATTACK) != this.npc.getStat(StatAbility.ATTACK));
		assertFalse(oldBaseStat.getStat(StatAbility.DEXTERITY) != this.npc.getStat(StatAbility.DEXTERITY));
		assertFalse(oldBaseStat.getStat(StatAbility.DEFENCE) != this.npc.getStat(StatAbility.DEFENCE));
		assertFalse(oldBaseStat.getStat(StatAbility.ELUSION) != this.npc.getStat(StatAbility.ELUSION));
		assertFalse(oldBaseStat.getStat(StatAbility.SPEED) != this.npc.getStat(StatAbility.SPEED));
		assertFalse(oldBaseStat.getStat(StatAbility.VIEW) != this.npc.getStat(StatAbility.VIEW));
		assertFalse(oldBaseStat.getStat(StatAbility.SHREWDNESS) != this.npc.getStat(StatAbility.SHREWDNESS));
		assertFalse(oldBaseStat.getStat(StatAbility.LUCK) != this.npc.getStat(StatAbility.LUCK));		
	}
	

	@Test
	void testNPCToString() {
		
		String npcExpectedString = "NPC [baseStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8, LUCK=7}], "
				+ "actualStat=Statistic [stat={LIFE=150, ATTACK=20, DEXTERITY=10, DEFENCE=9, ELUSION=7, SPEED=8, VIEW=6, SHREWDNESS=8, LUCK=7}], status=NOT_MOVED, "
				+ "weapon=Weapon [weaponName=gun, baseDamage=12, modifier=7], simbol=npc, col=2, row=5, removable=1, steppable=0]";
		assertEquals(npcExpectedString, npc.toString());				
	}	

}
