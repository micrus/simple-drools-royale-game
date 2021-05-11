package com.sample.gui.javafx;

import com.sample.Moves;

import javafx.scene.control.Button;

public class ActionButton extends Button {
    	private Moves move;
    	public ActionButton(double width, Moves move) {
    		this.move = move;
    		this.setText(move.toString());
    		this.maxWidth(Double.MAX_VALUE);
//    		this.prefWidth(width);
//    		this.minWidth(width);
    	}
    	
    	public Moves getMove() {
    		return this.move;
    	}
    }