package com.sample;

public class PickableObject extends LocatedOnMap {

	private int availability;

	public PickableObject(int col, int row, int availability) {
		super("°", col, row, 1, 1);
		this.availability = availability;
		this.fixed = false;
	}

	public int getAvailability() {
		return availability;
	}

	public synchronized void setAvailability(int availability) {
		this.availability = availability;
		if (availability <= 0) {
			this.notifyObservers(UpdateType.DELETED);
		}
	}

	@Override
	public String toString() {
		
		return "PickableObject [availability=" + availability + ", simbol=" + simbol + ", col=" + col + ", row=" + row
				+ ", removable=" + removable + ", steppable=" + steppable + "]";

	}

}
