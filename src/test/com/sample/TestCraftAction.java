package com.sample;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class TestPickAction {

	private Hero hero;
	private Weapon sword;
	private Statistic heroBaseStat;
	private Statistic heroActualStat;

	private int heroKeep;
	private PickAction heroPickAction;

	private NPC npc;
	private Weapon gun;
	private Statistic npcBaseStat;

	private int npcKeep;
	private int npcPriority;
	private PickAction npcPickAction;

	@BeforeEach
	void setUp() {

		this.sword = new Weapon("base sword", 10, 6);
		this.heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		this.heroActualStat = new Statistic(this.heroBaseStat);
		this.hero = new Hero(4, 4, this.sword, this.heroActualStat);
		this.heroKeep = 1;
		this.heroPickAction = new PickAction(this.hero, this.heroKeep);

		this.gun = new Weapon("gun", 12, 7);
		this.npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		this.npc = new NPC("npc", 2, 5, gun, this.npcBaseStat);
		this.npcPriority = 3;
		this.npcPickAction = new PickAction(this.npc, this.npcKeep, this.npcPriority);
	}

	@RepeatedTest(value = 20)
	void testPickActionConstructor() {
		// Test primo costruttore
		this.heroPickAction.getAction().equals(Moves.CRAFT);
		this.heroPickAction.getWhoMoves().equals(this.hero);
		assertTrue(this.heroPickAction
				.getPriority() >= this.heroPickAction.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 0
				&& this.heroPickAction
						.getPriority() <= this.heroPickAction.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 10);

		// Test secondo costruttore
		this.npcPickAction.getAction().equals(Moves.CRAFT);
		this.npcPickAction.getWhoMoves().equals(this.npc);
		assertTrue(this.npcPickAction
				.getPriority() >= (this.npcPickAction.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 0)
						+ this.npcPriority
				&& this.npcPickAction
						.getPriority() <= (this.npcPickAction.getWhoMoves().getStat(StatAbility.SPEED) * 100 + 10)
								+ this.npcPriority);
	}

}
