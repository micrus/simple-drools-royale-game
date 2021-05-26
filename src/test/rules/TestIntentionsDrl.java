package rules;

import static org.junit.jupiter.api.Assertions.*;

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

import com.sample.ConsumablePickableObject;
import com.sample.Gui;
import com.sample.GuiConsole;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.Logger;
import com.sample.NPC;
import com.sample.Settings;
import com.sample.StatAbility;
import com.sample.Statistic;
import com.sample.Trap;
import com.sample.Weapon;

import utils.KnowledgeSessionHelper;

class TestIntentionsDrl {

	static KieContainer kieContainer;
	KieSession session = null;
	ByteArrayInputStream input;
	
	Weapon npcWeapon;
	Statistic npcBaseStat;
	NPC npc;
	
	
	Weapon heroWeapon;
	Statistic heroBaseStat;
	Statistic heroActualStat;
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
	void testNPCMovement() {
		
		heroWeapon = new Weapon("base sword", 10, 6);
		heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		heroActualStat = new Statistic(heroBaseStat);
		hero = new Hero(4, 3, heroWeapon, heroActualStat);
		FactHandle handleHero = session.insert(hero);
		
		npcWeapon = new Weapon("gun", 12, 7);
		npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		npc = new NPC("npc", 2, 2, npcWeapon, npcBaseStat);
		int originalCol = npc.getCol();
		int originalRow = npc.getRow();
		FactHandle handleNPC = session.insert(npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);				
		session.fireAllRules();
		session.update(handleNPC, npc);
		
		assertTrue(npc.getCol() != originalCol);
		assertTrue(npc.getRow() != originalRow);		
	}
	
	@Test
	void testNPCPutsTrap() {
		heroWeapon = new Weapon("base sword", 10, 6);
		heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		heroActualStat = new Statistic(heroBaseStat);
		hero = new Hero(3, 4, heroWeapon, heroActualStat);
		FactHandle handleHero = session.insert(hero);
		
		npcWeapon = new Weapon("gun", 12, 7);
		npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		npc = new NPC("npc", 2, 2, npcWeapon, npcBaseStat);
		FactHandle handleNPC = session.insert(npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);				
		session.fireAllRules();
		session.update(handleNPC, npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);
		
		Trap trap = (Trap)session.getObjects(new ClassObjectFilter(Trap.class)).iterator().next();
		
		
	}
	
	@Test
	void testNPCFightsAgainstHero() {
		heroWeapon = new Weapon("base sword", 10, 6);
		heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		heroActualStat = new Statistic(heroBaseStat);
		hero = new Hero(3, 3, heroWeapon, heroActualStat);
		FactHandle handleHero = session.insert(hero);
		
		npcWeapon = new Weapon("gun", 12, 7);
		npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		npc = new NPC("npc", 2, 2, npcWeapon, npcBaseStat);
		FactHandle handleNPC = session.insert(npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);				
		session.fireAllRules();
		session.update(handleNPC, npc);		
		
		//TODO: Come verificare che l'npc stia attaccando hero?
		
		// Statistiche in modo che non elude
		// Verifico decremento della vita
	}
	
	@Test
	void testNPCPicksObject() {
		
		heroWeapon = new Weapon("base sword", 10, 6);
		heroBaseStat = new Statistic(100, 10, 10, 10, 8, 15, 10, 7, 6);
		heroActualStat = new Statistic(heroBaseStat);
		hero = new Hero(4, 4, heroWeapon, heroActualStat);
		FactHandle handleHero = session.insert(hero);
				
		String name = "glasses";
		StatAbility statToIncrease = StatAbility.VIEW;
		int bonus = 2;
		ConsumablePickableObject pick =new ConsumablePickableObject(name, 1,2,statToIncrease,bonus,1);
		session.insert(pick);
		
		npcWeapon = new Weapon("gun", 12, 7);
		npcBaseStat = new Statistic(150, 20, 10, 9, 7, 8, 6, 8, 7);
		npc = new NPC("npc", 2, 2, npcWeapon, npcBaseStat);
		FactHandle handleNPC = session.insert(npc);
		
		settings = (Settings) session.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
		elementsOnMap = (Collection<LocatedOnMap>) session.getObjects(new ClassObjectFilter(LocatedOnMap.class));
		gui.showMap(elementsOnMap, settings);				
		session.fireAllRules();
		session.update(handleNPC, npc);	
		
	}

}
