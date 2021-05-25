package com.sample;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class TestHero {

	private Hero hero;
	private Weapon sword;
	private Statistic baseStat;
	private Statistic actualStat;

	@BeforeEach
	void setUp() {

		sword = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(4, 4, sword, actualStat);
	}

	@Test
	void testHeroConstructor() {

		assertEquals(4, hero.getCol());
		assertEquals(4, hero.getRow());
		
		assertEquals(false, hero.isFixed());
		assertEquals(1,hero.getRemovable());
		assertEquals(0,hero.getSteppable());

		hero.getWeapon().equals(sword);
		hero.getBaseStat().equals(actualStat);
		hero.getActualStat().equals(actualStat);
		hero.getStatus().equals(Status.NOT_MOVED);		
	}

	@Test
	void testIncrement() {

		Statistic newActualStat = new Statistic(100, 10, 9, 8, 5, 10, 5, 7, 6);

		// valore maggiore di baseStat
		hero.setActualStat(newActualStat);
		hero.increment(StatAbility.SHREWDNESS, 2);
		assertEquals(7, hero.getStat(StatAbility.SHREWDNESS));

		// valore minore o uguale a baseStat
		hero.increment(StatAbility.ELUSION, 1);
		assertEquals(6, hero.getStat(StatAbility.ELUSION));
	}
	
	@Test
	void testLevelUp() {
		Statistic oldBaseStat = hero.getBaseStat();
		hero.levelUp();
		assertFalse(oldBaseStat.getStat(StatAbility.LIFE) != this.hero.getStat(StatAbility.LIFE));
		assertFalse(oldBaseStat.getStat(StatAbility.ATTACK) != this.hero.getStat(StatAbility.ATTACK));
		assertFalse(oldBaseStat.getStat(StatAbility.DEXTERITY) != this.hero.getStat(StatAbility.DEXTERITY));
		assertFalse(oldBaseStat.getStat(StatAbility.DEFENCE) != this.hero.getStat(StatAbility.DEFENCE));
		assertFalse(oldBaseStat.getStat(StatAbility.ELUSION) != this.hero.getStat(StatAbility.ELUSION));
		assertFalse(oldBaseStat.getStat(StatAbility.SPEED) != this.hero.getStat(StatAbility.SPEED));
		assertFalse(oldBaseStat.getStat(StatAbility.VIEW) != this.hero.getStat(StatAbility.VIEW));
		assertFalse(oldBaseStat.getStat(StatAbility.SHREWDNESS) != this.hero.getStat(StatAbility.SHREWDNESS));
		assertFalse(oldBaseStat.getStat(StatAbility.LUCK) != this.hero.getStat(StatAbility.LUCK));		
	}

	@Test
	void testHeroToString() {

		String heroExpectedString = "Hero [baseStat=Statistic [stat={LIFE=100, ATTACK=10, DEXTERITY=10, DEFENCE=10, ELUSION=8, SPEED=15, VIEW=5, SHREWDNESS=7, LUCK=6}], "
				+ "actualStat=Statistic [stat={LIFE=100, ATTACK=10, DEXTERITY=10, DEFENCE=10, ELUSION=8, SPEED=15, VIEW=5, SHREWDNESS=7, LUCK=6}], status=NOT_MOVED, "
				+ "weapon=Weapon [weaponName=base sword, baseDamage=10, modifier=6], simbol=X, col=4, row=4, removable=1, steppable=0]";
		assertEquals(heroExpectedString, hero.toString());
	}

}
