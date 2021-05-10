package com.sample.gui.javafx;

import java.util.ArrayList;
import java.util.List;

import com.sample.Moves;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    
    private double consoleHeight = 100;
    private double sidebarWidth = 200;
    private double buttonWidth = 100;
    
    private String imageURL = "https://opengameart.org/sites/default/files/tileable_grass.png";

    @Override
    public void start(Stage primaryStage) throws Exception{
    	AppConfiguration conf = AppConfiguration.getInstance();
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
           
            TextArea textarea = new TextArea();
            textarea.setStyle("-fx-font-size: 2em;");
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
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
	private List<ActionButton> getSidebarButtons() {
    	List<ActionButton> actionButtons = new ArrayList<ActionButton>();
    	
    	for(Moves move : Moves.values()) {
    		actionButtons.add(new ActionButton(this.buttonWidth, move));
    	}
    	
    	return actionButtons;
//    	return (ActionButton[])actionButtons.toArray();
    }
    
    

    public static void main(String[] args) {
    	AppConfiguration conf = AppConfiguration.getInstance();
    	conf.setRows(5);
    	conf.setColumns(5);
        launch(args);
    }

}