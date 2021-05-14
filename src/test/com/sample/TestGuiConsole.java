package test.com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.GuiConsole;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.Moves;
import com.sample.Settings;
import com.sample.Statistic;
import com.sample.Weapon;

import utils.KnowledgeSessionHelper;

@SuppressWarnings("restriction")
class TestGuiConsole {

	GuiConsole gui;
	ByteArrayInputStream input;
	Settings settings;

	@BeforeEach()
	void setUp() {
		gui = new GuiConsole();

	}

	@Test
	void testGetAction() throws IOException {
		input = new ByteArrayInputStream("d".getBytes());
		System.setIn(input);
		Moves action = gui.getAction();
		assertEquals(action, Moves.GO_RIGHT);
		System.setIn(System.in);
	}

	/**
	 * Il test crea una sessione e aggiunge alla mappa iniziale un solo elemento,
	 * rappresentato dall'eroe. Dopodiché controlla l'effettivo funzionamento di
	 * showMap().
	 */
	@Test
	void testShowMap() {

		KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
		KieSession testSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kContainer, "ksession-rules");

		Weapon rifle = new Weapon("rifle", 15, 8);
		Statistic statistics = new Statistic(100, 10, 8, 7, 9, 8, 10, 8);
		Hero hero = new Hero(1, 1, rifle, statistics);
		testSession.insert(hero);

		Settings settings = new Settings(10, 4);
		assertEquals(10, settings.getTime());
		assertEquals(4, settings.getDimension());

		testSession.insert(settings);

		// FIXME: Perché utilizzare un altro oggetto Settings?
		// FIXME: Come togliere il warning?

		// Settings settings = (Settings) testSession.getObjects(new
		// ClassObjectFilter(Settings.class)).iterator().next();

		@SuppressWarnings({ "unchecked" })
		Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) testSession
				.getObjects(new ClassObjectFilter(LocatedOnMap.class));

		gui.showMap(mapBeing, settings);

		// TODO: Come proseguire ulteriormente?

		// FIXME: COdice relativo a DroolsTest, da spostare

		// assertTrue(mapBeing.contains(hero));
		// assertTrue(mapBeing.contains(setting));

	}
}
