package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestWeaponPick {
	
	Weapon knife;
	WeaponPickableObject pick;

	@BeforeEach
	void setUp() {
		knife = new Weapon("knife", 7, 5);
		pick = new WeaponPickableObject(knife,1,2,2);
	}
	
	@Test
	void testWeaponPickableObjectConstructor() {
		
		assertEquals(1, pick.getCol());
		assertEquals(2, pick.getRow());
		assertEquals(2, pick.getAvailability());
		assertEquals(false, pick.isFixed());

		assertEquals("°", pick.getSimbol());
		assertEquals(1, pick.getRemovable());
		assertEquals(1, pick.getSteppable());		
	}

}
