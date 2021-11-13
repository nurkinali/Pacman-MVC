package pacman.constant;

/**
 *
 *
 * <h1>GameStatus</h1>
 *
 * <p>A {@link QuestionLevel} is an enum object to store constant names of game status.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see pacman.util.GameManager
 */
public enum QuestionLevel {
  EASY(1), MEDIUM(2), HARD(3);

  private final int value;
  private QuestionLevel(int value) {
      this.value = value;
  }

  public int getValue() {
      return value;
  }
  
	public static QuestionLevel GetQuestionLevel(String level)
	{
		if(level=="1")
			return QuestionLevel.EASY;
		else if(level=="1") 
			return QuestionLevel.MEDIUM;
		return QuestionLevel.HARD;
	}
  
}
