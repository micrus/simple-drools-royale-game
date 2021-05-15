package com.sample.gui.javafx;

import java.util.function.Consumer;

import com.sample.LocatedOnMap;
import com.sample.Observer;
import com.sample.UpdateType;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityPointer extends ImageView implements Observer {
	private String imgPath;
	private double cellWidth;
	private double cellHeight;
	private int col;
	private int row;
	
	private LocatedOnMap lom;
	
	private boolean exists;
	
	private Consumer<EntityPointer> deleteFn;
	
	public EntityPointer(Image img) {
		super();
	}
	
	public EntityPointer(String imgPath, LocatedOnMap lom, double cellWidth, double cellHeight) {
		super(new Image(imgPath, cellWidth, cellHeight, false, true));
		this.imgPath = imgPath;
		this.lom = lom;
		if (!this.lom.isFixed()) {
			this.lom.addObserver(this);
		}
		this.cellWidth = cellWidth;
		this.cellHeight = cellHeight;
	}
	
	public String getImgPath() {
		return this.imgPath;
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
	
	public void setDeleteFn(Consumer<EntityPointer> fn) {
		this.deleteFn = fn;
	}
	private void deleteNode() {
		if (this.deleteFn != null) {
			this.deleteFn.accept(this);
		}
	}
	
	@Override
	public void update(UpdateType ut) {
		Platform.runLater(() -> {
			synchronized(this) {
				switch(ut) {
					case UPDATE: 
						this.setRow(lom.getRow());
						this.setCol(lom.getCol());
						break;
					case DELETED:
						this.lom.removeObserver(this);
						this.deleteNode();
						break;
				}
			}
		});
	}

}
