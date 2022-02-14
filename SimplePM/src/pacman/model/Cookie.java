package pacman.model;

import pacman.constant.ResourcesFileName;

/**
 *
 *
 * <h1>Cookie</h1>
 *
 * <p>A {@link Cookie} is a {@link Grid} located in a {@link GameMap}. It is used for pacman to collect.
 *
 * <p>This class extends {@link Grid}.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see Grid
 * @see GameMap
 */
public class Cookie extends Grid {

  /** The value of {@link PlayerScore} of this cookie. */
  private int value;

  /**
   * Allocates a new {@link Cookie} object.
   *
   * <p>This constructor sets the {@link Cookie} in the given position of the given {@link GameMap}, and
   * sets an image of from {@link ResourcesFileName#IMAGE_COOKIE_SMALL}, {@link ResourcesFileName#IMAGE_COOKIE_MEDIUM}
   * and {@link ResourcesFileName#IMAGE_COOKIE_BIG} base on the {@code value} parameter.
   *
   * @param map the {@link GameMap} where this {@link Cookie} stays
   * @param row the row index in the {@link GameMap} where this {@link Cookie} stays, starting from 0
   * @param column the column index in the {@link GameMap} where this {@link Cookie} stays, starting
   *     from 0
   * @param value the {@link PlayerScore} value of this {@link Cookie}; possible values for a correct
   *     image: 1, 5, 10
   */
  public Cookie(GameMap map, double row, double column, int value) {
    super(map, row, column);

    switch (value) {
      case 1:
        this.setImage(ResourcesFileName.IMAGE_COOKIE_SMALL);
        break;
      case 5:
        this.setImage(ResourcesFileName.IMAGE_COOKIE_MEDIUM);
        break;
      case 10:
        this.setImage(ResourcesFileName.IMAGE_COOKIE_BIG);
        break;
      default:
        this.setImage(ResourcesFileName.IMAGE_COOKIE_SMALL);
    }

    this.value = value;
  }

  /**
   * Returns the value of {@link PlayerScore} of this {@link Cookie}.
   *
   * @return the value of {@link PlayerScore} of this {@link Cookie}
   */
  public int getValue() {
    return value;
  }

  /**
   * Makes this {@link Cookie} eaten and disappear in the screen.
   *
   * <p>The principle of this method is just make it invisible.
   */
  public void eat() {
    setVisible(false);
  }

  /**
   * Tests if this {@link Cookie} still exists (i.e. not eaten yet) in the screen.
   *
   * @return {@code true} if this {@link Cookie} still exists; {@code false} otherwise.
   */
  public boolean isExisting() {
    return isVisible();
  }
}
