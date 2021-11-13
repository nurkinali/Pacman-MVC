package pacman.model;

import java.io.Serializable;
import java.util.List;

import pacman.constant.QuestionLevel;

public class Question implements Serializable {
	
	private String question ;
	private List<String> answers ;
	private int correct_ans;
	private QuestionLevel level;
	private String team;
 
	 
    public Question(String question,List<String>answers, int correct_ans,QuestionLevel level,String team) {
        super();
        this.question = question;
        this.answers = answers;
        this.correct_ans = correct_ans;
        this.level = level;
        this.team = team;
    }
 
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public List<String> getAnswers() {
		return answers;
	}
	public void setAnswers(List<String> answers) {
		this.answers = answers;
	}
	public int getCorrect_ans() {
		return correct_ans;
	}
	public void setCorrect_ans(int correct_ans) {
		this.correct_ans = correct_ans;
	}
	public QuestionLevel getLevel() {
		return level;
	}
	public void setLevel(QuestionLevel level) {
		this.level = level;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
}
