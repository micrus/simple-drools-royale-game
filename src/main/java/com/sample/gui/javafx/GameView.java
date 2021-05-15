package com.sample.gui.javafx;

import com.sample.LocatedOnMap;
import com.sample.NPC;
import com.sample.Wall;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sample.Character;
import com.sample.CraftObject;
import com.sample.Hero;

import javafx.application.Platform;
import javafx.scene.layout.VBox;

public class GameView {
	
	private Grid grid;
	private ConsoleArea console;
	private HUDSidebar sidebar;
	
	private Map<LocatedOnMap, String> imgPaths = new HashMap<LocatedOnMap, String>();
	

	public GameView(Grid grid, ConsoleArea console, HUDSidebar sidebar) {
		this.grid = grid;
		this.console = console;
		this.sidebar = sidebar;
	}
	
	public void addEntity(LocatedOnMap lom) {
		String imgPath = getImagePath(lom);
		Platform.runLater(() -> {
			this.grid.createEntityPointer(lom, imgPath);
			if (lom instanceof Character) {
				this.sidebar.addHUD((Character) lom, imgPath);
			}
		});
	}

   private static String getImagePath(LocatedOnMap entity) {
    	String imgPath = "file:assets/";
    	if (entity instanceof Hero) {
    		imgPath = imgPath.concat("hero_idle.png");
    	} else if (entity instanceof NPC) {
    		int rand = new Random().nextInt(4);
    		imgPath = imgPath.concat("npc"+rand+"_idle.png");
    	} else if (entity instanceof CraftObject) {
    		imgPath = imgPath.concat("craft_object.png");
    	} else if (entity instanceof Wall) {
    		imgPath = imgPath.concat("out_of_map.png");
    	} else {
    		imgPath = imgPath.concat("cross.png");
    	}
    	return imgPath;
    }
	
	 

	public void appendMessageOnConsole(String msg) {
		this.console.appendMessage(msg);
	}
	
}
