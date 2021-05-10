package com.sample.gui.javafx;

public class AppConfiguration {
	
	private static volatile AppConfiguration instance;
	private int rows;
    private int columns;
    private double cellSize = 50;
    private double width;
    private double height;
    
    private volatile Grid grid;
    
    public AppConfiguration() {
    }
	
    public static AppConfiguration getInstance() {
    	if (instance == null) {
    		instance = new AppConfiguration();
    	}
    	return instance;
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
	
	public void setGrid(Grid grid) {
		synchronized(this) {
			this.grid = grid;
			notify();
		}
	}
	
	public Grid getGrid() {
		synchronized(this) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.grid;
	}

}
