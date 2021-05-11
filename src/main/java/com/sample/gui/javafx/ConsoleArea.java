package com.sample.gui.javafx;

import javafx.scene.control.TextArea;

public class ConsoleArea extends TextArea {
	
	public ConsoleArea() {
		this.setDisable(true);
	}
	public void appendMessage(String msg) {
		this.appendText(msg);
	}
}
