package model.element.mobile;

import java.awt.Rectangle;
import java.io.IOException;

import model.IMap;
import model.element.Permeability;
import model.element.Sprite;

/**
 * <h1>The MyCharacter Class.</h1>
 *
 * @author Paul
 * @version 0.2
 */
public class MyCharacter extends Mobile {

    /** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 0, 16, 16));

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 16, 16, 16));

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', Sprite.characterTileSet, new Rectangle(16, 48, 16, 16));;

    /** The Constant spriteExplode. */
    private static final Sprite spriteDie   	= new Sprite('H', Sprite.characterTileSet, new Rectangle(64, 0, 16, 16));

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
    public MyCharacter(final int x, final int y, final IMap map) throws IOException{
        super(x, y, sprite, map, Permeability.BLOCKING);
        spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteDie.loadImage();
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveLeft()
     */
    @Override
    public final void moveLeft() {
        super.moveLeft();
        this.setSprite(spriteTurnLeft);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#moveRight()
     */
    @Override
    public final void moveRight() {
        super.moveRight();
        this.setSprite(spriteTurnRight);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#die()
     */
    @Override
    protected final void die() {
        super.die();
        this.setSprite(spriteDie);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.model.element.mobile.Mobile#doNothing()
     */
    @Override
    public final void doNothing() {
        super.doNothing();
        this.setSprite(sprite);
    }
}
