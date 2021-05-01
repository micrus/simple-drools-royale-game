package com.sample;

import java.util.Collection;

import org.drools.core.ClassObjectFilter;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

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
        	Gui gui = new Gui();
        	Settings setting = new Settings(0, 5);
        	Hero hero = new Hero("X", 2, 2);
        	//Wall wall = new Wall("#",3,3);
        	NPC npc1 = new NPC("NPC",0,1);
        	NPC npc2 = new NPC("NPC",4,4);

        	kSession.insert(hero);
        	//kSession.insert(wall);
        	kSession.insert(npc1);
        	kSession.insert(npc2);

            kSession.insert(setting);
            
            
            //=====================ACT=================================
            boolean run = true;
            while (run ) {
                
            	Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
                Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
                gui.printMap(mapBeing, settings);
                
            	PlayerAction action= gui.getActionFromConsole();

                kSession.insert(action);
                kSession.fireAllRules();
                run = !settings.getGameOver();
            }    
            
            //The game is finished
        	Settings settings =  (Settings) kSession.getObjects(new ClassObjectFilter(Settings.class)).iterator().next();
            Collection<LocatedOnMap> mapBeing = (Collection<LocatedOnMap>) kSession.getObjects(new ClassObjectFilter(LocatedOnMap.class));
            gui.printMap(mapBeing, settings);
            System.out.println("Game Over!");

            
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

    

}
