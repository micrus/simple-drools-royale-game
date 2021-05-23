package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSettings {

	Settings settings;

	@BeforeEach
	void setUp() {
		settings = new Settings(10, 8);
	}

	@Test
	void testSettingsConstructor() {
		assertEquals(10, settings.getTime());
		assertEquals(8, settings.getDimension());
		assertEquals(7, settings.getLimitColRight());
		assertEquals(0, settings.getLimitColLeft());
		assertEquals(0, settings.getLimitRowUp());
		assertEquals(7, settings.getLimitRowDown());
		assertEquals(false, settings.getGameOver());
	}

	@Test
	void testDecreaseLimit() {

		settings.decreaseLimit();

		assertEquals(1, settings.getLimitColLeft());
		assertEquals(6, settings.getLimitColRight());
		assertEquals(6, settings.getLimitRowDown());
		assertEquals(1, settings.getLimitRowUp());
	}

	@Test
	void testSettingsToString() {
		String settingsExpectedString = "Settings [time=10, dimension=8, limitRowUp=0, limitRowDown=7, "
				+ "limitColRight=7, limitColLeft=0]";
		assertEquals(settingsExpectedString, settings.toString());

	}

}
