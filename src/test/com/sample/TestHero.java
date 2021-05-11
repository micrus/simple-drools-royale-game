package test.com.sample;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.sample.Hero;
import com.sample.Statistic;
import com.sample.Status;
import com.sample.Weapon;

class TestHero {
	
	private Hero hero;
	private Weapon sword;
	private Statistic balanceState;
	
	
	@BeforeEach
	void setUp() {
		// TODO: Valutare futura utilità di setUp()
		sword = new Weapon("base sword", 10, 6);
		balanceState = new Statistic(100,10,10,10,10,15,3,10);
		hero = new Hero(4, 4, sword, balanceState);
	}

	@Test
	void testHero() {
		assertEquals(4, hero.getCol());
		assertEquals(4, hero.getRow());
		// TODO: controllo testing di costruttori parametrizzati con objects
		hero.getWeapon().equals(sword);
		hero.getActualStat().equals(balanceState);
		
		// TODO: controllo caratteristiche ereditate da Character
		hero.getStatus().equals(Status.NOT_MOVED);
		
		// TODO: controllo caratteristiche ereditate da LocatedOnMap		
				
	}
	
	
	

}
