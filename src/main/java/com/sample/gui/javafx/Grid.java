package com.sample.gui.javafx;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.sample.CraftObject;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.NPC;
import com.sample.Wall;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Grid extends Pane {

    int rows;
    int columns;

    double width;
    double height;
    
    double cellWidth;
    double cellHeight;
    
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
    
    public EntityPointer createEntityPointer(LocatedOnMap entity, String imgPath) {
//    	String imgPath = this.getImagePath(entity);
//    	Image img = new Image(imgPath,this.cellWidth,this.cellHeight,false,true);
    	EntityPointer entityPointer = new EntityPointer(imgPath, entity, this.cellWidth, this.cellHeight);
    	entityPointer.setDeleteFn((EntityPointer et) -> {
    		this.getChildren().remove(et);
    	});
    	setEntityLocation(entityPointer, entity.getCol(), entity.getRow());
    	this.getChildren().add(entityPointer);
    	entity.setOnMap(true);
    	return entityPointer;
    }
    
    private static void setEntityLocation(EntityPointer entity, int col, int row) {
    	entity.setRow(row);
    	entity.setCol(col);
    }

}
