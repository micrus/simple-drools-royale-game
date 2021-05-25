package com.sample;

public class PickAction extends PlayerAction{
	
	private int keep;
	
	public PickAction(Character whoMoves, int keep) {
		super(Moves.CRAFT, whoMoves);
		this.keep = keep;
	}

	public PickAction(Character whoMoves, int keep, int priority){
		super(Moves.CRAFT, whoMoves, priority);
		this.keep = keep;

	}

	public int getKeep() {
		return keep;
	}

	public void setKeep(int keep) {
		this.keep = keep;
	}
	
	
	
}
