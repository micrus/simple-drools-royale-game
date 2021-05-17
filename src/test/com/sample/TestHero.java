package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.Hero;
import com.sample.Statistic;
import com.sample.Status;
import com.sample.Weapon;

class TestHero {

	private Hero hero;
	private Weapon sword;
	private Statistic balanceState;

	@BeforeEach
	void setUp() {
		
		sword = new Weapon("base sword", 10, 6);
		balanceState = new Statistic(100, 10, 10, 10, 10, 15, 3, 10);
		hero = new Hero(4, 4, sword, balanceState);
	}

	@Test
	void testHeroConstructor() {

		assertEquals(4, hero.getCol());
		assertEquals(4, hero.getRow());

		// TODO: controllo testing di costruttori parametrizzati con objects
		hero.getWeapon().equals(sword);
		hero.getBaseStat().equals(balanceState);
		hero.getActualStat().equals(balanceState);		

		// TODO: controllo caratteristiche ereditate da Character
		hero.getStatus().equals(Status.NOT_MOVED);

		// TODO: controllo caratteristiche ereditate da LocatedOnMap

	}
	
	// TODO: Eliminare codice hard-coded in testHeroToString()

	@Test
	void testHeroToString() {

		String heroExpectedString = "Hero [baseStat=Statistic [stat={LIFE=100, ATTACK=10, DEXTERITY=10, DEFENCE=10, ELUSION=10, SPEED=15, VIEW=3, SHREWDNESS=10}], "
				+ "actualStat=Statistic [stat={LIFE=100, ATTACK=10, DEXTERITY=10, DEFENCE=10, ELUSION=10, SPEED=15, VIEW=3, SHREWDNESS=10}], status=NOT_MOVED, "
				+ "weapon=Weapon [weaponName=base sword, baseDamage=10, modifier=6], simbol=X, col=4, row=4, removable=1, steppable=0]";
		assertEquals(heroExpectedString, hero.toString());
	}
	

}
