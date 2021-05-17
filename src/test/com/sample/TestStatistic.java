package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.StatAbility;
import com.sample.Statistic;

class TestStatistic {

	Statistic statistics;

	@BeforeEach
	void setUp() {
		statistics = new Statistic(100, 10, 8, 7, 9, 8, 10, 8);
	}

	@Test
	void testStatisticConstructor() {
		assertEquals(100, statistics.getStat(StatAbility.LIFE));
		assertEquals(10, statistics.getStat(StatAbility.ATTACK));
		assertEquals(8, statistics.getStat(StatAbility.DEXTERITY));
		assertEquals(7, statistics.getStat(StatAbility.DEFENCE));
		assertEquals(9, statistics.getStat(StatAbility.ELUSION));
		assertEquals(8, statistics.getStat(StatAbility.SPEED));
		assertEquals(10, statistics.getStat(StatAbility.VIEW));
		assertEquals(8, statistics.getStat(StatAbility.SHREWDNESS));
	}

	@Test
	void testStatisticToString() {
		String statisticExpectedString = "Statistic [stat={LIFE=100, ATTACK=10, "
				+ "DEXTERITY=8, DEFENCE=7, ELUSION=9, SPEED=8, VIEW=10, SHREWDNESS=8}]";
		assertEquals(statisticExpectedString, statistics.toString());
	}
}
