package com.sample;

public class CraftObject extends LocatedOnMap{


	int avaiability;
	
	public CraftObject(int col, int row, int avaiability) {
		super("°", col, row, 1, 1);
		this.avaiability = avaiability;
	}



	public int getAvaiability() {
		return avaiability;
	}

	public void setAvaiability(int avaiability) {
		this.avaiability = avaiability;
	}



	@Override
	public String toString() {
		return "CraftObject [avaiability=" + avaiability + ", simbol=" + simbol + ", col=" + col + ", row=" + row
				+ ", removable=" + removable + ", steppable=" + steppable + "]";
	}

	
	


	
}
