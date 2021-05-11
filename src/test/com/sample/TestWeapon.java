package test.com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.sample.Weapon;

class TestWeapon {
	
	private Weapon sword;
	private Weapon riffle;
	
	@BeforeEach
	void setUp() {
		
		sword = new Weapon("sword", 10, 6 );
		riffle = new Weapon("riffle", 15, 5 );
	}
	
	@Test
	void testWeaponConstructor() {
		
		assertEquals("sword", sword.getWeaponName());
		assertEquals(10, sword.getBaseDamage());
		assertEquals(6, sword.getModifier());
		
		assertEquals("riffle", riffle.getWeaponName());
		assertEquals(15, riffle.getBaseDamage());
		assertEquals(5, riffle.getModifier());		
		
	}
	
	@Test
	void testWeaponToString() {
		
		String riffleExpectedString = "Weapon [weaponName=riffle, baseDamage=15, modifier=5]";
		assertEquals(riffleExpectedString, riffle.toString());
		
		String swordExpectedString = "Weapon [weaponName=sword, baseDamage=10, modifier=6]" ;
		assertEquals(swordExpectedString, sword.toString());
		
		
	}

}
