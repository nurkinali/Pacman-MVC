package pacman.model;

/**
 *
 *
 * <h1>Obstacle</h1>
 *
 * <p>A {@link Obstacle} is a {@link Grid} located in a {@link GameMap}. No {@link MovableGrid} is
 * allowed to move across it.
 *
 * <p>This class extends {@link Grid}.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see Grid
 * @see GameMap
 */
public class Obstacle extends Grid {

  /**
   * Allocates a new {@link Obstacle} object.
   *
   * <p>This constructor sets the {@link Obstacle} in the given position of the given {@link GameMap}, AND sets an image of wall.
   *
   * @param map the {@link GameMap} where this {@link Cookie} stays
   * @param row the row index in the {@link GameMap} where this {@link Obstacle} stays, starting from 0
   * @param column the column index in the {@link GameMap} where this {@link Obstacle} stays, starting
   *     from 0
   */
  public Obstacle(GameMap map, double row, double column) {
    super(map, row, column);

    this.setImage(map.getWallFileName());
  }
}
