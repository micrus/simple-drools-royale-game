package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestPickableObject {

	private PickableObject pick;

	@BeforeEach
	void setUp() {

		pick = new PickableObject(3, 2, 2);

	}

	@Test
	void testPickableObjectConstructor() {

		assertEquals(3, pick.getCol());
		assertEquals(2, pick.getRow());
		assertEquals(2, pick.getAvailability());
		assertEquals(false, pick.isFixed());

		assertEquals("°", pick.getSimbol());
		assertEquals(1, pick.getRemovable());
		assertEquals(1, pick.getSteppable());

	}

	@Test
	void testPickableObjectToString() {

		String PickableObjectExpectedString = "PickableObject [availability=2, "
				+ "simbol=°, col=3, row=2, removable=1, steppable=1]";

		assertEquals(PickableObjectExpectedString, pick.toString());

	}

}
