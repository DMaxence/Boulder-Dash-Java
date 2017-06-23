package model.element.mobile;

import java.awt.Point;
import java.io.IOException;

import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.Permeability;
import contract.model.element.Sprite;
import contract.model.element.mobile.IMobile;
import element.Element;
import element.elementfactory.ElementFactory;
import fr.exia.showboard.IBoard;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Paul
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

	/** The x and y. */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	/** The map. */
	private IMap map;

	/** The board. */
	private IBoard board;

	/** The FallSpeed */
	private boolean fallSpeed = false;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.map = map;
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param sprite
	 *            the sprite
	 * @param map
	 *            the map
	 * @param permeability
	 *            the permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		// Following code will not work: if (0, y) or (x, 0) is BLOCKING,
		// The game will end instanty. We have to set the initial position
		// without
		// Checking for collisions
		// this.setX(x);
		// this.setY(y);

		this.getPosition().x = x;
		this.getPosition().y = y;
	}

	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
		this.fallSpeed = true;
	}

	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	@Override
	public void doNothing() {
		this.setHasMoved();
		this.fallSpeed = false;
	}

	/**
	 * Sets the has moved.
	 */
	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	@Override
	public final int getX() {
		return this.getPosition().x;
	}

	public final void setX(final int x) {
		this.getPosition().x = x;
		if (this.isCrushed()) {
			this.die();
		}
	}

	/**
	 * Places dug dirt on the mobile's location.
	 */
	public void digDirt() {
		this.getMap().setOnTheMapXY(this.getX(), this.getY(), ElementFactory.createDugDirt());
		try {
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	public final void setY(final int y) {
		this.getPosition().y = y;
		if (this.isCrushed()) {
			this.die();
		}
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap() {
		return this.map;
	}

	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	/**
	 * Dies.
	 */
	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	/**
	 * @return Whether the mobile is crushed by a boulder of in a blocking
	 *         entity.
	 */
	@Override
	public Boolean isCrushed() {
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getSprite().getConsoleImage() == 'O' || pawn.getSprite().getConsoleImage() == 'V') {
				if (pawn.getPosition().x == this.getPosition().x
						&& pawn.getPosition().y == this.getPosition().y - 1 && pawn.isFalling()) {
					return true;
				}
			}
		}
		return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
	}

	/**
	 * @return Whether mapAllowsMovementTo and pawnAllowsMovementTo are both
	 *         true.
	 * 
	 */
	@Override
	public Boolean canMoveTo(final UserOrder direction) {
		return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
	}

	/**
	 * 
	 * @param direction
	 * @return Whether the map permeability is PENETRABLE at the given
	 *         direction, compared to the current location.
	 */
	protected boolean mapAllowsMovementTo(final UserOrder direction) {
		switch (direction) {
		case UP:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
					.getPermeability() == Permeability.PENETRABLE;
		case DOWN:
			return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
					.getPermeability() == Permeability.PENETRABLE;
		case RIGHT:
			return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE;
		case LEFT:
			return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
					.getPermeability() == Permeability.PENETRABLE;
		case NOP:
		default:
			return true;
		}
	}

	/**
	 * This method does NOT test the position of the player.
	 * 
	 * @param direction
	 * @return if the pawn can step to the given direction
	 */
	protected Boolean pawnsAllowMovementTo(final UserOrder direction) {
		Point desiredPosition = this.getPositionFromUserOrder(direction);
		for (IMobile pawn : this.getMap().getPawns()) {
			if (pawn.getPosition().equals(desiredPosition)) {
				if (pawn.getPermeability() != Permeability.PENETRABLE) {
					return false;
				} else {
					return true;
				}
			}
		}

		return true;
	}
	
	protected Point getPositionFromUserOrder(final UserOrder direction){
		Point desiredPosition = null;
		switch (direction) {
		case UP:
			desiredPosition = new Point(this.getX(), this.getY() - 1);
			break;
		case DOWN:
			desiredPosition = new Point(this.getX(), this.getY() + 1);
			break;
		case RIGHT:
			desiredPosition = new Point(this.getX() + 1, this.getY());
			break;
		case LEFT:
			desiredPosition = new Point(this.getX() - 1, this.getY());
			break;
		case NOP:
		default:
			desiredPosition = new Point(this.getX(), this.getY());
			break;
		}
		
		return desiredPosition;
	}

	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position
	 *            the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

	@Override
	public boolean isFalling() {
		return fallSpeed;
	}

	/**
	 * Removes this pawn from the board
	 */
	@Override
	public void removeFromBoard() {
		this.setPosition(new Point(1, -1));
		this.getMap().getPawns().remove(this);
	}

	/**
	 * @return Where the last touched wall was. By default NOP. Must be
	 *         overriden by monsters.
	 */
	@Override
	public UserOrder getLastWallTouched() {
		// nop
		return UserOrder.NOP;
	}

	/**
	 * Must be overriden by monsters.
	 * 
	 * @param userOrder
	 *            Where the touched wall is
	 * 
	 */
	@Override
	public void setLastWallTouched(final UserOrder userOrder) {
		// nop
	}
}
