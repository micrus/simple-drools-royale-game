package com.sample;

public class PlayerAction {

	Moves action;
	MovesState state;
	
	PlayerAction(Moves action){
		this.action = action;
		this.state = MovesState.PERFORMING;
	}
	
	PlayerAction(Moves action, MovesState move){
		this.action = action;
		this.state = move;
	}


	public Moves getAction() {
		return action;
	}

	public void setAction(Moves action) {
		this.action = action;
	}

	public MovesState getState() {
		return state;
	}

	public void setState(MovesState state) {
		this.state = state;
	}
	
	
}
