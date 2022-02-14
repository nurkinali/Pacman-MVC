package gameMain;

import java.util.ArrayList;
import java.util.List;

import pacman.constant.QuestionLevel;
import pacman.model.Question;
import pacman.model.SysData;

public class TestQuestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    ArrayList<Question> questions = new  ArrayList<Question>();
	      List<String>answers = new ArrayList<String>();
	      answers.add("Ac");
	      answers.add("Ab");
	    questions.add(new Question ("how is?",answers,1,QuestionLevel.EASY,"animal"));
	   
	    SysData.writeQuestionsToJson(questions);
	    
	}

}
