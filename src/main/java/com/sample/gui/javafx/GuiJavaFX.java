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
	
//	private Grid grid;
//	private ConsoleArea console;
	private GameView view;
	private ActionHandler actionHandler;
	private boolean started;
	
	private Integer userChoice;
	
	public GuiJavaFX() {
		appConf = AppConfiguration.getInstance();
		this.actionHandler = ActionHandler.getInstance();
		this.started = false;
		this.view = null;
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
			if (this.view == null) {
				this.view = appConf.getGameView();
			}
		}
		mapBeing
			.stream()
			.filter((LocatedOnMap lom) -> lom.isOnMap() == false )
			.forEach((LocatedOnMap lom) -> {
				this.view.addEntity(lom);
			});
	}
	
	public void showHelp() {
		
	}
	
	public void showMessage(String msg) {
		if (this.view == null) {
			this.view = appConf.getGameView();
		}
		this.view.appendMessageOnConsole(msg);
	}
	
	public Moves getAction() throws IOException {
//		PlayerAction action = new PlayerAction(Moves.GO_UP);
//		GuiConsole tmp = new GuiConsole();
		return this.actionHandler.getMove();
		
	}
	
	public void setChoice(int choice) {
		synchronized(this) {
			this.userChoice = choice;
			notify();
		}
	}

	@Override
	public int chooseToKeep(String msg) {
		// TODO Auto-generated method stub
		this.userChoice = null;
		Platform.runLater(() -> {
			this.view.createModal(this, msg);
		});
		synchronized(this) {
			try {
				if (this.userChoice == null) {
					wait();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.userChoice;
	}
}
