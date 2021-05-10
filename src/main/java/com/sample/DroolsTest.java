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
        	Gui gui = new GuiConsole();
        	Settings setting = new Settings(0, 5);
        	
        	Weapon sword = new Weapon("base sword", 10, 6);
        	Statistic balanceStatSlow = new Statistic(100,10,10,10,10,10,3,10);
        	Statistic balanceStatFast = new Statistic(100,10,10,10,10,20,3,10);

        	Hero hero = new Hero(4, 4, sword, balanceStatFast);


            NPC npc1 = new NPC("PG1",0,0, sword, balanceStatSlow);
        	NPC npc3 = new NPC("PG2",0,3, sword, balanceStatSlow);
        	NPC npc4 = new NPC("PG3",4,4, sword, balanceStatSlow);
        	NPC npc5 = new NPC("PG4",4,0, sword, balanceStatSlow);
        	NPC npc6 = new NPC("PG5",0,2, sword, balanceStatSlow);
        	NPC npc7 = new NPC("PG6",2,0, sword, balanceStatSlow);
        	NPC npc8 = new NPC("PG7",2,4, sword, balanceStatSlow);
        	NPC npc9 = new NPC("PG8",4,2, sword, balanceStatSlow);

        	//NPC npc2 = new NPC("PGF",0,0, new Statistic(20, 20, 20, 5, 10));

        	

        	//CraftObject deadWood = new CraftObject(3,3,StatAbility.LIFE, -9, 2);
        	CraftObject lifeWood = new CraftObject(3,1,StatAbility.LIFE, 5, 4);

        	kSession.insert(hero);
        	//kSession.insert(wall);
        	kSession.insert(npc1);
        	kSession.insert(npc3);
        	//kSession.insert(npc4);
        	//kSession.insert(npc5);
        	//kSession.insert(npc6);
        	//kSession.insert(npc7);
        	//kSession.insert(npc8);
        	//kSession.insert(npc9);



        	//kSession.insert(npc2);
        	
        	kSession.insert(lifeWood);
        	//kSession.insert(deadWood);

        	
            kSession.insert(setting);
            
            
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
