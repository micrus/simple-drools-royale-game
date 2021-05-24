package com.sample.gui.javafx;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChoiceModal extends Stage {
	private GuiJavaFX gui;
	private final double width = 200;
	private final double height = 100;

	public ChoiceModal(Stage primaryStage, GuiJavaFX gui, String msg) {
		super();
		this.gui = gui;
		
		double parentWidth = primaryStage.getWidth();
		double parentHeight = primaryStage.getHeight();
		double parentX = primaryStage.getX();
		double parentY = primaryStage.getY();
		
		StackPane root = new StackPane();
		Scene scene = new Scene(root, this.width, this.height);
		Label label = new Label();
		label.setText(msg);
//		label.setStyle("fx-text-alignment: center;");
		label.setPadding(new Insets(10));
		Button trueBtn = new Button();
		trueBtn.setOnMouseClicked(event -> {
			gui.setChoice(1);
			this.close();
		});
		Button falseBtn = new Button();
		falseBtn.setOnMouseClicked(event -> {
			gui.setChoice(0);
			this.close();
		});
		trueBtn.setText("Yes");
		falseBtn.setText("No");
		HBox buttons = new HBox(trueBtn, falseBtn);
		buttons.setPadding(new Insets(10,10,10,10));
		trueBtn.prefWidthProperty().bind(buttons.widthProperty().divide(2));
		falseBtn.prefWidthProperty().bind(buttons.widthProperty().divide(2));
		VBox vbox = new VBox(label, buttons);

		root.getChildren().add(vbox);
		
		this.setTitle("User Choice");
		this.setScene(scene);
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		double x = parentX + parentWidth/2 - this.width/2;
		double y = parentY + parentHeight/2 - this.height/2;
		this.setX(x);
		this.setY(y);
		
		this.show();
	}
}
