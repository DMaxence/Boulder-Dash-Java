package model.element.mobile;

import java.awt.Rectangle;
import java.io.IOException;

import contract.controller.IStrategy;
import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.Permeability;
import contract.model.element.Sprite;
import model.element.strategy.FollowWallAntiClockWiseStrategy;
import model.element.strategy.FollowWallClockWiseStrategy;
import model.element.strategy.NoStrategy;
import model.element.strategy.RandomMonsterStrategy;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class Monster extends Mobile {

	/** The static Constant SPRITE. */
	private static final Sprite sprite = new Sprite('M', Sprite.mapTileSet, new Rectangle(144, 16, 16, 16));
	
	/** The static constant randomStrategy */
	private static final IStrategy randomStrategy = new RandomMonsterStrategy();
	
	/** The static constant followWallClockWiseStrategy */
	private static final IStrategy followWallClockWiseStrategy = new FollowWallClockWiseStrategy();
	
	/** The static constant followWallAntiClockWiseStrategy */
	private static final IStrategy followWallAntiClockWiseStrategy = new FollowWallAntiClockWiseStrategy();
	
	/** The static constant noStrategy */
	private static final IStrategy noStrategy = new NoStrategy();
	
	/** The strategy in use by this monster */
	private IStrategy myStrategy = null;
	
	/** The last wall touched by this monster */
	private UserOrder lastWallTouched = UserOrder.NOP;

	/**
	 * Instantiates a new monster.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param map
	 *            the map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Monster(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
		sprite.loadImage();
		switch ((int) (Math.random() * (3))) {
		case 1:
			this.myStrategy = Monster.randomStrategy;
			break;
		case 2:
			this.myStrategy = Monster.followWallAntiClockWiseStrategy;
			break;
		default:
			this.myStrategy = Monster.followWallClockWiseStrategy;
			break;
		}
	}

	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	@Override
	public final void moveRight() {
		super.moveRight();
	}

	@Override
	public final void moveUp() {
		super.moveUp();
	}

	@Override
	public final void moveDown() {
		super.moveDown();
	}

	@Override
	protected final void die() {
		// Nop
	}

	@Override
	public final void doNothing() {
		super.doNothing();
	}

	/**
	 * Follows the strategy set in myStrategy.
	 */
	@Override
	public void followMyStrategy() {
		this.myStrategy.followStrategy(this, this.getMap());
	}

	@Override
	public UserOrder getLastWallTouched() {
		return this.lastWallTouched;
	}

	@Override
	public void setLastWallTouched(final UserOrder userOrder) {
		this.lastWallTouched = userOrder;
	}
	/**
	 * Sets the strategy to noStrategy.
	 */
	public void removeStrategy() {
		this.myStrategy = Monster.noStrategy;
	}
	
}
