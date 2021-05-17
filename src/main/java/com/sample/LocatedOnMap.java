package com.sample;


public abstract class LocatedOnMap extends Observable {

	protected String simbol;
	protected int col;
	protected int row;
	protected int removable;
	protected int steppable;
	
	boolean fixed;
	boolean onMap = false;
	
	public LocatedOnMap(String simbol, int col, int row, int removable, int steppable){
		this.simbol = simbol;
		this.col = col;
		this.row = row;
		this.removable = removable;
		this.steppable = steppable;
		this.fixed = true;
	}
	
	public String getSimbol() {
		return simbol;
	}

	public void setSimbol(String simbol) {
		this.simbol = simbol;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getRemovable() {
		return removable;
	}

	public void setRemovable(int removable) {
		this.removable = removable;
	}

	public int getSteppable() {
		return steppable;
	}

	public void setSteppable(int steppable) {
		this.steppable = steppable;
	}
	
	public boolean isFixed() {
		return this.fixed;
	}
	
	public boolean isOnMap() {
		return this.onMap;
	}
	
	public void setOnMap(boolean onMap) {
		this.onMap = onMap;
	}
	
}
