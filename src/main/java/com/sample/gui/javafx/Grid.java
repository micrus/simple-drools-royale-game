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
    
    private Map<LocatedOnMap, EntityPointer> entities = new HashMap<LocatedOnMap, EntityPointer>();

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

    public Cell getCell(int column, int row) {
        return cells[row][column];
    }
    
    public EntityPointer createEntityPointer(LocatedOnMap entity) {
    	String imgPath = this.getImagePath(entity);
    	Image img = new Image(imgPath,this.cellWidth,this.cellHeight,false,true);
    	EntityPointer entityPointer = new EntityPointer(img, entity, this.cellWidth, this.cellHeight);
    	entityPointer.setDeleteFn((EntityPointer et) -> {
    		this.getChildren().remove(et);
    	});
    	setEntityLocation(entityPointer, entity.getCol(), entity.getRow());
    	this.getChildren().add(entityPointer);
    	entity.setOnMap(true);
    	return entityPointer;
    }
    
    private String getImagePath(LocatedOnMap entity) {
    	String imgPath = "file:assets/";
    	if (entity instanceof Hero) {
    		imgPath = imgPath.concat("hero_idle.png");
    	} else if (entity instanceof NPC) {
    		int rand = new Random().nextInt(4);
    		imgPath = imgPath.concat("npc"+rand+"_idle.png");
    	} else if (entity instanceof CraftObject) {
    		imgPath = imgPath.concat("craft_object.png");
    	} else if (entity instanceof Wall) {
    		imgPath = imgPath.concat("out_of_map.png");
    	} else {
    		imgPath = imgPath.concat("cross.png");
    	}
    	return imgPath;
    }
    
    private static void setEntityLocation(EntityPointer entity, int col, int row) {
    	entity.setRow(row);
    	entity.setCol(col);
    }

}
