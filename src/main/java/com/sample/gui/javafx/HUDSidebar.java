package com.sample.gui.javafx;

import com.sample.Character;

import javafx.geometry.Insets;
import javafx.scene.layout.VBox;

public class HUDSidebar extends VBox {
	
	private double width;
	

	public HUDSidebar(double width) {
		super();
		this.width = width;
		this.setPrefWidth(width);
	}
	
	public void addHUD(Character c, String imgPath) {
		CharacterHUD hud = new CharacterHUD(c, imgPath, this.width, 50);
		this.getChildren().add(hud);
	}
}
