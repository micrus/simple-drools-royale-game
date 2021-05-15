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
	private ConsoleArea console;
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
			mapBeing
				.stream()
				.filter((LocatedOnMap lom) -> lom.isOnMap() == false )
				.forEach((LocatedOnMap lom) -> {
					this.grid.createEntityPointer(lom);
				});

		});

	}
	
	public void showHelp() {
		
	}
	
	public void showMessage(String msg) {
		if (this.console == null) {
			this.console = appConf.getConsole();
		}
		this.console.appendMessage(msg);
	}
	
	public Moves getAction() throws IOException {
//		PlayerAction action = new PlayerAction(Moves.GO_UP);
//		GuiConsole tmp = new GuiConsole();
		return this.actionHandler.getMove();
		
	}
}
