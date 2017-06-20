package model.element.mobile;

import java.awt.Rectangle;
import java.io.IOException;

import controller.IStrategy;
import model.IMap;
import model.element.Permeability;
import model.element.Sprite;
import model.element.strategy.RandomMonsterStrategy;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class Monster extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('M', Sprite.mapTileSet, new Rectangle(144, 16, 16, 16));
    
    private static final IStrategy randomStrategy = new RandomMonsterStrategy();
    private static final IStrategy followWallClockWiseStrategy = new RandomMonsterStrategy();
    private static final IStrategy followWallAntiClockWiseStrategy = new RandomMonsterStrategy();
    private IStrategy myStrategy = null;
    /**
     * Instantiates a new my vehicle.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @param road
     *            the road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public Monster(final int x, final int y, final IMap map) throws IOException{
        super(x, y, sprite, map, Permeability.BLOCKING);
        sprite.loadImage();
        switch ((int)(Math.random() * (3))) {
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

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveUp() {
        super.moveUp();
    }
    
    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveDown() {
        super.moveDown();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        //Nop
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
    }

	@Override
	public void followMyStrategy() {

		this.myStrategy.followStrategy(this, this.getMap());
	}
}
