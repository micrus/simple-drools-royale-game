package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestStatistic {

	Statistic stat;

	@BeforeEach
	void setUp() {
		stat = new Statistic(100, 10, 8, 7, 9, 8, 10, 8, 9);
	}

	@Test
	void testStatisticConstructor() {
		assertEquals(100, stat.getStat(StatAbility.LIFE));
		assertEquals(10, stat.getStat(StatAbility.ATTACK));
		assertEquals(8, stat.getStat(StatAbility.DEXTERITY));
		assertEquals(7, stat.getStat(StatAbility.DEFENCE));
		assertEquals(9, stat.getStat(StatAbility.ELUSION));
		assertEquals(8, stat.getStat(StatAbility.SPEED));
		assertEquals(10, stat.getStat(StatAbility.VIEW));
		assertEquals(8, stat.getStat(StatAbility.SHREWDNESS));
		assertEquals(9, stat.getStat(StatAbility.LUCK));
	}

	@Test
	void testStatisticToString() {
		String statisticExpectedString = "Statistic [stat={LIFE=100, ATTACK=10, "
				+ "DEXTERITY=8, DEFENCE=7, ELUSION=9, SPEED=8, VIEW=10, SHREWDNESS=8, LUCK=9}]";
		assertEquals(statisticExpectedString, stat.toString());
	}
}
