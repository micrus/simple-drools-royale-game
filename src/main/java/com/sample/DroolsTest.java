package com.sample;

import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

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
        	Settings setting = new Settings(0, 5);
        	Hero hero = new Hero(2, 2, new Statistic (30, 5, 15,0));

        	
        	//Wall wall = new Wall("#",3,3);
        	NPC npc1 = new NPC(0,1, new Statistic(20, 10, 10, 5));
        	NPC npc2 = new NPC(3,3, new Statistic(20, 20, 20, 5));

        	
        	
        	int a = 0;
        	a++;
        	CraftObject deadWood = new CraftObject(3,3,StatAbility.LIFE, -9, 2);
        	CraftObject lifeWood = new CraftObject(3,1,StatAbility.LIFE, 5, 4);

        	kSession.insert(hero);
        	//kSession.insert(wall);
        	kSession.insert(npc1);
        	kSession.insert(npc2);
        	
        	kSession.insert(lifeWood);
        	kSession.insert(deadWood);

        	
            kSession.insert(setting);
            
            
            //=====================ACT=================================
            boolean run = true;
            while (run ) {
            	Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
                Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
                gui.showMap(mapBeing, settings);
                
            	PlayerAction action= gui.getAction();
            	if(action != null) {
	                kSession.insert(action);
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
