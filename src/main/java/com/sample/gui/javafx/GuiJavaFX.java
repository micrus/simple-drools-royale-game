package com.sample.gui.javafx;

import java.io.IOException;
import java.util.Collection;

import com.sample.CraftObject;
import com.sample.Gui;
import com.sample.GuiConsole;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.Moves;
import com.sample.NPC;
import com.sample.PlayerAction;
import com.sample.Settings;

import javafx.application.Platform;

public class GuiJavaFX implements Gui {
	private static AppConfiguration appConf;
	
	private Grid grid;
	private ActionHandler actionHandler;
	private boolean started;
	
	public GuiJavaFX() {
		appConf = AppConfiguration.getInstance();
		this.actionHandler = ActionHandler.getInstance();
		this.grid = null;
		this.started = false;
	}

	public void showMap(Collection<LocatedOnMap> mapBeing, Settings setting) {
		if (!this.started) {
			appConf.setRows(setting.getDimension());
			appConf.setColumns(setting.getDimension());
			new Thread() {
				public void run() {
					JavaFXApplication.launch(JavaFXApplication.class);
				}
			}.start();
			this.started = true;
			this.grid = appConf.getGrid();
		}
		Platform.runLater(() -> {
			this.grid.clearStyle();
			for(LocatedOnMap lom : mapBeing) {
				int cols = lom.getCol();
				int rows = lom.getRow();
				if (lom instanceof Hero) {
					this.grid.showHero(cols, rows);
				} else if (lom instanceof NPC) {
					this.grid.showNPC(cols, rows);
				} else if (lom instanceof CraftObject) {
					this.grid.showCraft(cols, rows);
				} else {
					this.grid.showWall(cols, rows);
				}
			}	
		});
	}
	
	public void showHelp() {
		
	}
	
	public PlayerAction getAction() throws IOException {
//		PlayerAction action = new PlayerAction(Moves.GO_UP);
//		GuiConsole tmp = new GuiConsole();
		Moves move = this.actionHandler.getMove();
		return new PlayerAction(move);
		
	}
}
