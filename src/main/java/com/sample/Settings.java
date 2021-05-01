package com.sample;

public class Settings {
int time;
int dimension;
boolean gameOver;

int limitRowUp;
int limitRowDown;
int limitColRight;
int limitColLeft;


public Settings(int time, int dimension) {
	super();
	this.time = time;
	this.dimension = dimension;
	this.limitColRight = dimension-1;
	this.limitColLeft = 0;
	this.limitRowUp = 0;
	this.limitRowDown = dimension-1;
	this.gameOver = false;
}

public int getTime() {
	return time;
}

public void setTime(int time) {
	this.time = time;
}

public int getDimension() {
	return dimension;
}

public void setDimension(int dimension) {
	this.dimension = dimension;
}

public int getLimitRowUp() {
	return limitRowUp;
}

public void setLimitRowUp(int limitRowUp) {
	this.limitRowUp = limitRowUp;
}

public int getLimitRowDown() {
	return limitRowDown;
}

public void setLimitRowDown(int limitRowDown) {
	this.limitRowDown = limitRowDown;
}

public int getLimitColRight() {
	return limitColRight;
}

public void setLimitColRight(int limitColRight) {
	this.limitColRight = limitColRight;
}

public int getLimitColLeft() {
	return limitColLeft;
}

public void setLimitColDown(int limitColLeft) {
	this.limitColLeft = limitColLeft;
}



public boolean getGameOver() {
	return gameOver;
}

public void setGameOver(boolean gameOver) {
	this.gameOver = gameOver;
}

public void decreaseLimit() {
	this.limitColLeft++;
	this.limitColRight--;
	this.limitRowDown--;
	this.limitRowUp++;
}


@Override
public String toString() {
	return "Settings [time=" + time + ", dimension=" + dimension + ", limitRowUp=" + limitRowUp + ", limitRowDown="
			+ limitRowDown + ", limitColRight=" + limitColRight + ", limitColLeft=" + limitColLeft + "]";
}

}
