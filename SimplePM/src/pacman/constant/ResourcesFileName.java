package pacman.constant;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 *
 * <h1>FileName</h1>
 *
 * <p>A {@link ResourcesFileName} is an object to store constant file names.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 */
public class ResourcesFileName {
	
  public static final String QUESTION_JSON_PATH = "\\Questions.json";
  public static final String DEFAULT_MODE_TXT_MAP = "\\pacman\\map\\#001 So Easy.txt";
  public static final String DEFAULT_IMAGE_BACKGROUND = "\\pacman\\image\\floor\\bedrock.png";
  public static final String DEFAULT_OBSTACLE_IMAGE= "\\pacman\\image\\obstacle\\prismarine_bricks.png";
  public static final Set<String> MAPS =
      new TreeSet<>(
          Arrays.asList(
              "\\pacman\\map\\#001 So Easy.txt",
              "\\pacman\\map\\#002 Easy Again?.txt",
              "\\pacman\\map\\#003 A Traitor.txt",
              "\\pacman\\map\\#004 Freedom.txt",
              "\\pacman\\map\\#005 Less is More.txt",
              "\\pacman\\map\\#006 Up and Down.txt",
              "\\pacman\\map\\#007 One Way.txt",
              "\\pacman\\map\\#008 The Maze.txt",
              "\\pacman\\map\\#009 Accel World.txt",
              "\\pacman\\map\\#010 Spires.txt"));

  public static final Set<String> IMAGE_BACKGROUNDS =
      new TreeSet<>(
          Arrays.asList(
              "\\pacman\\image\\floor\\bedrock.png",
              "\\pacman\\image\\floor\\dirt.png",
              "\\pacman\\image\\floor\\gravel.png",
              "\\pacman\\image\\floor\\packed_ice.png",
              "\\pacman\\image\\floor\\polished_andesite.png",
              "\\pacman\\image\\floor\\polished_diorite.png",
              "\\pacman\\image\\floor\\polished_granite.png",
              "\\pacman\\image\\floor\\red_concrete.png",
              "\\pacman\\image\\floor\\red_sand.png",
              "\\pacman\\image\\floor\\red_terracotta.png",
              "\\pacman\\image\\floor\\sandstone.png",
              "\\pacman\\image\\floor\\stone.png"));
  public static final Set<String> IMAGE_OBSTACLES =
      new TreeSet<>(
          Arrays.asList(
              "\\pacman\\image\\obstacle\\prismarine_bricks.png",
              "\\pacman\\image\\obstacle\\red_nether_bricks.png",
              "\\pacman\\image\\obstacle\\stone_bricks.png"));
  public static final String IMAGE_PACMAN = "\\pacman\\image\\pacman.png";
  public static final String IMAGE_COOKIE_SMALL = "\\pacman\\image\\cookie\\cookie1.png";
  public static final String IMAGE_COOKIE_MEDIUM = "\\pacman\\image\\cookie\\cookie5.png";
  public static final String IMAGE_COOKIE_BIG = "\\pacman\\image\\cookie\\cookie10.png";
  public static final Set<String> IMAGE_GHOSTS =
      new HashSet<>(
          Arrays.asList(
              "\\pacman\\image\\ghost\\ghost1.png",
              "\\pacman\\image\\ghost\\ghost2.png",
              "\\pacman\\image\\ghost\\ghost3.png",
              "\\pacman\\image\\ghost\\ghost4.png",
              "\\pacman\\image\\ghost\\ghost5.png",
              "\\pacman\\image\\ghost\\ghost6.png",
              "\\pacman\\image\\ghost\\ghost7.png",
              "\\pacman\\image\\ghost\\ghost8.png",
              "\\pacman\\image\\ghost\\ghost9.png",
              "\\pacman\\image\\ghost\\ghost10.png"));

  public static final String IMAGE_PORTAL_A = "\\pacman\\image\\portal\\portal1.png";
  public static final String IMAGE_PORTAL_B = "\\pacman\\image\\portal\\portal2.png";


  public static final String VIEW_GAME_FXML_PATH = "\\pacman\\view\\game.fxml";
  public static final String MAIN_WINDOW_FXML_PATH = "\\pacman\\view\\mainWindow.fxml";
  public static final String MENU_WINDOW_FXML_PATH = "\\pacman\\view\\menuWindow.fxml";
 

  public static final String RESOURCE_FOLDER_PATH =
	      "C:\\PacMan projects\\Pacman-MVC\\SimplePM\\Resources";
 
  

  public static final String SCORE_BOARD_PATH = RESOURCE_FOLDER_PATH + "scoreboard\\";
}
