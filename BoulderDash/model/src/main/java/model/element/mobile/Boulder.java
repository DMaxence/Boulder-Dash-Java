package model.element.mobile;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.IOException;

import contract.controller.IStrategy;
import contract.controller.UserOrder;
import contract.model.IMap;
import contract.model.element.Permeability;
import contract.model.element.Sprite;
import model.element.strategy.BoulderStrategy;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class Boulder extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('O', Sprite.mapTileSet, new Rectangle(48, 0, 16, 16));
    
    /** The strategy in use by all boulders */
    private static final IStrategy strategy = new BoulderStrategy();
    
    /**
     * Instantiates a new my vehicle.
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
    public Boulder(final int x, final int y, final IMap map) throws IOException{
        super(x, y, sprite, map, Permeability.BLOCKING);
        sprite.loadImage();
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
        //Nop
    }

    @Override
    public final void moveDown() {
        super.moveDown();
    }

    @Override
    protected final void die() {
        //Nop
    }

    @Override
    public final void doNothing() {
        super.doNothing();
    }
    
    /**
     * Executes an action according to the BoulderStrategy.
     * @see BoulderStrategy
     */
	@Override
	public void followMyStrategy() {
		Boulder.strategy.followStrategy(this, this.getMap());
	}
	
	/**
	 * Checks if the boulder can move to the given direction.
	 * Note that this takes account of all pawns including the player.
	 */
	@Override
	protected Boolean pawnsAllowMovementTo(final UserOrder direction) {
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
			return true;
		}
	
		if (this.getMap().getMyCharacter().getPosition().equals(desiredPosition)) {
			return false;
		}
		else {
			return super.pawnsAllowMovementTo(direction);
		}
	}
}
