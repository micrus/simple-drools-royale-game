package com.sample;

public abstract class LocatedOnMap {
	String simbol;
	int col;
	int row;
	int removable;
	
	public LocatedOnMap(String simbol, int col, int row, int removable){
		this.simbol = simbol;
		this.col = col;
		this.row = row;
		this.removable = removable;
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
	
}
