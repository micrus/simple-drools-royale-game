package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestCraftObject {

	private CraftObject craft;

	@BeforeEach
	void setUp() {

		craft = new CraftObject(3, 2, 2);

	}

	@Test
	void testCraftObjectConstructor() {

		assertEquals(3, craft.getCol());
		assertEquals(2, craft.getRow());
		assertEquals(2, craft.getAvailability());
		assertEquals(false, craft.isFixed());

		assertEquals("°", craft.getSimbol());
		assertEquals(1, craft.getRemovable());
		assertEquals(1, craft.getSteppable());

	}

	@Test
	void testCraftObjectToString() {

		String craftObjectExpectedString = "CraftObject [availability=2, "
				+ "simbol=°, col=3, row=2, removable=1, steppable=1]";

		assertEquals(craftObjectExpectedString, craft.toString());

	}

}
