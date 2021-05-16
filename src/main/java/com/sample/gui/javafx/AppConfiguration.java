package com.sample.gui.javafx;

import com.sample.gui.javafx.*;

public class AppConfiguration {
	
	private final boolean debug = false;
	
	private static volatile AppConfiguration instance;
	private int rows;
    private int columns;
    private double cellSize = 50;
    private double width;
    private double height;
    
    private GameView gameView;
	
    public static AppConfiguration getInstance() {
    	if (instance == null) {
    		instance = new AppConfiguration();
    	}
    	return instance;
    }
    
    public boolean isDebug() {
    	return this.debug;
    }

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setRows(int rows) {
		this.rows = rows;
		this.height = rows * this.cellSize;
	}

	public void setColumns(int columns) {
		this.columns = columns;
		this.width = columns * this.cellSize;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}
	
	
	public void setGameView(GameView gv) {
		synchronized(this) {
			this.gameView = gv;
			notify();
		}
	}
	
	public GameView getGameView() {
		synchronized(this) {
			try {
				if (this.gameView == null) {
					wait();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return this.gameView;
	}
	

}
