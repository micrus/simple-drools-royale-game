package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestTrap {
	
	private Weapon gun;
	private Statistic baseStat;
	private Statistic actualStat;
	private Character positioner;
	
	private Trap trap;

	@BeforeEach
	void setUp() {
		
		gun = new Weapon("base gun", 12, 8);
		baseStat = new Statistic(100, 3, 7, 7, 9, 5, 6, 10, 10);
		actualStat = new Statistic(baseStat);
		positioner = new Hero(3, 4, gun, actualStat);
		
		trap = new Trap(4,1,positioner);
	}

	@Test
	void testTrapConstructor() {
		
		assertEquals(4, trap.getCol());
		assertEquals(1, trap.getRow());
		trap.getPositioner().equals(positioner);
		assertTrue(trap.getMalus() >= 0 && trap.getMalus() <= (positioner.getStat(StatAbility.SHREWDNESS)+ 1));
		assertEquals(1, trap.getAvailability());
		
		assertEquals("°", trap.getSimbol());
		assertEquals(1, trap.getSteppable());
		assertEquals(1, trap.getRemovable());
		assertEquals(false, trap.isFixed());
	}
	
}
