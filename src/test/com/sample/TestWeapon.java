package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestWeapon {

	private Weapon sword;
	private Weapon rifle;

	@BeforeEach
	void setUp() {

		sword = new Weapon("sword", 10, 6);
		rifle = new Weapon("rifle", 15, 8);
	}

	@Test
	void testWeaponConstructor() {

		assertEquals("sword", sword.getWeaponName());
		assertEquals(10, sword.getBaseDamage());
		assertEquals(6, sword.getModifier());

		assertEquals("rifle", rifle.getWeaponName());
		assertEquals(15, rifle.getBaseDamage());
		assertEquals(8, rifle.getModifier());

	}

	@Test
	void testWeaponToString() {

		String riffleExpectedString = "Weapon [weaponName=rifle, baseDamage=15, modifier=8]";
		assertEquals(riffleExpectedString, rifle.toString());

		String swordExpectedString = "Weapon [weaponName=sword, baseDamage=10, modifier=6]";
		assertEquals(swordExpectedString, sword.toString());

	}

}
