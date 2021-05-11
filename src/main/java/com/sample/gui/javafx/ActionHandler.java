package com.sample.gui.javafx;

import com.sample.Moves;

public class ActionHandler {

	private static ActionHandler instance;
	
	private Moves move;
	private boolean inputReady;
	
	public ActionHandler() {
		this.inputReady = false;
	}

	public static ActionHandler getInstance() {
		if (instance == null) {
			instance = new ActionHandler();
		}
		return instance;
	}
	
	public void registerMove(Moves move) {
		synchronized(this) {
			if (!this.inputReady) {
				return;
			}
			this.inputReady = false;
			this.move = move;
			notify();
		}
	}
	
	public Moves getMove() {
		synchronized(this) {
			this.inputReady = true;
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return this.move;
		}
	}
	
	
	
	
}
