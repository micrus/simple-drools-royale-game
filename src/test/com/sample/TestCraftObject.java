package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.CraftObject;
import com.sample.StatAbility;

class TestCraftObject {

	CraftObject craft;
	StatAbility statToIncrease;

	@BeforeEach
	void setUp() {
		
		statToIncrease = StatAbility.LIFE;
		craft = new CraftObject(1, 3, statToIncrease, 2, 4);

	}

	@Test
	void testCraftObjectConstructor() {

		assertEquals("°", craft.getSimbol());
		assertEquals(1, craft.getCol());
		assertEquals(3, craft.getRow());
		assertEquals(statToIncrease, craft.getStatToIncrease());
		assertEquals(2, craft.getBonus());
		assertEquals(4, craft.getAvaiability());

	}

	@Test
	void testCraftObjectToString() {

		String craftObjectExpectedString = "CraftObject [statToIncrease=LIFE, bonus=2, avaiablity=4, "
				+ "simbol=°, col=1, row=3, removable=1]";

		assertEquals(craftObjectExpectedString, craft.toString());

	}

}
