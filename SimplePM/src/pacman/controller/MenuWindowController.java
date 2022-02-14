package pacman.controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pacman.constant.ResourcesFileName;
import pacman.model.GameMap;
import pacman.util.SceneSwitch;

public class MenuWindowController {

    @FXML
    private Button backBtn;

    @FXML
    private Button historyBtn;

    @FXML
    private Text nickname;

    @FXML
    private Button playBtn;

    @FXML
    private Button viewQuestionsBtn;

    // Handling the back button- opening the main window
    @FXML
    void handleBackBtn(ActionEvent event) throws IOException {
    	 SceneSwitch.INSTANCE.switchToHome();
    }
    
  
    @FXML
    void handlePlayBtn(ActionEvent event) throws IOException {
        GameMap map;
        map = new GameMap();
        map.setNickname(nickname.getText());
        map.setFileName(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.DEFAULT_MODE_TXT_MAP);
        map.setBackgroundFileName(ResourcesFileName.DEFAULT_IMAGE_BACKGROUND);
        map.setWallFileName(ResourcesFileName.DEFAULT_OBSTACLE_IMAGE);
 
        // set up start scene
        SceneSwitch.INSTANCE.switchToGame(map);
    }
    @FXML
    void handleQuestionBtn(ActionEvent event) throws IOException {
      //TODO : Iteration 2
    }

}
