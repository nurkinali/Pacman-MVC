package Modele;

import java.util.Observable;

public abstract class Entite extends Observable {

	boolean wall;
	int x, y, sizeX, sizeY;
	String position, nextPosition;

	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setWall(boolean wall) {
		this.wall = wall;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getNextPosition() {
		return nextPosition;
	}
	
	public void setNextPosition(String nextPosition) {
		this.nextPosition = nextPosition;
	}
	
	public void up() {
		y = y - 1;
	}
	
	public void down() {
		y = y + 1;
	}
	
	public void left() {
		x = x - 1;
	}
	
	public void right() {
		x = x + 1;
	}
	
	public void begin(int x, int y) {
		this.x = x;
		this.y = y;
	}
}