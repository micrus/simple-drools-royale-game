package com.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TestFightAction {

	private Character hero;
	private Weapon sword;
	private Statistic heroBaseStat;
	private Statistic heroActualStat;

	private NPC npc;
	private Weapon gun;
	private Statistic npcBaseStat;

	private int priority;
	FightAction fightAction;

	@BeforeEach
	void setUp() {

		this.sword = new Weapon("base sword", 10, 6);
		this.heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		this.heroActualStat = new Statistic(this.heroBaseStat);
		this.hero = new Hero(4, 4, this.sword, this.heroActualStat);

		this.gun = new Weapon("gun", 12, 7);
		this.npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		this.npc = new NPC("npc", 2, 5, this.gun, this.npcBaseStat);

		this.priority = 1;
		this.fightAction = new FightAction(this.npc, this.hero, this.priority);
	}

	@RepeatedTest(value = 20)
	void testFightActionConstructor() {

		this.fightAction.getAction().equals(Moves.FIGHT);
		this.fightAction.getWhoMoves().equals(this.npc);

		assertTrue(this.fightAction.getPriority() >= this.fightAction.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 0
				&& this.fightAction.getPriority() <= this.fightAction.getWhoMoves().getStat(StatAbility.SPEED) * 100
						+ 10);

		this.fightAction.getDefender().equals(this.hero);

		assertTrue(this.fightAction.getRandomD20() >= 0 && this.fightAction.getRandomD20() <= 21);

		assertTrue(this.fightAction.getRandomWeapon() >= 0
				&& this.fightAction.getRandomWeapon() <= this.npc.getWeapon().getModifier() + 1);

	}

}
