package com.sample.gui.javafx;

import java.util.function.Consumer;

import com.sample.LocatedOnMap;
import com.sample.Observer;
import com.sample.UpdateType;

import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EntityPointer extends ImageView implements Observer {
	private String folderPath;
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
	
	public EntityPointer(String folderPath, String baseImg,  LocatedOnMap lom, double cellWidth, double cellHeight) {
		super(new Image(folderPath+baseImg, cellWidth, cellHeight, false, true));
		this.folderPath = folderPath;
		this.imgPath = baseImg;
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
	
	private void setSpriteOnMovement() {
		String imgPath = "down_1";
		if (this.col <= this.lom.getCol() ) {
			imgPath = "down_1";
		} else {
			imgPath = "up_1";
		}
		
		if (this.row < this.lom.getRow()) {
			imgPath = "right_1";
		} else if (this.row > this.lom.getRow()) {
			imgPath = "left_1";
		}
		this.imgPath = imgPath+".png";
//		System.out.println(this.lom.getSimbol()+": "+this.col+" "+this.lom.getCol()+" - "+this.row+" "+this.lom.getRow());
//		System.out.println(this.imgPath);
		this.setImage(new Image(this.folderPath + this.imgPath, this.cellWidth, this.cellWidth, false, true));
	}
	
	private void move() {
		this.setSpriteOnMovement();
		this.setRow(lom.getRow());
		this.setCol(lom.getCol());
	}
	
	@Override
	public void update(UpdateType ut) {
		Platform.runLater(() -> {
			synchronized(this) {
				switch(ut) {
					case MOVE: 
						this.move();
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
