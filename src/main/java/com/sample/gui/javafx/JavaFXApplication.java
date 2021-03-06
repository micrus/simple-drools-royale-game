package com.sample.gui.javafx;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import com.sample.Moves;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;;

public class JavaFXApplication extends Application {

    boolean showHoverCursor = true;

    int rows;
    int columns;
    double width;
    double height;
    
    private ActionHandler actionHandler;
    
    private double consoleHeight = 100;
    private double sidebarWidth = 400;
    private double buttonWidth = 100;
    
    private Stack<KeyCode> keyPressed = new Stack<KeyCode>();;

    private String imageURL = "file:assets/map_darker.png";

    @Override
    public void start(Stage primaryStage) throws Exception{
    	AppConfiguration conf = AppConfiguration.getInstance();
    	this.actionHandler = ActionHandler.getInstance();
    	this.rows = conf.getRows();
    	this.columns = conf.getColumns();
    	this.width = conf.getWidth();
    	this.height = conf.getHeight();
    	
    	try {
            StackPane root = new StackPane();
			ImageView imageView = new ImageView( new Image(this.imageURL, this.width, this.height, false, false));

            Grid grid = new Grid( columns, rows, width, height);
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {
                    Cell cell = new Cell(column, row);
                    grid.add(cell, column, row);
                }
            }

            root.getChildren().addAll(imageView, grid);
           
            ConsoleArea textarea = new ConsoleArea();
            textarea.setPrefHeight(this.consoleHeight);
            textarea.setMaxWidth(this.width);

            

            VBox vbox = new VBox(root, textarea);
//            vbox.setPadding(new Insets(10, 10, 10, 10));
            
//            VBox buttons = new VBox();
            
//            buttons.setSpacing(10);
//            Button moveUp = new Button();
//            moveUp.setPrefWidth(100);
//            buttons.setPadding(new Insets(0, 20, 10, 20));
//            buttons.getChildren().addAll(this.getSidebarButtons());
            HUDSidebar sidebar = new HUDSidebar(this.sidebarWidth);
            sidebar.setPadding(new Insets(10, 10, 10, 10));
            HBox hbox = new HBox(vbox, sidebar);
            
            // create scene and stage
            Scene scene = new Scene(hbox, width + this.sidebarWidth, height + this.consoleHeight);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            this.clearKeyPressed();
            this.addKeyListeners(scene);

            scene.getRoot().requestFocus();

            primaryStage.setScene(scene);
            primaryStage.show();

            conf.setGameView(new GameView(grid, textarea, sidebar, primaryStage));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private boolean validMove = false;
    private Moves currMove;
    
    private Moves getMoveFromKey(KeyCode key) {
    	Moves move = null;
    	switch (key) {
			case W: move = Moves.GO_UP; break;
			case S: move = Moves.GO_DOWN; break;
			case A: move = Moves.GO_LEFT; break;
			case D: move = Moves.GO_RIGHT; break;
			case I: move = Moves.ATTACK_UP; break;
			case K: move = Moves.ATTACK_DOWN; break;
			case J: move = Moves.ATTACK_LEFT; break;
			case L: move = Moves.ATTACK_RIGHT; break;
			case C: move = Moves.CRAFT; break;
			case T: move = Moves.PUT_TRAP; break;
			default: break;
		}
    	return move;
    }
    
    private Moves getMoveFromDoubleKey(KeyCode firstKey, KeyCode secondKey) {
    	Moves move = null;
		switch (firstKey) {
			case W: 
				switch(secondKey) {
					case D: move = Moves.GO_UP_RIGHT; break;
					case A: move = Moves.GO_UP_LEFT; break;
					default: move = null;
				}
				break;
			case S: 
				switch(secondKey) {
					case D: move = Moves.GO_DOWN_RIGHT; break;
					case A: move = Moves.GO_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case D: 
				switch(secondKey) {
					case W: move = Moves.GO_UP_RIGHT; break;
					case S: move = Moves.GO_DOWN_RIGHT; break;
					default: move = null;
				}
				break;
			case A: 
				switch(secondKey) {
					case W: move = Moves.GO_UP_LEFT; break;
					case S: move = Moves.GO_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case I: 
				switch(secondKey) {
					case L: move = Moves.ATTACK_UP_RIGHT; break;
					case J: move = Moves.ATTACK_UP_LEFT; break;
					default: move = null;
				}
				break;
			case K: 
				switch(secondKey) {
					case L: move = Moves.ATTACK_DOWN_RIGHT; break;
					case J: move = Moves.ATTACK_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case L: 
				switch(secondKey) {
					case I: move = Moves.ATTACK_UP_RIGHT; break;
					case K: move = Moves.ATTACK_DOWN_RIGHT; break;
					default: move = null;
				}
				break;
			case J: 
				switch(secondKey) {
					case I: move = Moves.ATTACK_UP_LEFT; break;
					case K: move = Moves.ATTACK_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			default: move = null; break;
		}
		return move;
    }

	private void addKeyListeners(Scene scene) {
		scene.setOnKeyPressed((KeyEvent event)->{
			synchronized(this) {
				Moves move = null;
				
				KeyCode key = event.getCode();

				int keyPressedLength = this.keyPressed.size();
				if (keyPressedLength == 0) {
					move = this.getMoveFromKey(key);
					if (move != null) {
						this.keyPressed.push(key);
						this.validMove = true;
						this.currMove = move;
					} else {
						this.validMove = false;
					}
				} else if (keyPressedLength == 1) {
					KeyCode firstKey = this.keyPressed.firstElement();
					this.keyPressed.add(key);
					move = this.getMoveFromDoubleKey(firstKey, key);
					if (move != null) {
						this.validMove = true;
						this.currMove = move;
					} else {
						this.validMove = false;
					}
				} else if (keyPressedLength > 2) {
					this.validMove = false;
				}
			}
		});
		scene.setOnKeyReleased((KeyEvent event)->{
			synchronized(this) {
				if (this.validMove) {
					this.actionHandler.registerMove(this.currMove);
				}
				this.keyPressed.clear();
				this.currMove = null;
				this.validMove = false;
			}
		});
	}
    

}