package Modele;

public class Hall extends Case{
	
	private boolean smallPellet;
	private boolean bigPellet;
	
	@Override
	public int type() {
		if(smallPellet == true) {
			return 2;
		}
		else if(bigPellet == true) {
			return 3;
		}
		else {
			return 1;
		}
	}
	
	public Hall(boolean smallPellet, boolean bigPellet) {
		this.smallPellet = smallPellet;
		this.bigPellet = bigPellet;
	}
	
	public Hall() {
		smallPellet = false;
		bigPellet = false;
	}
	
	public boolean isSmallPellet() {
		return smallPellet;
	}
	
	public void setSmallPellet(boolean smallPellet) {
		this.smallPellet = smallPellet;
	}

	public boolean isBigPellet() {
		return bigPellet;
	}
	
	public void setBigPellet(boolean bigPellet) {
		this.bigPellet = bigPellet;
	}
}