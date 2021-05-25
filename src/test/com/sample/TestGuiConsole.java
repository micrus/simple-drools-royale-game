package com.sample;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import utils.KnowledgeSessionHelper;

@SuppressWarnings("restriction")
class TestGuiConsole {

	private GuiConsole gui;
	private ByteArrayInputStream input;
	private Settings settings;
	
	private Weapon rifle;
	private Statistic statistics;
	private Hero hero;

	@BeforeEach()
	void setUp() {
		this.gui = new GuiConsole();
	}

	@Test
	void testGetAction() throws IOException {
		this.input = new ByteArrayInputStream("d".getBytes());
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
		
		this.rifle = new Weapon("rifle", 15, 8);
		this.statistics = new Statistic(100, 10, 8, 7, 9, 8, 10, 8, 8);
		this.hero = new Hero(1, 1, this.rifle, this.statistics);

		testSession.insert(this.hero);

		this.settings = new Settings(10, 4);
		assertEquals(10, this.settings.getTime());
		assertEquals(4, this.settings.getDimension());

		testSession.insert(this.settings);

		this.settings = (Settings) testSession.getObjects(new
		 ClassObjectFilter(Settings.class)).iterator().next();

		@SuppressWarnings({ "unchecked" })
		Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) testSession
				.getObjects(new ClassObjectFilter(LocatedOnMap.class));

		gui.showMap(mapBeing, this.settings);
		assertTrue(mapBeing.contains(this.hero));

	}
}
