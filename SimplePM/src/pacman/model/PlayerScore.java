package pacman.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * <h1>Score</h1>
 *
 * <p>A {@link PlayerScore} is an object to keep the record of the play's score in a single run.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see ScoreBoard
 */
public class PlayerScore implements Serializable {

  /** The value of the score. */
  private int scoreValue;
  /** The player's name. */
  private String nickname;
  /** The time when the score settles. */
  private Date time;
  
  /** The upper limit of life */
  private int totalLives;
  /** The remaining life. */
  private int remainingLives;
  private int DEFAULT_TOTAL_LIVES=3;

  /**
   * Allocates a new {@link PlayerScore} object.
   *
   * <p>This constructor initializes the {@link #scoreValue} to {@code 0}, records the {@link #nickname}
   * and sets the {@link #time} to the current time.
   *
   * @param nickname the player's nickname.
   */
  public PlayerScore(String nickname) {
    this.scoreValue = 0;
    this.nickname = nickname;
    this.time = new Date();
    totalLives=DEFAULT_TOTAL_LIVES;
  }

  /**
   * Allocates a new {@link PlayerScore} object.
   *
   * <p>This constructor does the same thing as {@link PlayerScore} does, but with a default {@link
   * #nickname} {@code "Unknown Player"} initialized.
   */
  public PlayerScore() {
    this("Unknown Player");
  }

   public void loseLives() {
	  remainingLives--;
    if (remainingLives < 0) {
    	remainingLives = 0;
    }
  }

  /** Increases the {@link #remaining} life by {@code 1} (maximum to {@link #total}). */
  public void gain() {
	  remainingLives++;
    if (remainingLives > totalLives) {
    	remainingLives = totalLives;
    }
  }

 
  public int getRemainingLives() {
    return remainingLives;
  }
 
  public int getTotalLives() {
    return totalLives;
  }
  /**
   * Increases the {@link #scoreValue} by the given {@code value}.
   *
   * @param value an integer to be added to the {@link #scoreValue}.
   */
  public void gain(int value) {
    this.scoreValue += value;
  }

  /**
   * Decreases the {@link #scoreValue} by the given {@code value}.
   *
   * @param value an integer to be added to the {@link #scoreValue}.
   */
  public void lose(int value) {
    this.scoreValue -= value;
    loseLives();
  }

  /** Settles the score. That is: changes the {@link #time} to the current time. */
  public void settle() {
    this.time = new Date();
  }

  /**
   * Returns the {@link #scoreValue}.
   *
   * @return an integer indicating the value of score.
   */
  public int getScoreValue() {
    return scoreValue;
  }

  /**
   * Returns the player's {@link #nickname}.
   *
   * @return the player's {@link #nickname}.
   */
  public String getNickname() {
    return nickname;
  }

  /**
   * Returns the time when the {@link PlayerScore} is settled.
   *
   * @return the time when the {@link PlayerScore} is settled.
   */
  public Date getTime() {
    return time;
  }
}
