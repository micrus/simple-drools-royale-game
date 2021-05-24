package com.sample;

import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.sample.Initializer.Position;
import com.sample.gui.javafx.GuiJavaFX;

/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
            // load up the knowledge base
	        KieServices ks = KieServices.Factory.get();
    	    KieContainer kContainer = ks.getKieClasspathContainer();
        	KieSession kSession = kContainer.newKieSession("ksession-rules");



        	//=====================SETUP ==============================
        	Gui gui = new GuiJavaFX();
        	Logger.getInstance().setGui(gui);
        	
        	int dimension = 7;
        	int npcNumber = 3;
        	int weaponCraftNumber = 2;
        	int consumableCraftNumber = 2;
        	
        	Settings setting = new Settings(0, dimension);
        	Initializer init = new Initializer(dimension, npcNumber, weaponCraftNumber, consumableCraftNumber);

        	Position heroPos = init.getPosition();
        	Hero hero = new Hero(heroPos.getCol(), heroPos.getRow(), init.getWeapon(), new Statistic(150));
        	
        	
        	init.getNpcs().forEach(npc -> kSession.insert(npc));
        	init.getConsumableCrafts().forEach(cc -> kSession.insert(cc));
        	init.getWeaponCrafts().forEach(wc -> kSession.insert(wc));
            kSession.insert(setting);
            kSession.insert(hero);
            
            System.out.println(hero.toString());
            //=====================ACT=================================
            boolean run = true;
            while (run ) {
            	Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
                Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
                gui.showMap(mapBeing, settings);
                
            	Moves action= gui.getAction();
            	if(action != Moves.BAD_MOVE) {
	                kSession.insert(new PlayerAction(action, hero));
	                kSession.insert(new Turn(TurnState.INIT));
	                kSession.fireAllRules();
            	}else {
            		gui.showHelp();
            	}
                run = !settings.getGameOver();
            }    
            
            //The game is finished
        	Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
            Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
            gui.showMap(mapBeing, settings);

            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    

}
