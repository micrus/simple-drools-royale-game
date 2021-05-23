package com.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TestPlayerAction {

	private Moves heroAction;
	private Character hero;
	private Weapon sword;
	private Statistic heroBaseStat;
	private Statistic heroActualStat;
	private PlayerAction goesLeft;

	private Moves npcAction;
	private Character npc;
	private Weapon gun;
	private Statistic npcBaseStat;
	private int npcPriority;
	private PlayerAction goesRight;

	@BeforeEach
	void setUp() {

		// Primo costruttore
		this.heroAction = Moves.GO_LEFT;
		this.sword = new Weapon("base sword", 10, 6);
		this.heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		this.heroActualStat = new Statistic(this.heroBaseStat);
		this.hero = new Hero(4, 4, this.sword, this.heroActualStat);
		this.goesLeft = new PlayerAction(this.heroAction, this.hero);

		// Secondo costruttore
		this.npcAction = Moves.GO_RIGHT;
		this.gun = new Weapon("gun", 12, 7);
		this.npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		this.npc = new NPC("npc", 2, 5, this.gun, this.npcBaseStat);
		this.npcPriority = 2;
		this.goesRight = new PlayerAction(this.npcAction, this.npc, this.npcPriority);

	}

	@RepeatedTest(value = 20)
	void testPlayerActionConstructors() {

		// Test del primo costruttore
		this.goesLeft.getAction().equals(this.heroAction);
		this.goesLeft.getWhoMoves().equals(this.hero);
		assertTrue(this.goesLeft.getPriority() >= this.goesLeft.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 0
				&& this.goesLeft.getPriority() <= this.goesLeft.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 10);
		// assertTrue(trap.getMalus() >= 0 && trap.getMalus() <=
		// (positioner.getStat(StatAbility.SHREWDNESS)+ 1));

		// Test del secondo costruttore
		this.goesRight.getAction().equals(this.npcAction);
		this.goesRight.getWhoMoves().equals(this.npc);
		assertTrue(this.goesRight.getPriority() >= (this.goesRight.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 0)
				+ this.npcPriority
				&& this.goesRight.getPriority() <= (this.goesRight.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 10)
						+ this.npcPriority);
	}
}
