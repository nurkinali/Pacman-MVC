package Modele;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SimplePacMan extends Entite implements Runnable{
		
	public SimplePacMan(int sizeX, int sizeY) {
		x = 10;
		y = 15;
		wall = false;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		position = "begin";
		nextPosition = "same";	
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void initialization() {
		x = 10;
		y = 15;
		wall = false;
		position = "begin";
		nextPosition ="same";
	}
	
	@Override
	public void run() {
		
		while(true) {
			switch(position) {
			case "up":
				if(!wall) {
					up();
					break;
				}
			case "down":
				if(!wall) {
					down();
					break;
				}
			case "right":
				if(!wall) {
					right();
					break;
				}
			case "left":
				if(!wall) {
					left();
					break;
				}
				default:
					if(!wall) {
						begin(this.x, this.y);
						break;
					}
			}
			
			setChanged();
			notifyObservers();
			
			try {
				Thread.sleep(300);
			}
			catch(InterruptedException ex) {
				Logger.getLogger(SimplePacMan.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
		
	}
}