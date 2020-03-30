package Vue;

import Modele.Case;
import Modele.Ghost;
import Modele.SimplePacMan;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

public class Vue{
		
	public int SIZE_X = 20;
	public int SIZE_Y = 20;
	
	public Case[][] grid_case = new Case[20][20];
	public int[][] tab_case = {
								{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
					    		{0,3,2,2,2,2,2,2,2,0,2,2,2,2,0,2,2,2,2,0},
					    		{0,2,0,2,0,2,2,0,2,2,2,2,0,3,2,2,2,0,2,0},
					    		{0,2,0,2,0,2,2,0,0,0,0,2,0,0,0,2,2,0,2,0},
					    		{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					    		{0,2,0,2,2,0,0,0,2,2,0,0,0,2,2,2,2,0,2,0},
					    		{0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0,2,0},
					    		{0,2,0,2,2,2,2,0,0,0,0,1,0,0,2,0,2,0,2,0},
					    		{0,2,2,2,0,2,2,1,0,1,1,1,1,1,2,2,2,2,2,0},
					    		{0,0,0,2,0,0,0,1,1,1,1,1,1,0,0,2,2,0,0,0},
					    		{0,0,0,2,0,0,0,1,1,1,1,1,1,0,0,2,2,0,0,0},
					    		{0,2,2,2,0,2,2,1,0,1,1,1,1,1,2,2,2,2,2,0},
					    		{0,2,0,2,2,2,2,0,0,0,0,1,0,0,2,0,2,0,2,0},
					    		{0,2,0,2,2,2,2,2,2,2,2,2,2,2,2,0,2,0,2,0},
					    		{0,2,0,2,2,0,0,0,2,2,0,0,0,2,2,2,2,0,2,0},
					    		{0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
					    		{0,2,0,2,0,2,2,0,0,0,0,2,0,0,0,2,2,0,2,0},
					    		{0,2,0,2,0,2,2,0,2,2,2,2,0,3,2,2,2,0,2,0},
					    		{0,3,2,2,2,2,2,2,2,0,2,2,2,2,0,2,2,2,2,0},
					    		{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
	};
	
	public SimplePacMan spm = new SimplePacMan(SIZE_X, SIZE_Y);
	public Ghost ghost1 = new Ghost(SIZE_X, SIZE_Y, 8, 9, "start1");
	// public Ghost ghost2 = new Ghost(SIZE_X, SIZE_Y, 9, 9, "start1");
	public Ghost ghost3 = new Ghost(SIZE_X, SIZE_Y, 10, 9, "start2");
	public Ghost ghost4 = new Ghost(SIZE_X, SIZE_Y, 11, 9, "start2");
	
	public GridPane grid = new GridPane();
	public StackPane root = new StackPane();
	public int grille[][] = new int[SIZE_X][SIZE_Y];
	public ImageView[][] tab = new ImageView[SIZE_X][SIZE_Y];
	
	public Image pacmanUp = new Image("/Vue/Images/pacmanUp.png");
	public Image pacmanDown = new Image("/Vue/Images/pacmanDown.png");
	public Image pacmanLeft = new Image("/Vue/Images/pacmanLeft.png");	
	public Image pacmanRight = new Image("/Vue/Images/pacmanRight.png");

	public Image ghostRed = new Image("/Vue/Images/ghostRed.png");
	public Image ghostBlue = new Image("/Vue/Images/ghostBlue.png");
	public Image ghostYellow = new Image("/Vue/Images/ghostYellow.png");
	public Image ghostPurple = new Image("/Vue/Images/ghostPurple.png");
	public Image ghostBigPellet = new Image("/Vue/Images/ghostBigPellet.png");	
	
	public Image hall = new Image("/Vue/Images/hall.png");
	public Image wall = new Image("/Vue/Images/wall.png");
	public Image bigPellet = new Image("/Vue/Images/bigPellet.png");
	public Image smallPellet = new Image("/Vue/Images/smallPellet.png");
	
	public void initalization() {
		
		for(int i = 0; i < grille.length; ++i) {
			for(int j = 0; j < grille.length; ++j) {
				grille[i][j] = 0;
			}
		}
		
		for(int i = 0; i < SIZE_X; i++) {
			for(int j = 0; j < SIZE_Y; j++) {
				ImageView img = new ImageView();
				tab[i][j] = img;
				grid.add(img, i, j);
			}
		}
	}
	
	public void tab_initialization(int i, int j) {
		if(spm.getX() == i && spm.getY() == j) {
			switch(spm.getPosition()) {
			case "begin":
				tab[i][j].setImage(pacmanRight);
				break;
			case "up":
				tab[i][j].setImage(pacmanUp);
				break;
			case "down":
				tab[i][j].setImage(pacmanDown);
				break;
			case "right":
				tab[i][j].setImage(pacmanRight);
				break;
			case "left":
				tab[i][j].setImage(pacmanLeft);
				break;
			}
		}
		else if(ghost1.getX() == i && ghost1.getY() == j) {
			switch(ghost1.getEatBigPellet()) {
			case 0: tab[i][j].setImage(ghostRed);
			break;
			case 1: tab[i][j].setImage(ghostBigPellet);
			break;
			}
		}
		/*
		else if(ghost2.getX() == i && ghost2.getY() == j) {
			switch(ghost2.getEatBigPellet()) {
			case 0: tab[i][j].setImage(ghostBlue);
			break;
			case 1: tab[i][j].setImage(ghostBigPellet);
			break;
			}
		}
		*/
		else if(ghost3.getX() == i && ghost3.getY() == j) {
			switch(ghost3.getEatBigPellet()) {
			case 0: tab[i][j].setImage(ghostYellow);
			break;
			case 1: tab[i][j].setImage(ghostBigPellet);
			break;
			}
		}
		else if(ghost4.getX() == i && ghost4.getY() == j) {
			switch(ghost4.getEatBigPellet()) {
			case 0: tab[i][j].setImage(ghostPurple);
			break;
			case 1: tab[i][j].setImage(ghostBigPellet);
			break;
			}
		}
		else if(tab_case[i][j] == 0) {
			tab[i][j].setImage(wall);
		}
		else if(tab_case[i][j] == 1){
			tab[i][j].setImage(hall);
		}
		else if(tab_case[i][j] == 2) {
			if(grille[i][j] == 0) {
				tab[i][j].setImage(smallPellet);
			}
			else {
				tab[i][j].setImage(hall);
			}
		}
		else {
			if(grille[i][j] == 0) {
				tab[i][j].setImage(bigPellet);
			}
			else {
				tab[i][j].setImage(hall);
			}
		}
		
	}
	
	public void keyboard(String a) {
		switch(a) {
		case "up":
			if(tab_case[spm.getX()][spm.getY() - 1] == 0) {
        		spm.setNextPosition("up");
        		break;
        	}
        	else {
        		spm.setWall(false);
        	}
        	spm.setNextPosition("up");
        	spm.setPosition("up");
        	break;
		case "down":
			if(tab_case[spm.getX()][spm.getY() + 1] == 0) {
        		spm.setNextPosition("down");
        		break;
        	}
        	else {
        		spm.setWall(false);
        	}
        	spm.setNextPosition("down");
        	spm.setPosition("down");
        	break;
		case "right":
			if(tab_case[spm.getX() + 1][spm.getY()] == 0) {
        		spm.setNextPosition("right");
        		break;
        	}
        	else {
        		spm.setWall(false);
        	}
        	spm.setNextPosition("right");
        	spm.setPosition("right");
        	break;
		case "left":
			if(tab_case[spm.getX() - 1][spm.getY()] == 0) {
        		spm.setNextPosition("left");
        		break;
        	}
        	else {
        		spm.setWall(false);
        	}
        	spm.setNextPosition("left");
        	spm.setPosition("left");
        	break;
		}
	}
}