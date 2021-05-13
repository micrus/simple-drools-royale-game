package com.sample;

public abstract class LocatedOnMap {

	protected String simbol;
	protected int col;
	protected int row;
	protected int removable;
	protected int steppable;
	
	public LocatedOnMap(String simbol, int col, int row, int removable, int steppable){
		this.simbol = simbol;
		this.col = col;
		this.row = row;
		this.removable = removable;
		this.steppable = steppable;
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
	
	
}
