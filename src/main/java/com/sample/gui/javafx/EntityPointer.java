package com.sample.gui.javafx;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityPointer extends ImageView {
	private double cellWidth;
	private double cellHeight;
	private int col;
	private int row;
	
	private boolean exists;
	
	public EntityPointer(Image img) {
		super(img);
	}
	
	public EntityPointer(Image img, double cellWidth, double cellHeight) {
		super(img);
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
		this.setLayoutY(col * this.cellWidth);
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
		this.setLayoutX(row * this.cellHeight);
	}

	public boolean doesExist() {
		return exists;
	}

	public void setExists(boolean exists) {
		this.exists = exists;
	}

}
