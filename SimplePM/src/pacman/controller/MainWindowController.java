package pacman.controller;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import pacman.constant.ResourcesFileName;
import pacman.util.SceneSwitch;


public class MainWindowController {


    @FXML
    private Text nickname;

    @FXML
    private TextField nicknameField;

    @FXML
    private ImageView pacmanImage;

    @FXML
    private Button startBtn;

    @FXML
    private Label title;
    
    /**
     * Called when the start menu-item is clicked.
     *
     * <p>This method switches the scene to Select.
     */
    @FXML
    protected void handleStartBtn() {
      SceneSwitch.INSTANCE.switchToMenu();
    }

    /**
     * Called when the exit menu-item is clicked.
     *
     * <p>This method switches the scene to Select.
     */
    @FXML
    public void handleClickExit() {
      SceneSwitch.INSTANCE.exitApplication();
    }
    
   

}
