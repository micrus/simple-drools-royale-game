package com.sample;

public class CraftAction extends PlayerAction{
	
	private int keep;
	
	public CraftAction(Character whoMoves, int keep) {
		super(Moves.CRAFT, whoMoves);
		this.keep = keep;
	}

	public CraftAction(Character whoMoves, int keep, int priority){
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
