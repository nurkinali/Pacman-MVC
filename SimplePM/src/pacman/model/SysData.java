package pacman.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import pacman.constant.QuestionLevel;
import pacman.constant.ResourcesFileName;
public class SysData {
	public static void writeQuestionsToJson(ArrayList<Question> questionList) {
		try {
		JSONArray questionsList = new JSONArray();
		for(Question que : questionList) {
			JSONObject questionDetails = new JSONObject();
			questionDetails.put("question", que.getQuestion());
			questionDetails.put("answers", que.getAnswers());
			questionDetails.put("correct_ans",que.getAnswers().indexOf(que.getCorrect_ans())+1);
			questionDetails.put("level", que.getLevel().getValue());
			questionDetails.put("team", que.getTeam());
			questionsList.add(questionDetails);
		}
		JSONObject obj = new JSONObject();
		obj.put("questions", questionsList);
		FileWriter file = new FileWriter(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.QUESTION_JSON_PATH);
		file.write(obj.toJSONString());
		file.flush();
		
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	
	
	public static ArrayList<Question>  readQuestionsFromJson() {
		JSONParser parser = new JSONParser();
		ArrayList<Question> questionsToReturn = new ArrayList<Question>();
		try {
			Object obj = parser.parse(new FileReader(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.QUESTION_JSON_PATH));
			
			JSONObject jsonObject = (JSONObject) obj;
			
			JSONArray questionsList = (JSONArray) jsonObject.get("questions");
			
			Iterator<JSONObject> iterator = questionsList.iterator();
			ArrayList<JSONObject> allQuestions = new ArrayList<JSONObject>();
			
			while(iterator.hasNext()) {
				allQuestions.add(iterator.next());
			}
			
		
			for(JSONObject temp : allQuestions) {
				String quesContent = temp.get("question").toString();
				String level = temp.get("level").toString();
				int correctAns = Integer.parseInt(temp.get("correct_ans").toString());
				ArrayList<String> answers =(ArrayList<String>) temp.get("answers");
				String team = temp.get("team").toString();
			 
				Question question = new Question(quesContent,answers,correctAns
						,QuestionLevel.GetQuestionLevel(level),team);
				questionsToReturn.add(question);
			}
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return questionsToReturn;
	}
	

}
