package com.sample.gui.javafx;

import com.sample.Character;
import com.sample.Observer;
import com.sample.StatAbility;
import com.sample.UpdateType;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharacterHUD extends HBox implements Observer {
	private Character character;
	
	private ProgressBar lifeBar;
	
	float lifePerc;
	int maxLife;
	int currentLife;

	public CharacterHUD(Character character, String imgPath, double width, double height) {
		super();
		this.setPrefSize(width, height);
		this.character = character;
		this.maxLife = character.getStat(StatAbility.LIFE);
		this.character.addObserver(this);
		
		this.initLayout(imgPath);
	}
	
	private void initLayout(String imgPath) {
		this.setPadding(new Insets(20, 20, 10, 10));
		this.getStyleClass().add("border");
		
		Image img = new Image(imgPath, 50, 50, false, true);
		ImageView imgView = new ImageView(img);
		imgView.getStyleClass().add("border");
		this.getChildren().add(imgView);
		
		this.lifeBar = new ProgressBar(this.getLifePerc());
		VBox vbox = new VBox(this.lifeBar);
		this.getChildren().add(vbox);

	}
	
	private double getLifePerc() {
		this.currentLife = this.character.getActualStat().getStat(StatAbility.LIFE);
		return (double)this.currentLife / (double)this.maxLife;
	}

	@Override
	public void update(UpdateType ut) {
		Platform.runLater(() -> {
			switch(ut) {
				case UPDATE: 
					this.lifeBar.setProgress(this.getLifePerc());
					break;
				case DELETED:
					this.lifeBar.setProgress(0);
					this.character.removeObserver(this);
					break;
			}
		});
	}
}
