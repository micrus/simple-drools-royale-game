package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestConsumableCraftObject {
	
	private String name;
	private StatAbility statToIncrease;
	private int bonus;
	private ConsumableCraftObject craft;

	@BeforeEach
	void setUp() {
		name = "glasses";
		statToIncrease = StatAbility.VIEW;
		bonus = 2;
		craft = new ConsumableCraftObject(name, 3,1,statToIncrease,bonus,1);
		
	}
	
	@Test
	void testConsumableCraftObjectConstructor() {
		
		assertEquals(this.name, this.craft.getName());
		assertEquals(1, this.craft.getRow());
		assertEquals(3, this.craft.getCol());
		assertEquals(this.statToIncrease, this.craft.getStatToIncrease());
		assertEquals(this.bonus, this.craft.getBonus());
		assertEquals(1, this.craft.getAvailability());
		
		assertEquals(false, this.craft.isFixed());
		assertEquals("°", this.craft.getSimbol());
		assertEquals(1, this.craft.getRemovable());
		assertEquals(1, this.craft.getSteppable());
		
	}

}
