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
    private double sidebarWidth = 200;
    private double buttonWidth = 100;
    
    private Stack<KeyCode> keyPressed = new Stack<KeyCode>();;
    private KeyCode[] allowedKeys = {
    			KeyCode.UP,
    			KeyCode.DOWN,
    			KeyCode.LEFT,
    			KeyCode.RIGHT,
    			KeyCode.W,
    			KeyCode.S,
    			KeyCode.A,
    			KeyCode.D,
    			KeyCode.C
    	};

    private String imageURL = "https://opengameart.org/sites/default/files/tileable_grass.png";

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

            // create grid
            Grid grid = new Grid( columns, rows, width, height);

            // fill grid
            for (int row = 0; row < rows; row++) {
                for (int column = 0; column < columns; column++) {

                    Cell cell = new Cell(column, row);

                    grid.add(cell, column, row);
                }
            }
            
            conf.setGrid(grid);

            root.getChildren().addAll(imageView, grid);
           
            ConsoleArea textarea = new ConsoleArea();
            conf.setConsole(textarea);
//            textarea.setStyle("-fx-font-size: em;");
            textarea.setPrefHeight(this.consoleHeight);
            textarea.setMaxWidth(this.width);
            
            Separator sep1 = new Separator();
            Separator sep2 = new Separator();

            VBox vbox = new VBox(root, textarea);
            
            VBox buttons = new VBox();
            buttons.setSpacing(10);
//            Button moveUp = new Button();
//            moveUp.setPrefWidth(100);
            buttons.setPadding(new Insets(0, 20, 10, 20));
            buttons.getChildren().addAll(this.getSidebarButtons());
            HBox hbox = new HBox(vbox, sep1, buttons, sep2);
            
            // create scene and stage
            Scene scene = new Scene(hbox, width + this.sidebarWidth, height + this.consoleHeight);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//            this.clearKeyPressed();
            this.addKeyListeners(scene);

            grid.setChangeFocus(() -> {
            	scene.getRoot().requestFocus();
            	System.out.println("Focus requested by grid");
            });
//            grid.setOnMouseClicked((event) -> {
////            	grid.requestFocus();
//            	scene.getRoot().requestFocus();
//            	System.out.println("Focus requested by grid");
//            });
//            textarea.setOnKeyPressed((event) -> {
//            	scene.getRoot().requestFocus();
//            	System.out.println("Focus requested by textarea");
//            });
//            hbox.setOnKeyPressed((event) -> {
//            	scene.getRoot().requestFocus();
//            	System.out.println("Focus requested by hbox");
//            });
            scene.getRoot().requestFocus();

            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
//    private void clearKeyPressed() {
//    	for(KeyCode key : this.allowedKeys) {
//    		this.keyPressed.put(key, false);
//    	}
//    }
    
    private boolean validMove = false;
    private Moves currMove;
    
    private Moves getMoveFromKey(KeyCode key) {
    	Moves move = null;
    	switch (key) {
			case I: move = Moves.GO_UP; break;
			case K: move = Moves.GO_DOWN; break;
			case J: move = Moves.GO_LEFT; break;
			case L: move = Moves.GO_RIGHT; break;
			case W: move = Moves.ATTACK_UP; break;
			case S: move = Moves.ATTACK_DOWN; break;
			case A: move = Moves.ATTACK_LEFT; break;
			case D: move = Moves.ATTACK_RIGHT; break;
			case C: move = Moves.CRAFT; break;
			default: break;
		}
    	return move;
    }
    
    private Moves getMoveFromDoubleKey(KeyCode firstKey, KeyCode secondKey) {
    	Moves move = null;
		switch (firstKey) {
			case I: 
				switch(secondKey) {
					case L: move = Moves.GO_UP_RIGHT; break;
					case J: move = Moves.GO_UP_LEFT; break;
					default: move = null;
				}
				break;
			case K: 
				switch(secondKey) {
					case L: move = Moves.GO_DOWN_RIGHT; break;
					case J: move = Moves.GO_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case L: 
				switch(secondKey) {
					case I: move = Moves.GO_UP_RIGHT; break;
					case K: move = Moves.GO_DOWN_RIGHT; break;
					default: move = null;
				}
				break;
			case J: 
				switch(secondKey) {
					case I: move = Moves.GO_UP_LEFT; break;
					case K: move = Moves.GO_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case W: 
				switch(secondKey) {
					case D: move = Moves.ATTACK_UP_RIGHT; break;
					case A: move = Moves.ATTACK_UP_LEFT; break;
					default: move = null;
				}
				break;
			case S: 
				switch(secondKey) {
					case D: move = Moves.ATTACK_DOWN_RIGHT; break;
					case A: move = Moves.ATTACK_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			case D: 
				switch(secondKey) {
					case W: move = Moves.ATTACK_UP_RIGHT; break;
					case S: move = Moves.ATTACK_DOWN_RIGHT; break;
					default: move = null;
				}
				break;
			case A: 
				switch(secondKey) {
					case W: move = Moves.ATTACK_UP_LEFT; break;
					case S: move = Moves.ATTACK_DOWN_LEFT; break;
					default: move = null;
				}
				break;
			default: move = null; break;
		}
		return move;
    }

	private void addKeyListeners(Scene scene) {
		scene.setOnKeyPressed((KeyEvent event)->{
//				System.out.println("Key pressed: "+event);
				Moves move = null;
				
				KeyCode key = event.getCode();
//				Boolean value = this.keyPressed.get(key);
//				if (value != null) {
//					this.keyPressed.put(key, true);
//				}
				int keyPressedLength = this.keyPressed.size();
				if (keyPressedLength == 0) {
					System.out.println("KeyPressed 0");
					move = this.getMoveFromKey(key);
					if (move != null) {
						this.keyPressed.push(key);
						this.validMove = true;
						this.currMove = move;
					} else {
						this.validMove = false;
					}
				} else if (keyPressedLength == 1) {
					System.out.println("KeyPressed 1");
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
					System.out.println("KeyPressed " + keyPressedLength);
					this.validMove = false;
				}
			
			}
		);
		scene.setOnKeyReleased((KeyEvent event)->{
//				System.out.println("Key pressed: "+event);
				switch (event.getCode()) {
					case UP:
					case DOWN:
					case LEFT:
					case RIGHT:
					case W:
					case S:
					case A:
					case D:
					case C:
						System.out.println("OnGoing Move: "+this.currMove);
						break;
					default: this.keyPressed.clear(); break;
				}
				if (this.validMove) {
					this.actionHandler.registerMove(this.currMove);
				}
				this.keyPressed.clear();
				this.currMove = null;
				this.validMove = false;
			}
		);
	}
    
	private List<ActionButton> getSidebarButtons() {
    	List<ActionButton> actionButtons = new ArrayList<ActionButton>();
    	
    	for(Moves move : Moves.values()) {
    		ActionButton currButton = new ActionButton(this.buttonWidth, move);
    		currButton.setOnMousePressed(event -> {
    			this.actionHandler.registerMove(move);
    		});
    		actionButtons.add(currButton);
    	}
    	
    	return actionButtons;
//    	return (ActionButton[])actionButtons.toArray();
    }
    
    

//    public static void main(String[] args) {
//    	AppConfiguration conf = AppConfiguration.getInstance();
//    	conf.setRows(5);
//    	conf.setColumns(5);
//        launch(args);
//    }

}