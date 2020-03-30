package Modele;

public class Score{
	
	int currentScore, bestScore;
	
	public Score() {
		currentScore = 0;
		bestScore = 0;
	}
	
	public void initialization() {
		currentScore = 0;
	}
	
	public int getCurrentScore() {
		return currentScore;
	}
	
	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}
	
	public int getBestScore() {
		return bestScore;
	}
	
	public void setBestScore(int bestScore) {
		this.bestScore = bestScore;
	}
	
	public void updateBestScore() {
		if(currentScore > bestScore) {
			bestScore = currentScore;
		}
	}
	
	public void addScore(int point) {
		currentScore = currentScore + point;
		updateBestScore();
	}
}