package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestConsumablePickableObject {
	
	private String name;
	private StatAbility statToIncrease;
	private int bonus;
	private ConsumablePickableObject pick;

	@BeforeEach
	void setUp() {
		name = "glasses";
		statToIncrease = StatAbility.VIEW;
		bonus = 2;
		pick = new ConsumablePickableObject(name, 3,1,statToIncrease,bonus,1);
		
	}
	
	@Test
	void testConsumablePickableObjectConstructor() {
		
		assertEquals(this.name, this.pick.getName());
		assertEquals(1, this.pick.getRow());
		assertEquals(3, this.pick.getCol());
		assertEquals(this.statToIncrease, this.pick.getStatToIncrease());
		assertEquals(this.bonus, this.pick.getBonus());
		assertEquals(1, this.pick.getAvailability());
		
		assertEquals(false, this.pick.isFixed());
		assertEquals("°", this.pick.getSimbol());
		assertEquals(1, this.pick.getRemovable());
		assertEquals(1, this.pick.getSteppable());
		
	}

}
