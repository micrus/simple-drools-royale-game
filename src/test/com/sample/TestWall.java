package com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.sample.Wall;

class TestWall {
	
	Wall wall;
	
	@BeforeEach
	void setUp() {
		wall = new Wall(2, 5);
	}

	@Test
	void testWallConstructor() {
		assertEquals("#", wall.getSimbol());
		assertEquals(2, wall.getCol());
		assertEquals(5, wall.getRow());
		assertEquals(0, wall.getRemovable());
		assertEquals(0, wall.getSteppable());
	}

	@Test
	void testWallToString() {
		String wallExpectedString = "Wall [simbol=#, col=2, row=5]";
		assertEquals(wallExpectedString, wall.toString());
	}
}
