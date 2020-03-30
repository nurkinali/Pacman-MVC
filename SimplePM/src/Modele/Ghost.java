package Modele;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Ghost extends Entite implements Runnable{
	
	boolean upFree, downFree, leftFree, rightFree;
	int eatBigPellet, timer;
	
	public Ghost(int sizeX, int sizeY, int x, int y, String position) {
		timer = 0;
		this.x = x;
		this.y = y;			
		downFree = false;
		leftFree = false;
		eatBigPellet = 0;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		nextPosition = "same";
		this.position = position;
	}
	
	public void Dead(int sizeX, int sizeY, int x, int y) {
		timer = 0;
		this.x = x;
		this.y = y;		
		wall = false;
		downFree = false;
		leftFree = false;
		position = "dead";		
		eatBigPellet = 1;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		nextPosition = "same";	
	}
	
	public void setUpFree(boolean upFree) {
		this.upFree = upFree;
	}
	
	public void setDownFree(boolean downFree) {
		this.downFree = downFree;
	}
	
	public void setLeftFree(boolean leftFree) {
		this.leftFree = leftFree;
	}
	
	public void setRightFree(boolean rightFree) {
		this.rightFree = rightFree;
	}
	
	public int getEatBigPellet() {
		return eatBigPellet;
	}
	
	public void setEatBigPellet(int eatBigPellet) {
		this.eatBigPellet = eatBigPellet;
	}
	
	public int getTimer() {
		return timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
	
	public void start() {
		new Thread(this).start();
	}
	
	public void initialization(int sizeX, int sizeY, int x, int y, String position) {
		timer = 0;
		this.x = x;
		this.y = y;
		wall = false;		
		eatBigPellet = 0;
		downFree = false;
		leftFree = false;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.position = position;
	}
	
    @Override
    public void run() {
        
    	while(true) {
    		
    		switch(position) {
    		case "start1":
    			if(!wall) {
    				down();
    				break;
    			}
    			else {
    				left();
    				position = "left";
    				wall = false;
    				break;
    			}
    		case "start2":
    			if(!wall) {
    				down();
    				break;
    			}
    			else {
    				right();
    				position = "right";
    				wall = false;
    				break;
    			}
    		case "up":
    			if(rightFree) {
    				rightFree = false;
    				x = x + 1;
    				position = "right";
    				break;
    			}
    			if(leftFree) {
    				leftFree = false;
    				x = x - 1;
    				position = "left";
    				break;
    			}
    			up();
    			break;
    		case "down":
    			if(rightFree) {
    				rightFree = false;
    				x = x + 1;
    				position = "right";
    				break;
    			}
    			if(leftFree) {
    				leftFree = false;
    				x = x - 1;
    				position = "left";
    				break;
    			}
    			down();
    			break;
    		case "right":
    			if(upFree) {
    				upFree = false;
    				y = y - 1;
    				position = "up";
    				break;
    			}
    			if(downFree) {
    				downFree = false;
    				y = y + 1;
    				position = "down";
    				break;
    			}
    			right();
    			break;
    		case "left":
    			if(upFree) {
    				upFree = false;
    				y = y - 1;
    				position = "up";
    				break;
    			}
    			if(downFree) {
    				downFree = false;
    				y = y + 1;
    				position = "down";
    				break;
    			}
    			left();
    			break;
    			default:
    				if(!wall) {
    					begin(this.x, this.y);
    				}
    				break;
    		}
    		
    		setChanged();
    		notifyObservers();
    		
    		try {
    			Thread.sleep(600);
    		} catch(InterruptedException ex) {
    			Logger.getLogger(SimplePacMan.class.getName()).log(Level.SEVERE, null, ex);
    		}
    
    		if(eatBigPellet == 1) {
    			timer++;
    			if(timer > 15) {
    				timer = 0;
    				eatBigPellet = 0;
    			}
    		}
    	}
    }
}