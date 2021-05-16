package com.sample.gui.javafx;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sample.CraftObject;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.NPC;
import com.sample.Observer;
import com.sample.StatAbility;
import com.sample.UpdateType;
import com.sample.Wall;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Grid extends Pane implements Observer {

    int rows;
    int columns;

    double width;
    double height;
    
    double cellWidth;
    double cellHeight;
    
    private Hero hero;
    private int heroVision;
    
    Cell[][] cells;

    public Grid( int columns, int rows, double width, double height) {

        this.columns = columns;
        this.rows = rows;
        this.width = width;
        this.height = height;
        this.cellWidth = width / columns;
        this.cellHeight = height / rows;

        cells = new Cell[rows][columns];

    }
    
    /**
     * Add cell to array and to the UI.
     */
    public void add(Cell cell, int column, int row) {

        cells[row][column] = cell;

        double x = this.cellWidth * column;
        double y = this.cellHeight * row;

        cell.setLayoutX(x);
        cell.setLayoutY(y);
        cell.setPrefWidth(this.cellWidth);
        cell.setPrefHeight(this.cellHeight);

        getChildren().add(cell);

    }

//    public Cell getCell(int column, int row) {
//        return cells[row][column];
//    }
    
    public void createEntityPointer(LocatedOnMap entity, String imgPath) {
    	if (entity instanceof Hero) {
			if (!AppConfiguration.getInstance().isDebug()) {
				this.hero = (Hero) entity;
				this.heroVision = this.hero.getStat(StatAbility.VIEW);
				this.hero.addObserver(this);
				this.calculateHiddenCells();
    		}
    	}
//    	String imgPath = this.getImagePath(entity);
//    	Image img = new Image(imgPath,this.cellWidth,this.cellHeight,false,true);
    	EntityPointer entityPointer = new EntityPointer(imgPath, entity, this.cellWidth, this.cellHeight);
    	entityPointer.setDeleteFn((EntityPointer et) -> {
    		this.getChildren().remove(et);
    	});
    	setEntityLocation(entityPointer, entity.getCol(), entity.getRow());
    	this.getChildren().add(entityPointer);
    	entity.setOnMap(true);
    	this.cellsToFront();
    }
    
    private static void setEntityLocation(EntityPointer entity, int col, int row) {
    	entity.setRow(row);
    	entity.setCol(col);
    }
    
    private void cellsToFront() {
    	for(Cell[] cellArray : this.cells) {
    		for(Cell cell : cellArray) {
    			cell.toFront();
    		}
    	}
    }
    
    private void calculateHiddenCells() {
    	for(int row = 0; row < this.rows; row++) {
    		for(int column = 0; column < this.columns; column++) {
    			int rowOffset = Math.abs(row - this.hero.getRow());
    			int columnOffset = Math.abs(column - this.hero.getCol());
    			boolean hidden = rowOffset + columnOffset > this.heroVision;
    			Cell currCell = this.cells[column][row];
//    			Label l = new Label();
//    			l.setText("("+rowOffset+","+columnOffset+")");
//    			currCell.getChildren().clear();
//    			currCell.getChildren().add(l);
    			currCell.setHidden(hidden);
    			currCell.updateStyle();
    		}
    	}
    }
    
    public void update(UpdateType ut) {
    	Platform.runLater(() -> {
			switch (ut) {
				case MOVE:
					this.calculateHiddenCells();
			}
    	});
    }

}
