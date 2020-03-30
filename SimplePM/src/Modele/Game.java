package Modele;

import Vue.Vue;
import Modele.Score;

import java.util.Observer;
import java.util.Observable;

import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.paint.Color;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.application.Application;

public class Game extends Application {
	
    Vue vue = new Vue();
    @Override
    public void start(Stage primaryStage) {
    	
    	Pane root = new Pane();
    	
    	vue.initalization();
    	Score score = new Score();
              
        Observer o =  new Observer() {
            
        	@Override
            public void update(Observable o, Object arg) {
        		
        		for(int i = 0; i < vue.SIZE_X; i++) {
        			for(int j = 0; j < vue.SIZE_Y; j++) {
        				
        				// Deleting pellets eating by PacMan
        				vue.grille[vue.spm.getX()][vue.spm.getY()] = 1;
        				
        				// Eating small pellets
        				if(vue.tab_case[vue.spm.getX()][vue.spm.getX()] == 2) { 
        					score.addScore(10);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        				
        				// Eating big pellets
        				if(vue.tab_case[vue.spm.getX()][vue.spm.getY()] == 3) {
        					score.addScore(20);
        					vue.ghost1.setEatBigPellet(1);
        					// vue.ghost2.setEatBigPellet(1);
        					vue.ghost3.setEatBigPellet(1);
        					vue.ghost4.setEatBigPellet(1);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        				
        				// Ghosts eaten by PacMan return to the beginning	
        				if(vue.spm.getX() == vue.ghost1.getX() && vue.spm.getY() == vue.ghost1.getY() && vue.ghost1.getEatBigPellet() == 1) {
        					score.addScore(50);
        					vue.ghost1.Dead(vue.SIZE_X, vue.SIZE_Y, 8, 9);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        				/*
        				 if(vue.spm.getX() == vue.ghost2.getX() && vue.spm.getY() == vue.ghost2.getY() && vue.ghost2.getEatBigPellet() == 1) {
        					score.addScore(50);
        					vue.ghost2.Dead(vue.SIZE_X, vue.SIZE_Y, 9, 9);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        				*/
        				if(vue.spm.getX() == vue.ghost3.getX() && vue.spm.getY() == vue.ghost3.getY() && vue.ghost3.getEatBigPellet() == 1) {
        					score.addScore(50);
        					vue.ghost3.Dead(vue.SIZE_X, vue.SIZE_Y, 10, 9);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        				if(vue.spm.getX() == vue.ghost4.getX() && vue.spm.getY() == vue.ghost4.getY() && vue.ghost4.getEatBigPellet() == 1) {
        					score.addScore(50);
        					vue.ghost4.Dead(vue.SIZE_X, vue.SIZE_Y, 11, 9);
        					System.out.println("Score: " +score.getCurrentScore());
        				}
        			
        				// The end
        				if((vue.spm.getX() == vue.ghost1.getX() && vue.spm.getY() == vue.ghost1.getY() && vue.ghost1.getEatBigPellet() == 0) /* || (vue.spm.getX() == vue.ghost2.getX() && vue.spm.getY() == vue.ghost2.getY() && vue.ghost2.getEatBigPellet() == 0) */ || (vue.spm.getX() == vue.ghost3.getX() && vue.spm.getY() == vue.ghost3.getY() && vue.ghost3.getEatBigPellet() == 0) || (vue.spm.getX() == vue.ghost4.getX() && vue.spm.getY() == vue.ghost4.getY() && vue.ghost4.getEatBigPellet() == 0) || (vue.ghost1.getPosition() == "dead" /* && vue.ghost2.getPosition() == "dead" */ && vue.ghost3.getPosition() == "dead" && vue.ghost4.getPosition() == "dead")) {
        					for(int k = 0; k < vue.SIZE_X; ++k) {
        						for(int l = 0; l < vue.SIZE_Y; ++l) {
        							vue.grille[k][l] = 0;
        						}
        					}
        					
        					vue.spm.initialization();
        					score.initialization();
        					vue.ghost1.initialization(vue.SIZE_X, vue.SIZE_Y, 8, 9, "start1");
        				    // vue.ghost2.initialization(vue.SIZE_X, vue.SIZE_Y, 9, 9, "start1");
        				    vue.ghost3.initialization(vue.SIZE_X, vue.SIZE_Y, 10, 9, "start2");
        				    vue.ghost4.initialization(vue.SIZE_X, vue.SIZE_Y, 11, 9, "start2");
        				}
                        
        				// PacMan away from walls
        				switch(vue.spm.getPosition()) {
        				case "up":
        					if(vue.tab_case[vue.spm.getX()][vue.spm.getY() - 1] == 0) {
        						vue.spm.setWall(true);
        					}
        					break;
        				case "down":
        					if(vue.tab_case[vue.spm.getX()][vue.spm.getY() + 1] == 0) {
        						vue.spm.setWall(true);
        					}
        					break;
        				case "left":
        					if(vue.tab_case[vue.spm.getX() - 1][vue.spm.getY()] == 0) {
        						vue.spm.setWall(true);
        					}
        					break;
        				case "right":
        					if(vue.tab_case[vue.spm.getX() + 1][vue.spm.getY()] == 0) {
        						vue.spm.setWall(true);
        					}
        					break;
        				}
        				
        				// Movements of ghosts
        				switch(vue.ghost1.getPosition()) {
        				case "start1":
        					if(vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] == 0) {
        						vue.ghost1.setWall(true);
        					}
        					break;
        				case "up":
        					if((vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] != 0)){
        						switch(vue.ghost1.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] == 0)) {
        						vue.ghost1.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] == 0)) {
        						vue.ghost1.setLeftFree(true);
        					}
        					break;
        				case "down":
        					if((vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] != 0)){
        						switch(vue.ghost1.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] == 0)) {
        						vue.ghost1.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost1.getX() - 1][vue.ghost1.getY()] != 0) && (vue.tab_case[vue.ghost1.getX() + 1][vue.ghost1.getY()] == 0)) {
        						vue.ghost1.setLeftFree(true);
        					}
        					break;
        				case "right":
        					if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] != 0)){
        						switch(vue.ghost1.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setUpFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setDownFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost1.getX()) {
        								vue.ghost1.setDownFree(true);
        								break;
        							}
        							else {
        								vue.ghost1.setUpFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] == 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 1)) {
        						vue.ghost1.setUpFree(true);
        					}
        					if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] == 0)) {
        						vue.ghost1.setDownFree(true);
        					}
        					break;
        					case "left":
        						if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 1)) {
        							switch(vue.ghost1.getEatBigPellet()) {
        							case 0:
            							if(vue.spm.getY() <= vue.ghost1.getY()) {
            								vue.ghost1.setUpFree(true);
            								break;
            							}
            							else {
            								vue.ghost1.setDownFree(true);
            								break;
            							}
            						case 1:
            							if(vue.spm.getX() <= vue.ghost1.getX()) {
            								vue.ghost1.setDownFree(true);
            								break;
            							}
            							else {
            								vue.ghost1.setUpFree(true);
            								break;
            							}
            						}
            					}
            					if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] == 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] != 1)) {
            						vue.ghost1.setUpFree(true);
            					}
            					if((vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() + 1] != 0) && (vue.tab_case[vue.ghost1.getX()][vue.ghost1.getY() - 1] == 0)) {
            						vue.ghost1.setDownFree(true);
            					}
            					break;
        				}
        				/*
        				switch(vue.ghost2.getPosition()) {
        				case "start1":
        					if(vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] == 0) {
        						vue.ghost2.setWall(true);
        					}
        					break;
        				case "up":
        					if((vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] != 0)){
        						switch(vue.ghost2.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] == 0)) {
        						vue.ghost2.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] == 0)) {
        						vue.ghost2.setLeftFree(true);
        					}
        					break;
        				case "down":
        					if((vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] != 0)){
        						switch(vue.ghost2.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] == 0)) {
        						vue.ghost2.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost2.getX() - 1][vue.ghost2.getY()] != 0) && (vue.tab_case[vue.ghost2.getX() + 1][vue.ghost2.getY()] == 0)) {
        						vue.ghost2.setLeftFree(true);
        					}
        					break;
        				case "right":
        					if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] != 0)){
        						switch(vue.ghost2.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setUpFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setDownFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost2.getX()) {
        								vue.ghost2.setDownFree(true);
        								break;
        							}
        							else {
        								vue.ghost2.setUpFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] == 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 1)) {
        						vue.ghost2.setUpFree(true);
        					}
        					if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] == 0)) {
        						vue.ghost2.setDownFree(true);
        					}
        					break;
        					case "left":
        						if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 1)) {
        							switch(vue.ghost2.getEatBigPellet()) {
        							case 0:
            							if(vue.spm.getY() <= vue.ghost2.getY()) {
            								vue.ghost2.setUpFree(true);
            								break;
            							}
            							else {
            								vue.ghost2.setDownFree(true);
            								break;
            							}
            						case 1:
            							if(vue.spm.getX() <= vue.ghost2.getX()) {
            								vue.ghost2.setDownFree(true);
            								break;
            							}
            							else {
            								vue.ghost2.setUpFree(true);
            								break;
            							}
            						}
            					}
            					if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] == 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] != 1)) {
            						vue.ghost2.setUpFree(true);
            					}
            					if((vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() + 1] != 0) && (vue.tab_case[vue.ghost2.getX()][vue.ghost2.getY() - 1] == 0)) {
            						vue.ghost2.setDownFree(true);
            					}
            					break;
        				}
        				*/
        				
        				switch(vue.ghost3.getPosition()) {
        				case "start2":
        					if(vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] == 0) {
        						vue.ghost3.setWall(true);
        					}
        					break;
        				case "up":        				

        					if((vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] != 0)){
        						switch(vue.ghost3.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] == 0)) {
        						vue.ghost3.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] == 0)) {
        						vue.ghost3.setLeftFree(true);
        					}
        					break;
        				case "down":        				

        					if((vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] != 0)){
        						switch(vue.ghost3.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] == 0)) {
        						vue.ghost3.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost3.getX() - 1][vue.ghost3.getY()] != 0) && (vue.tab_case[vue.ghost3.getX() + 1][vue.ghost3.getY()] == 0)) {
        						vue.ghost3.setLeftFree(true);
        					}
        					break;
        				case "right":        					

        					if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] != 0)){
        						switch(vue.ghost3.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setUpFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setDownFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost3.getX()) {
        								vue.ghost3.setDownFree(true);
        								break;
        							}
        							else {
        								vue.ghost3.setUpFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] == 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 1)) {
        						vue.ghost3.setUpFree(true);
        					}
        					if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] == 0)) {
        						vue.ghost3.setDownFree(true);
        					}
        					break;
        					case "left":        				

        						if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 1)) {
        							switch(vue.ghost3.getEatBigPellet()) {
        							case 0:
            							if(vue.spm.getY() <= vue.ghost3.getY()) {
            								vue.ghost3.setUpFree(true);
            								break;
            							}
            							else {
            								vue.ghost3.setDownFree(true);
            								break;
            							}
            						case 1:
            							if(vue.spm.getX() <= vue.ghost3.getX()) {
            								vue.ghost3.setDownFree(true);
            								break;
            							}
            							else {
            								vue.ghost3.setUpFree(true);
            								break;
            							}
            						}
            					}
            					if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] == 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] != 1)) {
            						vue.ghost3.setUpFree(true);
            					}
            					if((vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() + 1] != 0) && (vue.tab_case[vue.ghost3.getX()][vue.ghost3.getY() - 1] == 0)) {
            						vue.ghost3.setDownFree(true);
            					}
            					break;
        				}
        				
        				switch(vue.ghost4.getPosition()) {
        				case "start2":        					

        					if(vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] == 0) {
        						vue.ghost4.setWall(true);
        					}
        					break;
        				case "up":
        					if((vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] != 0)){
        						switch(vue.ghost4.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] == 0)) {
        						vue.ghost4.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] == 0)) {
        						vue.ghost4.setLeftFree(true);
        					}
        					break;
        				case "down":
        					if((vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] != 0)){
        						switch(vue.ghost4.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setLeftFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setRightFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setRightFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setLeftFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] == 0)) {
        						vue.ghost4.setRightFree(true);
        					}
        					if((vue.tab_case[vue.ghost4.getX() - 1][vue.ghost4.getY()] != 0) && (vue.tab_case[vue.ghost4.getX() + 1][vue.ghost4.getY()] == 0)) {
        						vue.ghost4.setLeftFree(true);
        					}
        					break;
        				case "right":
        					if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] != 0)){
        						switch(vue.ghost4.getEatBigPellet()) {
        						case 0:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setUpFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setDownFree(true);
        								break;
        							}
        						case 1:
        							if(vue.spm.getX() <= vue.ghost4.getX()) {
        								vue.ghost4.setDownFree(true);
        								break;
        							}
        							else {
        								vue.ghost4.setUpFree(true);
        								break;
        							}
        						}
        					}
        					if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] == 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 1)) {
        						vue.ghost4.setUpFree(true);
        					}
        					if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] == 0)) {
        						vue.ghost4.setDownFree(true);
        					}
        					break;
        					case "left":
        						if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 1)) {
        							switch(vue.ghost4.getEatBigPellet()) {
        							case 0:
            							if(vue.spm.getY() <= vue.ghost4.getY()) {
            								vue.ghost4.setUpFree(true);
            								break;
            							}
            							else {
            								vue.ghost4.setDownFree(true);
            								break;
            							}
            						case 1:
            							if(vue.spm.getX() <= vue.ghost4.getX()) {
            								vue.ghost4.setDownFree(true);
            								break;
            							}
            							else {
            								vue.ghost4.setUpFree(true);
            								break;
            							}
            						}
            					}
            					if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] == 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] != 1)) {
            						vue.ghost4.setUpFree(true);
            					}
            					if((vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() + 1] != 0) && (vue.tab_case[vue.ghost4.getX()][vue.ghost4.getY() - 1] == 0)) {
            						vue.ghost4.setDownFree(true);
            					}
            					break;
        				}

        				// Movement of PacMan
        				switch(vue.spm.getNextPosition()) {
        				case "up":
        					if((vue.tab_case[vue.spm.getX()][vue.spm.getY() - 1] != 0) && (vue.spm.getNextPosition() == "up")) {
        						vue.spm.setPosition("up");
        						vue.spm.setWall(false);
        					}
        					else {
        						break;
        					}
        					break;
        				case "down":
        					if((vue.tab_case[vue.spm.getX()][vue.spm.getY() + 1] != 0) && (vue.spm.getNextPosition() == "down")) {
        						vue.spm.setPosition("down");
        						vue.spm.setWall(false);
        					}
        					else {
        						break;
        					}
        					break;
        				case "right":
        					if((vue.tab_case[vue.spm.getX() + 1][vue.spm.getY()] != 0) && (vue.spm.getNextPosition() == "right")) {
        						vue.spm.setPosition("right");
        						vue.spm.setWall(false);
        					}
        					else {
        						break;
        					}
        					break;
        				case "left":
        					if((vue.tab_case[vue.spm.getX() - 1][vue.spm.getY()] != 0) && (vue.spm.getNextPosition() == "left")) {
        						vue.spm.setPosition("left");
        						vue.spm.setWall(false);
        					}
        					else {
        						break;
        					}
        					break;
        				}
        				
        				vue.tab_initialization(i, j);
        			}
        		}
        	}
        };
                    
        vue.spm.addObserver(o);
        
        vue.spm.start();
        vue.ghost1.start();
        // vue.ghost2.start();
        vue.ghost3.start();
        vue.ghost4.start();
        
        root.getChildren().add(vue.grid);
        
        Text currentScore = new Text("Score: " +score.getCurrentScore());
        currentScore.setX(5); 
        currentScore.setY(15); 
        
        Scene scene = new Scene(root, 600, 600);

        Text bestScore = new Text("Best Score: " +score.getBestScore());
        bestScore.setX(100);
        bestScore.setY(15);
        
        currentScore.setFill(Color.ANTIQUEWHITE);
        bestScore.setFill(Color.DEEPPINK);
        
        root.getChildren().add(currentScore);
        root.getChildren().add(bestScore);

        primaryStage.setTitle("PacMan");
        primaryStage.setScene(scene);
        primaryStage.show();
                
        root.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() {
            
            @Override
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
                currentScore.setText("Score: " +score.getCurrentScore());
                bestScore.setText("Best Score: " +score.getBestScore());
            }
        });     
        vue.grid.requestFocus();      
    }
    public static void main(String[] args) {
        launch(args);
    }
}