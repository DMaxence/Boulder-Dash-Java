package model.element.mobile;

import java.awt.Rectangle;
import java.io.IOException;

import contract.controller.IStrategy;
import contract.model.IMap;
import contract.model.element.Permeability;
import contract.model.element.Sprite;
import model.element.strategy.BoulderStrategy;
import model.element.strategy.DiamondStrategy;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class Diamond extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite('V', Sprite.mapTileSet, new Rectangle(64, 0, 16, 16));

	private static final IStrategy strategy = new DiamondStrategy();

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
	public Diamond(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.MINEABLE);
		sprite.loadImage();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
	 */
	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveRight() {
		super.moveRight();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveUp() {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveDown() {
		super.moveDown();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
	 */
	@Override
	protected final void die() {
		// Nop
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
	 */
	@Override
	public final void doNothing() {
		super.doNothing();
	}
	
    /**
     * Executes an action according to the DiamondStrategy.
     * @see BoulderStrategy
     */
	@Override
	public void followMyStrategy() {
		Diamond.strategy.followStrategy(this, this.getMap());
	}
}
