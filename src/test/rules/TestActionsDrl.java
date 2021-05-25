package rules;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.drools.core.ClassObjectFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.sample.ConsumablePickableObject;
import com.sample.PickAction;
import com.sample.Gui;
import com.sample.GuiConsole;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.Logger;
import com.sample.Moves;
import com.sample.PlayerAction;
import com.sample.Settings;
import com.sample.StatAbility;
import com.sample.Statistic;
import com.sample.Trap;
import com.sample.Turn;
import com.sample.TurnState;
import com.sample.Weapon;
import com.sample.WeaponPickableObject;

import utils.KnowledgeSessionHelper;

class TestActionsDrl {

	static KieContainer kieContainer;
	KieSession session = null;
	ByteArrayInputStream input;

	Weapon weapon;
	Statistic baseStat;
	Statistic actualStat;
	Hero hero;

	Gui gui;
	Settings settings;
	Collection<LocatedOnMap> elementsOnMap;

	@BeforeEach
	void setUp() throws Exception {

		gui = new GuiConsole();
		Logger.getInstance().setGui(gui);
		settings = new Settings(0, 5);

		kieContainer = KnowledgeSessionHelper.createRuleBase();
		session = KnowledgeSessionHelper.getStatefulKnowledgeSession(kieContainer, "ksession-rules");
		session.insert(settings);
		System.out.println("---- START OF THE TEST ----");
	}

	@AfterEach
	void tearDown() throws Exception {

		System.setIn(System.in);
		session.dispose();
		System.out.println("---- END OF THE TEST ----");
	}

	@Test
	void testMovement() throws IOException {

		weapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(2, 2, weapon, actualStat);

		FactHandle handleHero = session.insert(hero);

		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);

		this.input = new ByteArrayInputStream("d".getBytes());
		System.setIn(input);
		Moves moveRight = gui.getAction();
		assertEquals(moveRight, Moves.GO_RIGHT);

		session.insert(new PlayerAction(moveRight, hero));
		session.insert(new Turn(TurnState.INIT));
		session.fireAllRules();
		session.update(handleHero, hero);

		assertEquals(2, hero.getCol());
		assertEquals(3, hero.getRow());
	}

	@Test
	void testPutTrap() throws IOException {

		weapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 5, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(2, 2, weapon, actualStat);

		Trap trap = new Trap(4, 1, hero);

		session.insert(hero);
		session.insert(trap);

		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);

		this.input = new ByteArrayInputStream("tr".getBytes());
		System.setIn(input);
		Moves putTrap = gui.getAction();
		assertEquals(putTrap, Moves.PUT_TRAP);

		session.insert(new PlayerAction(putTrap, hero));
		session.fireAllRules();

		assertEquals(4, trap.getCol());
		assertEquals(1, trap.getRow());
	}

	@Test
	@Disabled
	void testTakeConsumablePick() throws IOException {

		weapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(3, 1, weapon, actualStat);
		FactHandle handleHero = session.insert(hero);

		String name = "glasses";
		StatAbility statToIncrease = StatAbility.VIEW;
		int bonus = 2;
		ConsumablePickableObject pick = new ConsumablePickableObject(name, 3, 1, statToIncrease, bonus, 1);
		FactHandle handlePick = session.insert(pick);

		Statistic newActualStat = new Statistic(100, 10, 10, 10, 8, 15, 6, 7, 6);
		hero.setActualStat(newActualStat);
		System.out.println("ABILITA DI HERO: " + hero.getStat(statToIncrease));
		session.update(handleHero, hero);

		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);

		this.input = new ByteArrayInputStream("cr".getBytes());
		System.setIn(input);
		Moves crafting = gui.getAction();
		assertEquals(crafting, Moves.CRAFT);

		session.insert(new PickAction(hero, 1));
		// session.insert(new Turn(TurnState.INIT));

		session.fireAllRules();
		session.update(handlePick, pick);
		session.update(handleHero, hero);

		assertEquals(8, hero.getStat(statToIncrease));

	}

	@Test
	void testTakeWeaponPick() throws IOException {

		weapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(3, 2, weapon, actualStat);
		FactHandle handleHero = session.insert(hero);

		Weapon knife = new Weapon("knife", 7, 5);
		WeaponPickableObject pick = new WeaponPickableObject(knife, 3, 2, 2);
		FactHandle handlePick = session.insert(pick);

		this.input = new ByteArrayInputStream("cr".getBytes());
		System.setIn(input);
		Moves crafting = gui.getAction();
		assertEquals(crafting, Moves.CRAFT);

		session.insert(new PickAction(hero, 1));
		// session.insert(new Turn(TurnState.INIT));

		session.fireAllRules();
		session.update(handlePick, pick);
		session.update(handleHero, hero);

		hero.getWeapon().equals(knife);
	}
}
