package com.sample;

import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import utils.KnowledgeSessionHelper;
import com.sample.Initializer.Position;
import com.sample.gui.javafx.GuiJavaFX;


/**
 * This is a sample class to launch a rule.
 */
public class DroolsTest {

    public static final void main(String[] args) {
        try {
        	
            KieContainer kContainer = KnowledgeSessionHelper.createRuleBase();
        	KieSession kSession = KnowledgeSessionHelper.getStatefulKnowledgeSession(kContainer, "ksession-rules"); 

        	//=====================SETUP ==============================
        	
        	Gui gui = new GuiJavaFX();
        	Logger.getInstance().setGui(gui);
        	
        	int dimension = 12;
        	int npcNumber = 3;
        	int weaponPickNumber = 4;
        	int consumablePickNumber = 2;
        	
        	Settings setting = new Settings(0, dimension);
        	Initializer init = new Initializer(dimension, npcNumber, weaponPickNumber, consumablePickNumber);

        	Position heroPos = init.getPosition();
        	Hero hero = new Hero(heroPos.getCol(), heroPos.getRow(), init.getWeapon(), new Statistic(150));
        	
        	
        	init.getNpcs().forEach(npc -> { kSession.insert(npc); System.out.println(npc.toString());});
        	init.getConsumablePicks().forEach(cc -> kSession.insert(cc));
        	init.getWeaponPicks().forEach(wc -> kSession.insert(wc));
            kSession.insert(setting);
            kSession.insert(hero);
            
            System.out.println(hero.toString());
            
            //=====================ACT=================================
            boolean run = true;
            while (run ) {
            	
            	@SuppressWarnings("restriction")
				Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
                
            	@SuppressWarnings({ "unchecked", "restriction" })
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
        	@SuppressWarnings("restriction")
			Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
           
        	@SuppressWarnings({ "unchecked", "restriction" })
			Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
            
        	gui.showMap(mapBeing, settings);

            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    

}
