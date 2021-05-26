package com.sample.gui.javafx;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javafx.scene.control.TextArea;

public class ConsoleArea extends TextArea {
	
	private final int rows = 4;
	private Queue<String> messages = new LinkedList<String>();
	
	public ConsoleArea() {
		this.setDisable(true);
		this.setStyle("-fx-opacity: 1; -fx-font-size: 1.1em;");
	}

	public void appendMessage(String msg) {
		synchronized(this.messages) {
			if (this.messages.size() >= this.rows) {
				this.messages.remove();
			}
			this.messages.add(msg);
			this.updateConsoleArea();
		}
	}
	
	private void updateConsoleArea() {
		synchronized(this.messages) {
			this.clear();
			this.messages.forEach(msg -> {
				synchronized(this.messages) {
					this.appendText(msg);
				}
			});
		}
	}
}
