package com.sample.gui.javafx;

import com.sample.StatAbility;

import javafx.geometry.Insets;
import javafx.scene.control.Label;

public class StatLabel extends Label {
	private StatAbility statAbility;
	private int value;

	public StatLabel(StatAbility statAbility) {
		super();
		this.value = -999;
		this.setPadding(new Insets(0, 8, 0, 0));
		this.statAbility = statAbility;
	}
	
	public StatAbility getStatAbility() {
		return this.statAbility;
	}
	
	public void setStatValue(int value) {
		if (this.value != value) {
			this.value = value;
			this.updateText();
		}
	}
	
	private void updateText() {
		this.setText(this.statAbility.getShortText() + ": " + String.format("%02d", this.value));
	}
}
