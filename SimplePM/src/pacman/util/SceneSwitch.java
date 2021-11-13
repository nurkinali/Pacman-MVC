package pacman.util;

import java.io.File;
import java.net.URL;

import gameMain.Main;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import pacman.constant.ResourcesFileName;
import pacman.controller.GameController;
import pacman.model.GameMap;

/**
 *
 *
 * <h1>SceneSwitch</h1>
 *
 * <p>A {@link SceneSwitch} is an object of utility to provide some methods to switch between
 * different scenes in the primary stage ({@link Main#getPrimaryStage()}).
 *
 * <p><b>Note:</b> this class is implemented an {@link Enum}, thus to be a singleton class.
 *
 * <p>Usage:
 *
 * <blockquote>
 *
 * <pre>
 *    SceneSwitch.INSTANCE.switchToHome();
 * </pre>
 *
 * </blockquote>
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see Main#getPrimaryStage()
 */
public enum SceneSwitch {
  /** The shared instance for global use. */
  INSTANCE;

  /** Hides the primary stage. */
  private void hideStage() {
    Main.getPrimaryStage().hide();
  }

  /** Shows the primary stage. */
  private void showStage() {
    Main.getPrimaryStage().show();
  }

  /**
   * Changes the scene in the primary stage to the given one.
   *
   * @param scene a {@link Scene} object
   */
  private void setScene(Scene scene) {
    Main.getPrimaryStage().setScene(scene);
  }

  /** Switched the current scene to Home. */
  public void switchToHome() {
    try {
      hideStage();
      
      URL url = new File(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.MAIN_WINDOW_FXML_PATH).toURI().toURL();
      Parent root = FXMLLoader.load(url);
      Scene scene = new Scene(root);
      setScene(scene);
      showStage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** Switched the current scene to Select. */
  public void switchToMenu() {
    try {
      hideStage();

      URL url = new File(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.MENU_WINDOW_FXML_PATH).toURI().toURL();
      Parent root = FXMLLoader.load(url);
      Scene scene = new Scene(root);
      setScene(scene);

      showStage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * Switched the current scene to Game.
   *
   * @param map a configured map (passed from {@link pacman.controller.SelectController})
   */
  public void switchToGame(GameMap map) {
    try {
      hideStage();
      
      URL url = new File(ResourcesFileName.RESOURCE_FOLDER_PATH+ResourcesFileName.VIEW_GAME_FXML_PATH).toURI().toURL();
      FXMLLoader loader = new FXMLLoader(url);
      Pane root = loader.load();
      Scene gameScene = new Scene(root);
      setScene(gameScene);

      Pane mapPane = (Pane) gameScene.lookup("#map");
      Canvas canvas = new Canvas();
      mapPane.getChildren().add(canvas);
      map.draw(mapPane);
      mapPane.setStyle(
          "-fx-background-image: url('"
              + map.getBackgroundFileName()
              + "');"
              + "-fx-background-size: "
              + map.getMapConfig().getGridLength()
              + "px "
              + map.getMapConfig().getGridLength()
              + "px;");

      GameController gameController = loader.getController();
      GameManager.INSTANCE.init(map, gameController);

      gameScene.addEventHandler(
          KeyEvent.KEY_PRESSED, event -> GameManager.INSTANCE.handleKeyPressed(event));
      gameScene.addEventHandler(
          KeyEvent.KEY_RELEASED, event -> GameManager.INSTANCE.handleKeyReleased(event));
      showStage();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

 

  public void exitApplication() {
    Platform.exit();
  }
}
