package VueControleur;

import Vue.Vue;
import Modele.Game;

import javafx.stage.Stage;
import javafx.event.EventHandler;
import javafx.scene.layout.StackPane;
import javafx.application.Application;

public class VueControleur extends Application {
	
	Vue vue = new Vue();
	static Game game;
	public StackPane root = new StackPane();

	@Override
	public void start(Stage primaryStage) {
		
		root.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
	        
	        public void handle(javafx.scene.input.KeyEvent event) {
	            switch(event.getCode()) {
	                case UP:
	                	vue.keyboard("up");
	                	break;
	                case DOWN:
	                	vue.keyboard("down");
	                	break;
	                case RIGHT:
	                	vue.keyboard("right");
	                	break;
	                case LEFT:
	                	vue.keyboard("left");
	                	break;
				default:
					break;
	            }
	            
	        }
	    });   
	}
}