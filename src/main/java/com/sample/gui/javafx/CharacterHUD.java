package com.sample.gui.javafx;

import java.util.ArrayList;
import java.util.List;

import com.sample.Character;
import com.sample.Observer;
import com.sample.StatAbility;
import com.sample.UpdateType;
import com.sample.Weapon;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CharacterHUD extends HBox implements Observer {
	private final double height = 120;
	private Character character;
	
	private ProgressBar lifeBar;
	private Label lifeLabel;
	private List<StatLabel> statLabels = new ArrayList<StatLabel>();
	
	private Label weaponLabel;
	private Weapon currentWeapon;
	
	float lifePerc;
	int maxLife;
	int currentLife;
	

	public CharacterHUD(Character character, String imgPath, double width) {
		super();
		this.setPrefSize(width, this.height);
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
		this.lifeBar.setPrefWidth(200);
		this.lifeBar.setPadding(new Insets(0, 10, 10, 0));
		
		this.lifeLabel = new Label();
		this.setLifeText();
		
		HBox lifeRow = new HBox(this.lifeBar, this.lifeLabel);
		
		HBox statRow1 = new HBox();
		HBox statRow2 = new HBox();
		
		int count = 0;
		for(StatAbility s : StatAbility.values()) {
			if (s != StatAbility.LIFE) {
				StatLabel l = new StatLabel(s);
				l.setStatValue(this.character.getStat(s));
				if (count++ < 4) {
					statRow1.getChildren().add(l);
				} else {
					statRow2.getChildren().add(l);
				}
				this.statLabels.add(l);
			}
		}
		
		this.weaponLabel = new Label();
		this.updateWeaponLabel();
		VBox vbox = new VBox(lifeRow, statRow1, statRow2, this.weaponLabel);
		vbox.setPadding(new Insets(0, 0, 0, 10));
		this.getChildren().add(vbox);

	}
	
	private double getLifePerc() {
		this.currentLife = this.character.getActualStat().getStat(StatAbility.LIFE);
		return (double)this.currentLife / (double)this.maxLife;
	}
	
	private void setLifeText() {
		this.lifeLabel.setText(this.currentLife + "/" + this.maxLife);
	}
	
	private void updateWeaponLabel() {
		Weapon weapon = this.character.getWeapon();
		if (this.currentWeapon != weapon) {
			String weaponName = weapon.getWeaponName();
			int baseDmg = weapon.getBaseDamage();
			int modifier = weapon.getModifier();
			this.weaponLabel.setText(weaponName + " - DMG: " + baseDmg + " + 1d"+modifier);
		}
	}
	
	private void updateStatLabels() {
		this.statLabels.forEach((sl) -> {
			StatAbility s = sl.getStatAbility();
			sl.setStatValue(this.character.getActualStat().getStat(s));
		});
	}

	@Override
	public void update(UpdateType ut) {
		Platform.runLater(() -> {
			switch(ut) {
				case UPDATE: 
					this.lifeBar.setProgress(this.getLifePerc());
					this.setLifeText();
					this.updateStatLabels();
					this.updateWeaponLabel();
					break;
				case DELETED:
					this.lifeBar.setProgress(0);
					this.setLifeText();
					this.character.removeObserver(this);
					break;
			}
		});
	}
}
