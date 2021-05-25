package rules;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.rule.FactHandle;

import com.sample.ConsumableCraftObject;
import com.sample.Gui;
import com.sample.GuiConsole;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.Logger;
import com.sample.NPC;
import com.sample.Settings;
import com.sample.StatAbility;
import com.sample.Statistic;
import com.sample.Weapon;

import utils.KnowledgeSessionHelper;

class TestGameDrl {
	
	static KieContainer kieContainer;
	KieSession session = null;
	ByteArrayInputStream input;
	
	Weapon heroWeapon;
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
	
	//TODO: da completare!
	@Test
	@Disabled
	void testRemovePortionOfTheMap() {
		heroWeapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(3, 3, heroWeapon, actualStat);
		FactHandle handleHero = session.insert(hero);
		
		Weapon npcWeapon = new Weapon("gun", 12, 7);
		Statistic baseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		NPC npc = new NPC("npc", 1, 1, npcWeapon, baseStat);
		FactHandle handleNPC = session.insert(npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);	
		session.fireAllRules();
		
	}
	
	@Test
	void testRemoveDiedPG() {
		testLoseGameBecauseYouDie();
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);	
		session.fireAllRules();		
	}
	
	@Test
	void testLoseGameBecauseYouDie() {
		heroWeapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(3, 2, heroWeapon, actualStat);
		FactHandle handleHero = session.insert(hero);
		
		hero.setActualStat(new Statistic(0, 10, 10, 10, 8, 15, 10, 7, 6));
		session.update(handleHero, hero);
		assertEquals(0, hero.getStat(StatAbility.LIFE));
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);	
		session.fireAllRules();
	}
	
	@Test
	void testWinBecauseYouAreTheOnlyOne() {
		heroWeapon = new Weapon("base sword", 10, 6);
		baseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		actualStat = new Statistic(baseStat);
		hero = new Hero(3, 2, heroWeapon, actualStat);
		session.insert(hero);
	
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);
		session.fireAllRules();		
	}
}
