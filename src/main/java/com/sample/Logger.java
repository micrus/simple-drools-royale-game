package com.sample;

public class Logger {
	private static Logger instance;
	private static Gui gui;

	public void println(String msg) {
		if (gui == null) {
			return;
		}
		gui.showMessage(msg+"\n");
	}

	public void print(String msg) {
		if (gui == null) {
			return;
		}
		gui.showMessage(msg);
	}
	
	public void setGui(Gui gui) {
		Logger.gui = gui;
	}
	
	public int chooseToKeep(String message) {
		return gui.chooseToKeep(message + "\nDo you want to keep it?");
	}
	
	public static Logger getInstance() {
		if (instance == null) {
			instance = new Logger();
		}
		return instance;
	}
}
