package com.sample.gui.javafx;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    int column;
    int row;
    
    ImageView img;

    public Cell(int column, int row) {

        this.column = column;
        this.row = row;
        

        getStyleClass().add("cell");

//      Label label = new Label(this.toString());
//
//      getChildren().add(label);

        setOpacity(0.9);
    }

    public void clearStyle() {
    	this.getChildren().clear();
    	this.getStyleClass().clear();
    	this.getStyleClass().add("cell");
    }
    
    public void showNPC() {
    	this.getStyleClass().remove("npc");
    	this.getStyleClass().add("npc");
    }
    
    public void showHero() {
//    	this.img = new ImageView(new Image("./hero_idle.png",50,50,false,false));
//    	getChildren().add(this.img);
    	this.getStyleClass().remove("hero");
    	this.getStyleClass().add("hero");
    }
    
    public void showCraft() {
    	this.getStyleClass().remove("craft");
    	this.getStyleClass().add("craft");
    }

    public void showWall() {
    	this.getStyleClass().remove("wall");
    	this.getStyleClass().add("wall");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }
}
