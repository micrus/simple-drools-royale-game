package com.sample;

public class Turn {
	TurnState status;

	public Turn(TurnState status) {
		super();
		this.status = status;
	}

	public TurnState getStatus() {
		return status;
	}

	public void setStatus(TurnState status) {
		this.status = status;
	}
	
	
}
