package com.sample;

import java.util.concurrent.ThreadLocalRandom;

public class PlayerAction {
	
	// TODO: refactor in "move" (?)	
	Moves action;
	Character whoMoves;
	int priority;

	public PlayerAction(Moves action, Character whoMoves) {
		this.action = action;
		this.whoMoves = whoMoves;
		this.priority = whoMoves.getStat(StatAbility.SPEED) * 100 + ThreadLocalRandom.current().nextInt(0, 10);

	}

	public PlayerAction(Moves action, Character whoMoves, int priority) {
		this.action = action;
		this.whoMoves = whoMoves;
		this.priority = whoMoves.getStat(StatAbility.SPEED) * 100 + ThreadLocalRandom.current().nextInt(0, 10) + priority;

	}

	public Moves getAction() {
		return action;
	}

	public void setAction(Moves action) {
		this.action = action;
	}

	public Character getWhoMoves() {
		return whoMoves;
	}

	public void setWhoMoves(Character whoMoves) {
		this.whoMoves = whoMoves;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

}
