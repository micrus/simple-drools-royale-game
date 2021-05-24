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
import javafx.stage.Stage;

public class GameView {
	
	private Grid grid;
	private ConsoleArea console;
	private HUDSidebar sidebar;
	private Stage primaryStage;
	
	private Map<LocatedOnMap, String> imgPaths = new HashMap<LocatedOnMap, String>();
	

	public GameView(Grid grid, ConsoleArea console, HUDSidebar sidebar, Stage primaryStage) {
		this.grid = grid;
		this.console = console;
		this.sidebar = sidebar;
		this.primaryStage = primaryStage;
	}
	
	public void addEntity(LocatedOnMap lom) {
		String folderPath = getFolderPath(lom);
		String imgBase = getBaseImg(lom);
		Platform.runLater(() -> {
			this.grid.createEntityPointer(lom, folderPath, imgBase);
			if (lom instanceof Character) {
				this.sidebar.addHUD((Character) lom, folderPath+imgBase);
			}
		});
	}
	
	public ChoiceModal createModal(GuiJavaFX gui, String msg) {
		return new ChoiceModal(this.primaryStage, gui, msg);
	}
	

   private static String getFolderPath(LocatedOnMap entity) {
    	String imgPath = "file:assets/";
    	if (entity instanceof Hero) {
			imgPath = imgPath.concat("hero/");
    	} else if (entity instanceof NPC) {
    		int rand = new Random().nextInt(10);
    		imgPath = imgPath.concat("npc"+rand+"/");
    	} else if (entity instanceof CraftObject) {
    		imgPath = imgPath.concat("craft/");
    	} else if (entity instanceof Wall) {
    		imgPath = imgPath.concat("wall/");
    	} else {
    		imgPath = imgPath.concat("unhandled/");
    	}
    	return imgPath;
    }
   
   private static String getBaseImg(LocatedOnMap entity) {
    	String imgPath = "";
    	if (entity instanceof Character) {
    		imgPath = imgPath.concat("down_1.png");
    	} else {
    		imgPath = imgPath.concat("base.png");
    	}
    	
    	return imgPath;
   }
   

	public void appendMessageOnConsole(String msg) {
		this.console.appendMessage(msg);
	}
	
}
