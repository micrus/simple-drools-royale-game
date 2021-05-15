package com.sample.gui.javafx;

import com.sample.LocatedOnMap;

import javafx.application.Platform;
import javafx.scene.layout.VBox;

public class GameView {
	
	private Grid grid;
	private ConsoleArea console;
	

	public GameView(Grid grid, ConsoleArea console) {
		this.grid = grid;
		this.console = console;
	}
	
	public void addEntity(LocatedOnMap lom) {
		Platform.runLater(() -> {
			this.grid.createEntityPointer(lom);
		});
	}

	public void appendMessageOnConsole(String msg) {
		this.console.appendMessage(msg);
	}
	
}
