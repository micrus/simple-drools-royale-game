package com.sample.gui.javafx;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class Cell extends StackPane {

    private int column;
    private int row;
    
    private boolean hidden;
    
    public Cell(int column, int row) {

        this.column = column;
        this.row = row;
        
        this.hidden = false;
        

        getStyleClass().add("cell");

//      Label label = new Label(this.toString());
//
//      getChildren().add(label);

//        setOpacity(0.9);
    }
    
    public void setHidden(boolean hidden) {
    	this.hidden = hidden;
    }
    
    public void updateStyle() {
		this.getStyleClass().remove("hidden");
    	if (this.hidden) {
    		this.getStyleClass().add("hidden");
    	}
    }
    
    public void clearStyle() {
    	this.getStyleClass().clear();
    	this.getStyleClass().add("cell");
    }

    public String toString() {
        return this.column + "/" + this.row;
    }
}
