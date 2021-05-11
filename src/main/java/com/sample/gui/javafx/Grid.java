package com.sample.gui.javafx;

import java.util.function.Function;

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
    	System.out.println("Changing Focus");
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
