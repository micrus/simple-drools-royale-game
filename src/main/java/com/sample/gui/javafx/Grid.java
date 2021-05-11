package com.sample.gui.javafx;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.function.Function;

import com.sample.CraftObject;
import com.sample.Hero;
import com.sample.LocatedOnMap;
import com.sample.NPC;
import com.sample.Wall;
import com.sample.gui.javafx.Cell;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Grid extends Pane {

    int rows;
    int columns;

    double width;
    double height;
    
    double cellWidth;
    double cellHeight;
    
    private Runnable changeFocus;
    
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
    
    public void setChangeFocus(Runnable runnable) {
    	this.changeFocus = runnable;
    }
    
    public void changeFocus() {
    	this.changeFocus.run();
    }

    /**
     * Add cell to array and to the UI.
     */
    public void add(Cell cell, int column, int row) {

        cells[row][column] = cell;

//        double w = width / columns;
//        double h = height / rows;
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
    
    public void moveEntity(LocatedOnMap entity) {
    	EntityPointer entityPointer = this.entities.get(entity);
    	if (entityPointer == null) {
    		this.entities.put(entity, this.createEntityPointer(entity));
    	} else {
			setEntityLocation(entityPointer, entity.getCol(), entity.getRow());
    	}
    }
    
    public void clearEntities() {
    	Stack<LocatedOnMap> loms = new Stack<LocatedOnMap>();
    	this.entities.keySet().stream()
    						.forEach((key) -> {
    							EntityPointer entityPointer = this.entities.get(key);
    							if (!entityPointer.doesExist()) {
									this.getChildren().remove(entityPointer);
									loms.add(key);
    							}
    						});
    	loms.stream()
    		.forEach((lom) -> {
    			this.entities.remove(lom);
    		});
    	for(EntityPointer ep : this.entities.values()) {
    		ep.setExists(false);
    	}
    }
    
    private EntityPointer createEntityPointer(LocatedOnMap entity) {
    	String imgPath = this.getImagePath(entity);
    	Image img = new Image(imgPath,this.cellWidth,this.cellHeight,false,true);
    	EntityPointer entityPointer = new EntityPointer(img, this.cellWidth, this.cellHeight);
    	setEntityLocation(entityPointer, entity.getCol(), entity.getRow());
    	this.getChildren().add(entityPointer);
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
    	entity.setExists(true);
    }

    public void showHero(int column, int row) {
    	cells[column][row].showHero();
    }
    
    public void showNPC(int column, int row) {
    	cells[column][row].showNPC();
    }
    
    public void showCraft(int column, int row) {
    	cells[column][row].showCraft();
    }
    
    public void showWall(int column, int row) {
    	cells[column][row].showWall();
    }
    
    public void clearStyle() {
    	for(Cell[] cellArray : this.cells) {
    		for(Cell cell : cellArray) {
    			cell.clearStyle();
    		}
    	}
    }

}
