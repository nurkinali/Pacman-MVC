package pacman.model;

import pacman.constant.ResourcesFileName;
import pacman.constant.PortalType;

/**
 *
 *
 * <h1>Portal</h1>
 *
 * <p>A {@link Portal} is a {@link Grid} located in a {@link GameMap}. It must have a twin {@link
 * Portal}. If any {@link MovableGrid} touches it, the {@link MovableGrid} will be sent to the twin.
 *
 * <p>This class extends {@link Grid}.
 *
 * @author HananSuwan
 * @version 1.0
 * @since 1.0
 * @see Grid
 * @see GameMap
 * @see PortalType
 */
public class Portal extends Grid {

  /**
   * The twin {@link Portal} which is linked to be a position indicator for any grid touches this
   * {@link Portal} to teleport to.
   */
  private Portal twinPortal;

  /**
   * A flag indicates whether or not this {@link Portal} is open. Used to prevent blinking between
   * the twins.
   */
  private boolean isOpen;

  /**
   * Allocates a new {@link Portal} object.
   *
   * <p>This constructor sets the {@link Portal} in the given position of the given {@link GameMap},
   * sets an image of from {@link ResourcesFileName#IMAGE_PORTAL_A} and {@link ResourcesFileName#IMAGE_PORTAL_B} base
   * on the {@link PortalType} parameter.
   *
   * @param map the {@link GameMap} where this {@link Portal} stays
   * @param row the row index in the {@link GameMap} where this {@link Portal} stays, starting from 0
   * @param column the column index in the {@link GameMap} where this {@link Portal} stays, starting
   *     from 0
   * @param portalType the {@link PortalType} of this {@link Portal}; possible values for a correct
   *     image: {@link ResourcesFileName#IMAGE_PORTAL_A}, {@link ResourcesFileName#IMAGE_PORTAL_B}
   */
  public Portal(GameMap map, double row, double column, PortalType portalType) {
    super(map, row, column);

    // set image
    switch (portalType) {
      case A:
        setImage(ResourcesFileName.IMAGE_PORTAL_A);
        break;
      case B:
        setImage(ResourcesFileName.IMAGE_PORTAL_B);
        break;
      default:
        setImage(ResourcesFileName.IMAGE_PORTAL_A);
    }

    // init status
    isOpen = true;
  }

  /**
   * Returns the twin of this {@link Portal}.
   *
   * @return the twin of this {@link Portal}
   */
  public Portal getTwinPortal() {
    return twinPortal;
  }

  /**
   * Sets the twin of this {@link Portal}.
   *
   * @param portal the twin of this {@link Portal}
   */
  public void setTwinPortal(Portal portal) {
    this.twinPortal = portal;
  }

  /** Closes this {@link Portal}. */
  public void close() {
    isOpen = false;
  }

  /** Opens this {@link Portal}. */
  public void open() {
    isOpen = true;
  }

  /**
   * Returns whether or not this {@link Portal} is open.
   *
   * @return {@code true} if this {@link Portal} is open; {@code false} otherwise.
   */
  public boolean isOpen() {
    return isOpen;
  }
}
