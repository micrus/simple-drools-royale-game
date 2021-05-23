package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestWeaponCraft {
	
	Weapon knife;
	WeaponCraftObject craft;

	@BeforeEach
	void setUp() {
		knife = new Weapon("knife", 7, 5);
		craft = new WeaponCraftObject(knife,1,2,2);
	}
	
	@Test
	void testWeaponCraftObjectConstructor() {
		
		assertEquals(1, craft.getCol());
		assertEquals(2, craft.getRow());
		assertEquals(2, craft.getAvailability());
		assertEquals(false, craft.isFixed());

		assertEquals("°", craft.getSimbol());
		assertEquals(1, craft.getRemovable());
		assertEquals(1, craft.getSteppable());		
	}

}
